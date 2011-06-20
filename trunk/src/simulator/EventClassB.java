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
	private double parada;
	
	public EventClassB(double time, int color) {
		// TODO Auto-generated constructor stub
		super(time, color);
		servico = false;
	}

	public double servir(double tempo) {
		return getTime();
	}
	
	public double getTempoServico() {
		return tempoServico;
	}
}
