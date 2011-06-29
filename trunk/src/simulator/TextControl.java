package simulator;

import java.util.Random;

/**
 * Classe para testar em console o funcionamento do Simulador
 * @author daniel
 *
 */
public class TextControl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testRun(10000, 100, 50, 0.2);
		testRun(10000, 100, 100, 0.4);
		testRun(15000, 500, 100, 0.6);
		testRun(40000, 500, 100, 0.8);
		testRun(200000, 1000, 100, 0.9);
	}
	
	private static void testRun(int eventsTransiente, int minEvents, int minFases, double ro) {
		Random seed = new Random();
		SimulationManager simulationManager = new SimulationManager(seed.nextInt());
		MetricsAgregator metricsAgregator;
		
		simulationManager.setEventsTransient(eventsTransiente);
		simulationManager.setMinEvents(minEvents);
		simulationManager.setMinFases(minFases);
		
		System.out.println("Iniciando teste com ro = " + ro + ".");
		System.out.println("Numero de fregueses na fase transiente: " + eventsTransiente);
		System.out.println("Numero de fregueses por rodada: " + minEvents);
		System.out.println("Numero de rodadas: " +  minFases);
		simulationManager.runSimulation(ro);
		metricsAgregator = simulationManager.getMetricsAgregator();
		
		System.out.println("Total de fregueses processados: " + simulationManager.getTotalRodadas());
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
