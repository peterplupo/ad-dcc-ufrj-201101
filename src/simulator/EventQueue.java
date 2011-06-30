package simulator;

import java.util.LinkedList;

/**
 * Classe para controlar a fila de eventos
 * @author dalves
 *
 */
//Contem um object EventClassA para indicar quando eh a proxima chegada na fila 1 e uma fila de EventClassB para as chegadas na fila 2 ainda nao processadas
public class EventQueue {
	private EventClassA chegada1;
	private LinkedList<EventClassB> queue;
	private int color;
	private double tempo, stop, interval;
	private RandomExponentialVariable exponencialServico;
	private double taxaServico;
	private MetricsCollection metricsCollection;
	private double taxaChegada;
	private RandomExponentialVariable exponencialChegada;
	
	public EventQueue(double useRate) {
		interval = stop = tempo = 0;
		color = 0;
		chegada1 = new EventClassA(0, color);
		queue = new LinkedList<EventClassB>();
		taxaServico = 1;
		exponencialServico = new RandomExponentialVariable(taxaServico);
		metricsCollection = new MetricsCollection();
		taxaChegada = useRate / 2;
		exponencialChegada = new RandomExponentialVariable(taxaChegada);
	}
	
	/**
	 * Metodo para testar a logica da fila
	 * @return deve ser igual a 
	 */
	public String testProcessing() {
		interval = stop = tempo = 0;
		color = 0;
		chegada1 = new EventClassA(0, color);
		EventClassB chegada2 = queue.peekFirst();
		String progressao = Double.toString(tempo);
		
		double tempoServico = 1;
		double tempoDisponivel;
		double proximaChegada = 0;
		
		while (!queue.isEmpty()) {
			queue.pop();
			
		}
		for (int i = 1; i <= 10; ++i) {
			switch (i) {
			case 1:
				tempoServico = 1;
				proximaChegada = 2;
				break;
			case 2:
				tempoServico = 1;
				break;
			case 3:
				tempoServico = 2;
				proximaChegada = 3;
				break;
			case 4:
				tempoServico = 2;
				proximaChegada = 8;
				break;
			case 5:
				tempoServico = 1;
				break;
			case 6:
				tempoServico = 2;
				break;
			case 7:
				tempoServico = 1;
				proximaChegada = 20;
				break;
			case 8:
				tempoServico = 2;
				break;
			case 9:
				tempoServico = 1;
				break;
			case 10:
				tempoServico = 1;
				break;
			}
			chegada2 = queue.peekFirst();
			if (queue.isEmpty() || chegada1.getTime() <= chegada2.getTime() || tempo >= chegada1.getTime()) {
				//trata chegada1
				System.out.println("1: " + chegada1.getTime() + "|" + tempo + "|" + tempoServico);
				if (tempo < chegada1.getTime()) {
					tempo = chegada1.getTime();
				}
				chegada1.servir(tempo, tempoServico);
				tempo += tempoServico;
				if (chegada1.getColor() == color) {
					metricsCollection.collect(chegada1, getTimeInterval());
				}
				chegada1 = new EventClassA(proximaChegada, color);
				queue.add(new EventClassB(tempo, color));
			} else {
				//trata chegada2
				tempoDisponivel = chegada1.getTime() - tempo;
				System.out.println("2: " + chegada2.getTime() + "|" + tempo + "|" + tempoServico + "|" + tempoDisponivel + "|" + chegada2.getTempoRestante());
				
				if (tempo < chegada2.getTime()) {
					tempo = chegada2.getTime();
				}
				
				if (chegada2.hasServico()) {
					tempoServico = chegada2.getTempoRestante();
					chegada2.continuarServico(tempo, tempoDisponivel);
				} else {
					chegada2.iniciarServico(tempo, tempoServico, tempoDisponivel);
				}
				
				if (chegada2.hasServico()) {
					tempo += tempoDisponivel;
				} else {
					tempo += tempoServico;
					if (chegada2.getColor() == color) {
						metricsCollection.collect(chegada2, getTimeInterval());
					}
					queue.pop();
				}
			}
			progressao += "-" + tempo;
		}
		
		System.out.println(progressao);
		
		return progressao;
	}
	
	/**
	 * Metodo para processar o proximo evento,
	 * realizando as operações necessárias na fila
	 * e capturando as métricas
	 */
	public void processNextEvent() {
		/*
		 * logica implementada:
		 * verifica quando ocorre a proxima chegada1
		 * verifica quando ocorre a proxima chegada2
		 * Se a chegada1 for primeiro (ou não há chegada2 na fila), trata-a e avança o relogio
		 * senão, verifica quanto tempo ha disponivel ate a proxima chegada1 e trata o quanto puder a 2
		 */
		EventClassB chegada2 = queue.peekFirst();
		
		interval = tempo - stop;

		/*
		 * Trata a chegada 1 se não houver chegadas 2, se a próxima chegada 1 for antes da próxima chegada 2
		 * ou se já houver uma chegada 1
		 */
		if (queue.isEmpty() || chegada1.getTime() <= chegada2.getTime() || tempo >= chegada1.getTime()) {
			//trata chegada1
			//System.out.println("Tratando chegada 1");
			processEventClassA();
		} else {
			//trata chegada2
			processEventClassB(chegada1.getTime() - tempo);
		}
	}
	
	/**
	 * Serve um fregues na primeira fila
	 */
	private void processEventClassA() {
		double tempoServico = exponencialServico.getValue();
		
		if (tempo < chegada1.getTime()) {
			tempo = chegada1.getTime();
		}
		chegada1.servir(tempo, tempoServico);
		tempo += tempoServico;
		if (chegada1.getColor() == color) {
			metricsCollection.collect(chegada1, getTimeInterval());
		}
		chegada1 = new EventClassA(chegada1.getTime() + exponencialChegada.getValue(), color);
		queue.add(new EventClassB(tempo, color));
	}

	/**
	 * Serve um fregues da segunda fila enquanto houver tempo disponivel, marcando-o como
	 * em servico se for interrompido por uma chegada na outra fila
	 * @param tempoDisponivel
	 */
	private void processEventClassB(double tempoDisponivel) {
		EventClassB event = queue.peekFirst();
		double tempoServico;
		
		if (tempo < event.getTime()) {
			tempo = event.getTime();
		}
		
		if (event.hasServico()) {
			tempoServico = event.getTempoRestante();
			event.continuarServico(tempo, tempoDisponivel);
		} else {
			tempoServico = exponencialServico.getValue();
			event.iniciarServico(tempo, tempoServico, tempoDisponivel);
		}
		
		if (event.hasServico()) {
			//System.out.println("Ainda resta.");
			tempo += tempoDisponivel;
		} else {
			//System.out.println("Terminou");
			tempo += tempoServico;
			if (event.getColor() == color) {
				metricsCollection.collect(event, getTimeInterval());
			}
			queue.pop();
		}
	}
	
	/**
	 * Avanca para a proxima rodada
	 */
	public void advanceColor() {
		metricsCollection.clean();
		++color;
		interval = tempo - stop;
		stop = tempo;
	}
	
	public MetricsCollection getMetricsCollection() {
		return metricsCollection;
	}
	
	public double getTimeInterval() {
		return interval;
	}
}
