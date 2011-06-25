package simulator;

/**
 * Classe que representa evento de chegada na fila 2
 * @author Mariam
 *
 */
//deve possuir indicadores para mostrar se o servico ja foi iniciado e, em caso positivo, quanto servico ainda resta
public class EventClassB extends Event {
	private boolean servico;
	private double tempoServico;
	private double tempoRestante;
	private double tempoAtraso;
	private double parada;
	
	public EventClassB(double time, int color) {
		// TODO Auto-generated constructor stub
		super(time, color);
		servico = false;
		tempoAtraso = 0;
	}

	public void iniciarServico(double tempo, double tempoServico, double tempoDisponivel) {
		this.tempoServico = tempoServico;
		tempoAtraso = tempo - getTime();
		if (tempoDisponivel >= tempoServico) {
			servico = false;
			tempoRestante = 0;
		} else {
			servico = true;
			tempoRestante = this.tempoServico - tempoDisponivel;
			parada = tempo + tempoDisponivel;
		}
	}
	
	public void continuarServico(double tempo, double tempoDisponivel) {
		tempoAtraso += tempo - parada;
		//System.out.println("Resta: " + tempoRestante + "; temos: " + tempoDisponivel);
		if (tempoDisponivel >= tempoRestante) {
			servico = false;
			tempoRestante = 0;
		} else {
			servico = true;
			tempoRestante = this.tempoRestante - tempoDisponivel;
			parada = tempo + tempoDisponivel;
		}
	}
	
	public double getTempoRestante() {
		return tempoRestante;
	}
	
	public double getTempoServico() {
		return tempoServico;
	}

	public boolean hasServico() {
		return servico;
	}

	public double getTempoAtraso() {
		return tempoAtraso;
	}
	
	
}
