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
	private int totalRodadas;
	/**
	 * Fornece a semente da simulacao
	 * @return
	 */
	public static long getSeed() {
		return seed;
	}
	
	/**
	 * Possui o total de rodadas realizadas ate o momento atual
	 * @return
	 */
	public int getTotalRodadas() {
		return totalRodadas;
	}
	
	public SimulationManager(int seed) {
		// TODO definir um total aceitável
		minFases = 20;
		minEvents = 100;
		eventsTransient = 100000;
		totalRodadas = 0;
		tolerance = 0.05;
		SimulationManager.seed = seed;
		metricsAgregator = new MetricsAgregator();
	}
	
	/**
	 * Avalia se os valores coletados tem intervalos de confianca dentro da tolerancia
	 * @return
	 */
	private boolean outsideTolerance() {
		boolean w1 = metricsAgregator.getDeviationAtraso1() > tolerance * metricsAgregator.getMeanAtraso1();
		boolean w2 = metricsAgregator.getDeviationAtraso2() > tolerance * metricsAgregator.getMeanAtraso2();
		boolean t1 = metricsAgregator.getDeviationTotal1() > tolerance * metricsAgregator.getMeanTotal1();
		boolean t2 = metricsAgregator.getDeviationTotal2() > tolerance * metricsAgregator.getMeanTotal2();
		boolean n1 = metricsAgregator.getDeviationNTotal1() > tolerance * metricsAgregator.getMeanNFila1();
		boolean n2 = metricsAgregator.getDeviationNTotal2() > tolerance * metricsAgregator.getMeanNFila2();
		boolean nq1 = metricsAgregator.getDeviationNAtraso1() > tolerance * metricsAgregator.getMeanNAtraso1();
		boolean nq2 = metricsAgregator.getDeviationNAtraso2() > tolerance * metricsAgregator.getMeanNAtraso2();
		
		return w1 || w2 || t1 || t2 || n1 || n2 || nq1 || nq2;
	}
	
	/**
	 * Mínimo de rodadas da simulacao
	 * @param minFases
	 */
	public void setMinFases(int minFases) {
		this.minFases = minFases;
	}
	
	/**
	 * Define o minimo de eventos de uma rodada
	 * @param minEvents
	 */
	public void setMinEvents(int minEvents) {
		this.minEvents = minEvents;
	}
	
	/**
	 * Define o mínimo de eventos da fase transiente
	 * @param eventsTransient
	 */
	public void setEventsTransient(int eventsTransient) {
		this.eventsTransient = eventsTransient;
	}
	
	/**
	 * Roda varias rodadas da simulacao para poder obter os valores 
	 * @param useRate
	 */
	public void runSimulation(double useRate) {
		EventQueue eventQueue = new EventQueue(useRate);
		metricsCollection = eventQueue.getMetricsCollection();
		
		// aqui devemos verificar se ainda está na fase transiente
		for (int i = 0; i < eventsTransient; ++i) {
			eventQueue.processNextEvent();
			++totalRodadas;
		}
		metricsAgregator.clean();

		int i;
		for (i = 0; i < minFases; i++) {
			runOne(eventQueue);
			// aqui devemos acumular os resultados para composição
			metricsAgregator.collect(metricsCollection);
		}
		while (outsideTolerance()) {
			runOne(eventQueue);
			// aqui devemos acumular os resultados para composição
			metricsAgregator.collect(metricsCollection);
			++i;
		}
	}
	
	/**
	 * Uma rodada de simulacao
	 * @param eventQueue
	 */
	private void runOne(EventQueue eventQueue) {
		
		// aqui verificamos se devemos trocar de fase
		int i;
		for (i = 0; i < minEvents; ++i) {
			eventQueue.processNextEvent();
			++totalRodadas;
		}
		// aqui verificamos se deve avançar a fase
		while (outsideTolerance()) {
			eventQueue.processNextEvent();
			++i;
			++totalRodadas;
		}
	}
	
	public MetricsAgregator getMetricsAgregator() {
		return metricsAgregator;
	}
}
