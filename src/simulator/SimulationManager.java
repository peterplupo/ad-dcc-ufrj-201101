package simulator;

/**
 * Classe para controle geral da simulação
 * @author dalves
 *
 */
public class SimulationManager {
	private int fases;
	private static long seed;
	/**
	 * Fornece a semente da simulacao
	 * @return
	 */
	public static long getSeed() {
		return seed;
	}
	
	public SimulationManager(int seed) {
		// TODO definir um total aceitável
		fases = 20;
		this.seed = seed;
	}
	
	public void runSimulation(double useRate) {
		EventQueue eventQueue = new EventQueue(useRate);
		MetricsCollection metricsCollection = eventQueue.getMetricsCollection();
		
		// TODO aqui devemos verificar se ainda está na fase transiente
		while (metricsCollection.getMeanTotalFila1(eventQueue.getTimeInterval()) != 0) {
			eventQueue.processNextEvent();
		}
		
		// TODO aqui verificamos se devemos trocar de fase
		for (int i = 0; i < fases; i++) {
			// TODO aqui verificamos se deve avançar a fase
			while (metricsCollection.getMeanTotalFila1(eventQueue.getTimeInterval()) != 0) {
				eventQueue.processNextEvent();
			}
			// TODO aqui devemos acumular os resultados para composição
		}
	}
}
