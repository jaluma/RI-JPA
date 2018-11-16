package uo.ri.business.impl;

import uo.ri.business.exception.BusinessException;

public interface Command<T> {

	/**
	 * Metodo que ejecuta una acción tenerminada
	 * 
	 * @return el valor que se hay especificado en la genericidad de la clase
	 * @throws BusinessException
	 *             en caso de que haya algún tipo de error en la ejecución de
	 *             las instrucciones
	 */
	T execute() throws BusinessException;
}
