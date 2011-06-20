package simulator;

/**
 * Classe para representar a ocorrencia de um evento generico
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
	
	public void setTime(double time) {
		this.time = time;
	}
	
	/**
	 * Tempo de ocorrencia do evento, por exemplo, quando ocorre uma chegada
	 * @return instante de tempo em que o evento ocorre
	 */
	public double getTime() {
		return time;
	}
	
	//acho que so numero fica um pouco indefinido demais
	/**
	 * Retorna a 'cor' da fase do evento
	 * @return 'cor' da fase
	 */
	public int getColor() {
		return color;
	}
}
