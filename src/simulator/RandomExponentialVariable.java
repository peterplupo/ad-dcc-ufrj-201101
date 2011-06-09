package simulator;

import java.util.Random;

public class RandomExponentialVariable {
	private double rate;
	private static Random generator;
	
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
	public double getExponentialRandomValue() {
		return -Math.log(1 - generator.nextDouble()) / rate;
	}

	/**
	 * Metodo para media
	 * @return
	 */
	public double getExpected() {
		return 1 / rate;
	}
	
	/**
	 * Metodo para variancia
	 * @return
	 */
	public double getVariance() {
		return 1 / (rate*rate);
	}
}
