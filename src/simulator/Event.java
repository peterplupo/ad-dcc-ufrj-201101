package simulator;

/**
 * Classe para representar a ocorrência de um evento genérico
 * @author dalves
 *
 */
public abstract class Event {
	//possivelmente nao precisaremos do type para o event
	
	/**
	 * Tempo de ocorrência do evento, por exemplo, quando ocorre uma chegada
	 * @return
	 */
	public double time() {
		return 0;
	}
	
	//acho que so numero fica um pouco indefinido demais
	/**
	 * Retorna a 'cor' da fase do evento
	 * @return
	 */
	public double color() {
		return 0;
	}
}
