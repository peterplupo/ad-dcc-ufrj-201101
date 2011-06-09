package simulator;

/**
 * Classe para fazer as medidas das estatisticas
 * @author Mariam
 *
 */
public class Metrics {
	private double sum;
	private double sumOfSquares;
	private int count;
	
	/** 
	 * Construtor padrao
	 */
	public Metrics() {
		sum = sumOfSquares = count = 0;
	}
	
	/**
	 * Retorna a media dos valores acumulados 
	 * @return a media
	 */
	public double getMean() {
		return sum / count;
	}
	
	/**
	 * Retorna a variancia dos valores acumulados (estimador da variancia da amostra)
	 * @return a variancia
	 */
	public double getVariance() {
		double nMenosUm = count - 1;
		return sumOfSquares / nMenosUm - sum*sum/(count*nMenosUm);
	}
	
	/**
	 * Acumula mais um valor a cada medida para os calculos
	 * @param value
	 */
	public void insertValue(double value) {
		sum += value;
		sumOfSquares += value*value;
		count++;
	}
}
