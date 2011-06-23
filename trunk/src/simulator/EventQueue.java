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
		/*
		 * logica a ser implementada:
		 * verificar quando ocorre a proxima chegada1
		 * verificar quando ocorre a proxima chegada2
		 * Se a chegada1 for primeiro (ou não há chegada2 na fila), trata-la e avançar o relogio
		 * senão, verifica quanto tempo ha disponivel ate a proxima chegada1 e trata o quanto puder a 2
		 */
		EventClassB chegada2 = queue.peekFirst();
		
		if (queue.isEmpty() || chegada1.getTime() <= chegada2.getTime()) {
			//tratar chegada1
			processEventClassA();
		} else {
			//tratar chegada2
			
		}
	}
	
	private void processEventClassA() {
		
	}

	private void processEventClassB(double tempoDisponivel) {
		
	}
}
