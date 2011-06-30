package simulator;

/**
 * Usado para agregar os resultados obtidos por MetricsCollection, isto e, os resultados de uma rodada
 * @author daniel
 *
 */
public class MetricsAgregator {
	Metrics total1, total2, atraso1, atraso2;
	Metrics totalN1, totalN2, atrasoN1, atrasoN2;
	
	public MetricsAgregator() {
		total1 = new Metrics();
		total2 = new Metrics();
		atraso1 = new Metrics();
		atraso2 = new Metrics();
		
		totalN1 = new Metrics();
		totalN2 = new Metrics();
		atrasoN1 = new Metrics();
		atrasoN2 = new Metrics();
	}
	
	/**
	 * Coleta os resultados obtidos por uma rodada
	 * @param metricsCollection
	 */
	public void collect(MetricsCollection metricsCollection) {
		total1.insertValue(metricsCollection.getMeanTotal1(), 0);
		total2.insertValue(metricsCollection.getMeanTotal2(), 0);
		atraso1.insertValue(metricsCollection.getMeanAtraso1(), 0);
		atraso2.insertValue(metricsCollection.getMeanAtraso2(), 0);
		
		totalN1.insertValue(metricsCollection.getMeanNFila1(), 0);
		totalN2.insertValue(metricsCollection.getMeanNFila2(), 0);
		atrasoN1.insertValue(metricsCollection.getMeanNAtraso1(), 0);
		atrasoN2.insertValue(metricsCollection.getMeanNAtraso2(), 0);
	}
	
	public void clean() {
		total1.clean();
		total2.clean();
		atraso1.clean();
		atraso2.clean();
		totalN1.clean();
		totalN2.clean();
		atrasoN1.clean();
		atrasoN2.clean();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Media de tempo total na fila 1
	 */
	public double getMeanTotal1() {
		return total1.getMean();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Media de tempo de espera na fila 1
	 */
	public double getMeanAtraso1() {
		return atraso1.getMean();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Variancia de tempo de espera na fila 1
	 */
	public double getVarianceAtraso1() {
		return atraso1.getVariance();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Media de tempo total na fila 2
	 */
	public double getMeanTotal2() {
		return total2.getMean();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Media de tempo de espera na fila 2
	 */
	public double getMeanAtraso2() {
		return atraso2.getMean();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Variancia de tempo de espera na fila 2
	 */
	public double getVarianceAtraso2() {
		return atraso2.getVariance();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Media da quantidade total na fila 1
	 */
	public double getMeanNFila1() {
		return totalN1.getMean();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Media da quantidade em espera na fila 1
	 */
	public double getMeanNAtraso1() {
		return atrasoN1.getMean();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Media da quantidade total na fila 2
	 */
	public double getMeanNFila2() {
		return totalN2.getMean();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Media da quantidade em espera na fila 2
	 */
	public double getMeanNAtraso2() {
		return atrasoN2.getMean();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Limite superior do intervalo de confianca da media do tempo total da fila 1
	 */
	public double getSuperiorLimitFila1() {
		return total1.getSuperiorLimit();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Limite inferior do intervalo de confianca da media do tempo total da fila 1
	 */
	public double getInferiorLimitFila1() {
		return total1.getInferiorLimit();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Limite superior do intervalo de confianca da media do tempo total da fila 2
	 */
	public double getSuperiorLimitFila2() {
		return total2.getSuperiorLimit();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Limite inferior do intervalo de confianca da media do tempo total da fila 2
	 */
	public double getInferiorLimitFila2() {
		return total2.getInferiorLimit();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Limite superior do intervalo de confianca da media do tempo em espera da fila 1
	 */
	public double getSuperiorLimitAtraso1() {
		return atraso1.getSuperiorLimit();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Limite inferior do intervalo de confianca da media do tempo em espera da fila 1
	 */
	public double getInferiorLimitAtraso1() {
		return atraso1.getInferiorLimit();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Limite superior do intervalo de confianca da media do tempo em espera da fila 2
	 */
	public double getSuperiorLimitAtraso2() {
		return atraso2.getSuperiorLimit();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Limite inferior do intervalo de confianca da media do tempo em espera da fila 2
	 */
	public double getInferiorLimitAtraso2() {
		return atraso2.getInferiorLimit();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Limite superior do intervalo de confianca da media da quantidade total da fila 1
	 */
	public double getSuperiorLimitNFila1() {
		return totalN1.getSuperiorLimit();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Limite inferior do intervalo de confianca da media da quantidade total da fila 1
	 */
	public double getInferiorLimitNFila1() {
		return totalN1.getInferiorLimit();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Limite superior do intervalo de confianca da media da quantidade total da fila 2
	 */
	public double getSuperiorLimitNFila2() {
		return totalN2.getSuperiorLimit();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Limite inferior do intervalo de confianca da media da quantidade total da fila 2
	 */
	public double getInferiorLimitNFila2() {
		return totalN2.getInferiorLimit();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Limite superior do intervalo de confianca da media da quantidade em espera da fila 1
	 */
	public double getSuperiorLimitNAtraso1() {
		return atraso1.getSuperiorLimitN();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Limite inferior do intervalo de confianca da media da quantidade em espera da fila 1
	 */
	public double getInferiorLimitNAtraso1() {
		return atrasoN1.getInferiorLimit();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Limite superior do intervalo de confianca da media da quantidade em espera da fila 2
	 */
	public double getSuperiorLimitNAtraso2() {
		return atrasoN2.getSuperiorLimit();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Limite inferior do intervalo de confianca da media da quantidade em espera da fila 2
	 */
	public double getInferiorLimitNAtraso2() {
		return atrasoN2.getInferiorLimit();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Desvio do intervalo de confianca do tempo total na fila 1
	 */
	public double getDeviationTotal1() {
		return total1.getDeviation();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Desvio do intervalo de confianca da quantidade total na fila 1
	 */
	public double getDeviationNTotal1() {
		return totalN1.getDeviation();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Desvio do intervalo de confianca do tempo total na fila 2
	 */
	public double getDeviationTotal2() {
		return total2.getDeviation();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Desvio do intervalo de confianca da quantidade total na fila 2
	 */
	public double getDeviationNTotal2() {
		return totalN2.getDeviation();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Desvio do intervalo de confianca do tempo em espera na fila 1
	 */
	public double getDeviationAtraso1() {
		return atraso1.getDeviation();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Desvio do intervalo de confianca da quantidade em espera na fila 1
	 */
	public double getDeviationNAtraso1() {
		return atrasoN1.getDeviation();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Desvio do intervalo de confianca do tempo em espera na fila 2
	 */
	public double getDeviationAtraso2() {
		return atraso2.getDeviation();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Desvio do intervalo de confianca da quantidade em espera na fila 2
	 */
	public double getDeviationNAtraso2() {
		return atrasoN2.getDeviation();
	}
}
