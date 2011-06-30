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
	
	/**
	 * Coleta os dados de um EventClassA, considerando ate o momento um intervalo de tempo total timeInterval
	 * @param event
	 * @param timeInterval
	 */
	public void collect(EventClassA event, double timeInterval) {
		total1.insertValue(event.getTempoAtraso() + event.getTempoServico(), timeInterval);
		atraso1.insertValue(event.getTempoAtraso(), timeInterval);
	}
	
	/**
	 * Coleta os dados de um EventClassB, considerando ate o momento um intervalo de tempo total timeInterval
	 * @param event
	 * @param timeInterval
	 */
	public void collect(EventClassB event, double timeInterval) {
		total2.insertValue(event.getTempoAtraso() + event.getTempoServico(), timeInterval);
		atraso2.insertValue(event.getTempoAtraso(), timeInterval);
	}
	
	/**
	 * Prepara para uma nova rodada de coleta de dados
	 */
	public void clean() {
		total1.clean();
		atraso1.clean();
		total2.clean();
		atraso2.clean();
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
		return total1.getMeanN();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Media da quantidade em espera na fila 1
	 */
	public double getMeanNAtraso1() {
		return atraso1.getMeanN();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Media da quantidade total na fila 2
	 */
	public double getMeanNFila2() {
		return total2.getMeanN();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Media da quantidade em espera na fila 2
	 */
	public double getMeanNAtraso2() {
		return atraso2.getMeanN();
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
		return total1.getSuperiorLimitN();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Limite inferior do intervalo de confianca da media da quantidade total da fila 1
	 */
	public double getInferiorLimitNFila1() {
		return total1.getInferiorLimitN();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Limite superior do intervalo de confianca da media da quantidade total da fila 2
	 */
	public double getSuperiorLimitNFila2() {
		return total2.getSuperiorLimitN();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Limite inferior do intervalo de confianca da media da quantidade total da fila 2
	 */
	public double getInferiorLimitNFila2() {
		return total2.getInferiorLimitN();
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
		return atraso1.getInferiorLimitN();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Limite superior do intervalo de confianca da media da quantidade em espera da fila 2
	 */
	public double getSuperiorLimitNAtraso2() {
		return atraso2.getSuperiorLimitN();
	}
	
	/**
	 * Retorno de dado coleta
	 * @return Limite inferior do intervalo de confianca da media da quantidade em espera da fila 2
	 */
	public double getInferiorLimitNAtraso2() {
		return atraso2.getInferiorLimitN();
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
		return total1.getDeviationN();
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
		return total2.getDeviationN();
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
		return atraso1.getDeviationN();
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
		return atraso2.getDeviationN();
	}
}
