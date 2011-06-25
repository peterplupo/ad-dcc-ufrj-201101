package simulator;

public class TextControl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testRun(0.2);
		testRun(0.4);
		testRun(0.6);
		testRun(0.8);
	}
	
	private static void testRun(double ro) {
		SimulationManager simulationManager = new SimulationManager(0);
		MetricsAgregator metricsAgregator;
		
		System.out.println("Iniciando teste com ro = 0.2.");
		simulationManager.runSimulation(ro);
		metricsAgregator = simulationManager.getMetricsAgregator();
		
		System.out.println("Resultados:");
		System.out.println("E[T1] = " + metricsAgregator.getMeanTotal1() + " +- " + metricsAgregator.getDeviationTotal1());
		System.out.println("E[W1] = " + metricsAgregator.getMeanAtraso1() + " +- " + metricsAgregator.getDeviationAtraso1());
		System.out.println("E[N1] = " + metricsAgregator.getMeanNFila1() + " +- " + metricsAgregator.getDeviationNTotal1());
		System.out.println("E[Nq1] = " + metricsAgregator.getMeanNAtraso1() + " +- " + metricsAgregator.getDeviationNAtraso1());
		System.out.println("E[T2] = " + metricsAgregator.getMeanTotal2() + " +- " + metricsAgregator.getDeviationTotal2());
		System.out.println("E[W2] = " + metricsAgregator.getMeanAtraso2() + " +- " + metricsAgregator.getDeviationAtraso2());
		System.out.println("E[N2] = " + metricsAgregator.getMeanNFila2() + " +- " + metricsAgregator.getDeviationNTotal2());
		System.out.println("E[Nq2] = " + metricsAgregator.getMeanNAtraso2() + " +- " + metricsAgregator.getDeviationNAtraso2());
		System.out.println("V(W1) = " + metricsAgregator.getVarianceAtraso1());
		System.out.println("V(W2) = " + metricsAgregator.getVarianceAtraso2());
		
	}

}
