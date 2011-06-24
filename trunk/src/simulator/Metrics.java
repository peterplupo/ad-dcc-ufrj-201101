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
	private double total;
	
	/** 
	 * Construtor padrao
	 */
	public Metrics() {
		sum = sumOfSquares = count = 0;
	}
	
	public void clean() {
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
	
	/**
	 * Calcula o módulo do desvio da amostra
	 */
	public void calculateDeviation(){
		deviation = Math.sqrt(getVariance()/count) * t;
	}
	
	/**
	 * Retorna o limite superior do desvio da amostra
	 * @return a cota superior
	 */
	public double getSuperiorLimit(){
		return getMean() + deviation;
	}
	
	/**
	 * Retorna o limite inferior do desvio da amostra
	 * @return a cota inferior
	 */
	public double getInferiorLimit(){
		return getMean() - deviation;
	}
	
	/**
	 * Retorna a media da fila
	 * @param total
	 * @return
	 */
	public double getMeanN() {
		return sum / total;
	}
	
	/**
	 * Retorna a variancia dos valores acumulados (estimador da variancia da amostra)
	 * @return a variancia da fila
	 */
	public double getVarianceN() {
		double nMenosUm = total - 1;
		return sumOfSquares / nMenosUm - sum*sum/(total*nMenosUm);
	}
	
	/**
	 * Calcula o módulo do desvio da amostra na fila
	 */
	public void calculateDeviationN(){
		deviationN = Math.sqrt(getVariance()/total) * t;
	}
	
	/**
	 * Retorna o limite superior do desvio da amostra
	 * @return a cota superior da fila
	 */
	public double getSuperiorLimitN(){
		return getMean() + deviationN;
	}
	
	/**
	 * Retorna o limite inferior do desvio da amostra
	 * @return a cota inferior da fila
	 */
	public double getInferiorLimitN(){
		return getMean() - deviationN;
	}

	public void setTotal(double total) {
		this.total = total;
	}	
}
