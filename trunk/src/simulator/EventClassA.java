package simulator;

/**
 * Classe que representa evento de chegada na fila 1
 * @author Mariam
 *
 */
public class EventClassA extends Event {
	private double tempoServico;
	private double tempoAtraso;
	
	public EventClassA(double time, int color) {
		// TODO Auto-generated constructor stub
		super(time, color);
	}
	
	public void servir(double tempo, double tempoServico) {
		this.tempoServico = tempoServico;
		tempoAtraso = tempo - getTime();
	}
	
	public double getTempoAtraso() {
		return tempoAtraso;
	}
	
	public double getTempoServico() {
		return tempoServico;
	}
}
