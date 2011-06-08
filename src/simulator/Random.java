package simulator;

//acho que talvez seja bom mudar o nome para descrever melhor. Random o quê?
/**
 * Classe para gerar valores aleatórios
 * @author dalves
 *
 */
public class Random {
	
	/**
	 * Construtor da classe - implementacao singleton
	 * @param rate
	 * Taxa da variável aleatoria exponencial.
	 */
	public Random(double rate) {
		
	}
	
	//possivelmente ficara depreciada, e a classe modificada para ser só uma exponencial
	/**
	 * Metodo para retornar um valor aleatorio de 0 a 1
	 * @return valor aleatório inteiro
	 */
	public double getRandomValue() {
		return 4; //definido aleatoriamente ;)
	}
}
