package simulator;

/**
 * Classe para agregar os resultados de cada rodada.
 * @author daniel
 *
 */
public class MetricsCollection {
	private Metrics total1, atraso1, total2, atraso2;
	
	public MetricsCollection() {
		total1 = new Metrics();
		atraso1 = new Metrics();
		total2 = new Metrics();
		atraso2 = new Metrics();
	}
	
	public void collect(EventClassA event) {
		total1.insertValue(event.getTempoAtraso() + event.getTempoServico());
		atraso1.insertValue(event.getTempoAtraso());
	}
	
	public void collect(EventClassB event) {
		total2.insertValue(event.getTempoAtraso() + event.getTempoServico());
		atraso2.insertValue(event.getTempoAtraso());
	}
	
	public double getMeanTotal1() {
		return total1.getMean();
	}
	
	public double getMeanAtraso1() {
		return atraso1.getMean();
	}
	
	public double getVarianceAtraso1() {
		return atraso1.getVariance();
	}
	
	public double getMeanTotal2() {
		return total2.getMean();
	}
	
	public double getMeanAtraso2() {
		return atraso2.getMean();
	}
	
	public double getVarianceAtraso2() {
		return atraso2.getVariance();
	}
	
	public double getMeanTotalFila1(double total) {
		return total1.getDensity(total);
	}
	
	public double getMeanEspera1(double total) {
		return atraso1.getDensity(total);
	}
	
	public double getMeanTotalFila2(double total) {
		return total2.getDensity(total);
	}
	
	public double getMeanEspera2(double total) {
		return atraso2.getDensity(total);
	}
}
