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
	
	public EventQueue() {
		color = 0;
		chegada1 = new EventClassA(0, color);
		queue = new LinkedList<EventClassB>();
	}
	
	/**
	 * Metodo para processar o proximo evento,
	 * realizando as operações necessárias na fila
	 * e capturando as métricas
	 */
	public void processNextEvent() {
		
	}
}
