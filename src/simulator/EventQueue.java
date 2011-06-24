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
		
		if (queue.isEmpty() || chegada1.getTime() <= chegada2.getTime()) {
			//trata chegada1
			processEventClassA();
		} else {
			//trata chegada2
			processEventClassB(chegada1.getTime() - tempo);
		}
	}
	
	private void processEventClassA() {
		double tempoServico = exponencialServico.getValue();
		
		tempo = chegada1.getTime();
		chegada1.servir(tempo, tempoServico);
		tempo += tempoServico;
		if (chegada1.getColor() == color) {
			metricsCollection.collect(chegada1, getTimeInterval());
		}
		chegada1 = new EventClassA(chegada1.getTime() + exponencialChegada.getValue(), color);
	}

	private void processEventClassB(double tempoDisponivel) {
		EventClassB event = queue.peekFirst();
		double tempoServico;
		if (event.hasServico()) {
			tempoServico = event.getTempoRestante();
			event.continuarServico(tempo, tempoDisponivel);
		} else {
			tempoServico = exponencialServico.getValue();
			event.iniciarServico(tempo, tempoServico, tempoDisponivel);
		}
		
		if (event.hasServico()) {
			tempo += tempoDisponivel;
		} else {
			tempo += tempoServico;
			if (event.getColor() == color) {
				metricsCollection.collect(event, getTimeInterval());
			}
		}
	}
	
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
