package uo.ri.business.impl;

import uo.ri.business.exception.BusinessException;

public interface CommandExecutor {

	/**
	 * Permite ejecutar un comando pasado por parametro
	 * 
	 * @param cmd
	 *            comando a ejecutar
	 * @return el tipo de datos que tenermine la genericidad de la clase
	 * @throws BusinessException
	 *             en caso de que falle el comando en algún caso
	 */
	<T> T execute(Command<T> cmd) throws BusinessException;

}