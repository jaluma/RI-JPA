package uo.ri.business.impl;

public interface ComandExecutorFactory {

	/**
	 * Metodo que permite tener instanciar un ejecutor de los comandos
	 * @return un ejecutor de los comandos
	 */
	CommandExecutor forExecutor();

}
