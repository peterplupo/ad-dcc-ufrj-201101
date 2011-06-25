package simulator;

/**
 * Classe para controle geral da simulação
 * @author dalves
 *
 */
public class SimulationManager {
	private int minFases;
	private static long seed;
	private int minEvents;
	private int eventsTransient;
	private double tolerance;
	private MetricsAgregator metricsAgregator;
	private MetricsCollection metricsCollection;
	/**
	 * Fornece a semente da simulacao
	 * @return
	 */
	public static long getSeed() {
		return seed;
	}
	
	public SimulationManager(int seed) {
		// TODO definir um total aceitável
		minFases = 20;
		minEvents = 100;
		eventsTransient = 10000000;
		tolerance = 0.1;
		this.seed = seed;
		metricsAgregator = new MetricsAgregator();
	}
	
	public void runSimulation(double useRate) {
		EventQueue eventQueue = new EventQueue(useRate);
		metricsCollection = eventQueue.getMetricsCollection();
		
		System.out.println("Iniciando fase transiente.");
		// TODO aqui devemos verificar se ainda está na fase transiente
		for (int i = 0; i < eventsTransient; ++i) {
			eventQueue.processNextEvent();
		}
		metricsAgregator.clean();
		System.out.println("Fim da fase transiente.");

		System.out.println("Iniciando rodadas coloridas");
		int i;
		for (i = 0; i < minFases; i++) {
			System.out.println("Rodada " + i);
			runOne(eventQueue);
			// TODO aqui devemos acumular os resultados para composição
			metricsAgregator.collect(metricsCollection);
		}
		while (metricsAgregator.getDeviationAtraso1() > tolerance
				|| metricsAgregator.getDeviationAtraso2() > tolerance
				|| metricsAgregator.getDeviationTotal1() > tolerance
				|| metricsAgregator.getDeviationTotal2() > tolerance
				|| metricsAgregator.getDeviationNTotal1() > tolerance
				|| metricsAgregator.getDeviationNTotal2() > tolerance
				|| metricsAgregator.getDeviationNAtraso1() > tolerance
				|| metricsAgregator.getDeviationNAtraso2() > tolerance) {
			System.out.println("Rodada " + i);
			runOne(eventQueue);
			// TODO aqui devemos acumular os resultados para composição
			metricsAgregator.collect(metricsCollection);
			++i;
		}
	}
	
	private void runOne(EventQueue eventQueue) {
		
		// TODO aqui verificamos se devemos trocar de fase
		int i;
		for (i = 0; i < minEvents; ++i) {
			eventQueue.processNextEvent();
		}
		// TODO aqui verificamos se deve avançar a fase
		while (metricsCollection.getDeviationAtraso1() > tolerance
				|| metricsCollection.getDeviationAtraso2() > tolerance
				|| metricsCollection.getDeviationTotal1() > tolerance
				|| metricsCollection.getDeviationTotal2() > tolerance
				|| metricsCollection.getDeviationNTotal1() > tolerance
				|| metricsCollection.getDeviationNTotal2() > tolerance
				|| metricsCollection.getDeviationNAtraso1() > tolerance
				|| metricsCollection.getDeviationNAtraso2() > tolerance) {
			System.out.println(metricsCollection.getDeviationTotal1());
			System.out.println(metricsCollection.getDeviationTotal2());
			System.out.println(metricsCollection.getDeviationNTotal1());
			System.out.println(metricsCollection.getDeviationNTotal2());
			System.out.println(metricsCollection.getDeviationAtraso1());
			System.out.println(metricsCollection.getDeviationAtraso2());
			System.out.println(metricsCollection.getDeviationNAtraso1());
			System.out.println(metricsCollection.getDeviationNAtraso2());
			eventQueue.processNextEvent();
			++i;
		}
	}
	
	public MetricsAgregator getMetricsAgregator() {
		return metricsAgregator;
	}
}
