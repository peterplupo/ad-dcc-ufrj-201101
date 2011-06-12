package simulator;

import java.util.Random;

/**
 * Classe que representa uma variavel aleatoria exponencial
 * @author Mariam
 *
 */
public class RandomExponentialVariable {
	private double rate;
	private static Random generator;
	
	/**
	 * Construtor padrao 
	 * @param rate
	 */
	public RandomExponentialVariable(double rate) {
		// TODO Auto-generated constructor stub
		this.rate = rate;
		if (generator == null) {
			generator = new Random(SimulationManager.getSeed());
		}
	}
	
	/**
	 * Retorna um valor aleatorio de acordo com a distribuicao aleatoria da exponencial
	 * @return valor aleatorio retornado
	 */
	public double getValue() {
		return -Math.log(1 - generator.nextDouble()) / rate;
	}

	/**
	 * Metodo para media
	 * @return media da exponencial
	 */
	public double getExpected() {
		return 1 / rate;
	}
	
	/**
	 * Metodo para variancia
	 * @return variancia da exponencial
	 */
	public double getVariance() {
		return 1 / (rate*rate);
	}
}
