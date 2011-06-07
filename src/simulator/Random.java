package simulator;

//acho que talvez seja bom mudar o nome para descrever melhor. Random o quê?
/**
 * Classe para gerar valores aleatórios
 * @author dalves
 *
 */
public class Random {
	
	/**
	 * Construtor da classe
	 * @param rate
	 * Taxa da variável aleatória exponencial.
	 */
	public Random(double rate) {
		
	}
	
	//possivelmente ficara depreciada, e a classe modificada para ser só uma exponencial
	/**
	 * Metodo para retornar um valor inteiro aleatório
	 * @return valor aleatório inteiro
	 */
	public int getRandomValue() {
		return 4; //definido aleatoriamente ;)
	}
	
	//depois de implementar, gerar vários valores e ver se comporta-se como uma exponencial
	//medir média e variância
	/**
	 * Retorna um valor aleatório de acordo com a distribuição aleatória da exponencial
	 * @return valor aleatório retornado
	 */
	public double getExponentialRandomValue() {
		return 4;
	}
}
