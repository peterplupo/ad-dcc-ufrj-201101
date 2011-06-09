package simulator;

/**
 * Classe para representar a ocorrência de um evento genérico
 * @author dalves
 *
 */
public abstract class Event {
	private double time;
	private int color;
	
	/**
	 * Construtor padrao 
	 * @param time
	 * @param color
	 */
	public Event(double time, int color) {
		this.time = time;
		this.color = color;
	}
	
	/**
	 * Tempo de ocorrência do evento, por exemplo, quando ocorre uma chegada
	 * @return
	 */
	public double getTime() {
		return time;
	}
	
	//acho que so numero fica um pouco indefinido demais
	/**
	 * Retorna a 'cor' da fase do evento
	 * @return
	 */
	public int getColor() {
		return color;
	}
}
