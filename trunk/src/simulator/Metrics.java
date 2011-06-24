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
	private double t = 1.96; //t-student para acerto de 95%
	private double deviation, deviationN; //desvio do tempo e do nº de pessoas na fila
	private double timeInterval;
	
	/** 
	 * Construtor padrao
	 */
	public Metrics() {
		sum = sumOfSquares = count = 0;
	}
	
	public void clean() {
		timeInterval = sum = sumOfSquares = count = 0;
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
	public void insertValue(double value, double timeInterval) {
		sum += value;
		sumOfSquares += value*value;
		count++;
		calculateDeviation();
		setTimeInterval(timeInterval);
		calculateDeviationN();
	}
	
	/**
	 * Calcula o módulo do desvio da amostra
	 */
	private void calculateDeviation(){
		deviation = Math.sqrt(getVariance()/count) * t;
	}
	
	/**
	 * Retorna o limite superior do desvio da amostra
	 * Requer que deviation tenha sido calculado
	 * @return a cota superior
	 */
	public double getSuperiorLimit(){
		return getMean() + deviation;
	}
	
	/**
	 * Retorna o limite inferior do desvio da amostra
	 * Requer que deviation tenha sido calculado
	 * @return a cota inferior
	 */
	public double getInferiorLimit(){
		return getMean() - deviation;
	}
	
	/**
	 * Retorna a media da fila
	 * Requer que o intervalo total de tempo tenha sido definido
	 * @return
	 */
	public double getMeanN() {
		return sum / timeInterval;
	}
	
	/**
	 * Retorna a variancia dos valores acumulados (estimador da variancia da amostra)
	 * Requer que o intervalo total de tempo tenha sido definido
	 * @return a variancia da fila
	 */
	public double getVarianceN() {
		double nMenosUm = timeInterval - 1;
		return sumOfSquares / nMenosUm - sum*sum/(timeInterval*nMenosUm);
	}
	
	/**
	 * Calcula o módulo do desvio da amostra na fila
	 * Requer que o intervalo total de tempo tenha sido definido
	 */
	public void calculateDeviationN(){
		deviationN = Math.sqrt(getVarianceN()/timeInterval) * t;
	}
	
	/**
	 * Retorna o limite superior do desvio da amostrara
	 * Requer que a deviationN tenha sido calculada
	 * @return a cota superior da fila
	 */
	public double getSuperiorLimitN(){
		return getMean() + deviationN;
	}
	
	/**
	 * Retorna o limite inferior do desvio da amostra
	 * Requer que a deviationN tenha sido calculada
	 * @return a cota inferior da fila
	 */
	public double getInferiorLimitN(){
		return getMean() - deviationN;
	}

	/**
	 * Define o intervalo de tempo total para estudo da densidade da fila
	 * @param timeInterval
	 */
	private void setTimeInterval(double timeInterval) {
		this.timeInterval = timeInterval;
		calculateDeviationN();
	}
	
	public double getDeviation() {
		return deviation;
	}
	
	public double getDeviationN() {
		return deviationN;
	}
}
