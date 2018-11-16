package uo.ri.business.exception;

public class BusinessException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor por defecto de la excepcion BusinessException
	 */
	public BusinessException() {
	}

	/**
	 * Constructor que al que le llega un mensaje a imprimir de la excepcion
	 * BusinessException
	 * 
	 * @param message a mostrar
	 */
	public BusinessException(String message) {
		super(message);
	}

	/**
	 * Constructor al que llega otra excepcion y la transforam en BusinessException
	 * @param cause excepcion que quieres convertir
	 */
	public BusinessException(Throwable cause) {
		super(cause);
	}

	/**
	 *  Constructor que al que le llega un mensaje a imprimir de la excepcion y 
	 *  otra expcepcion
	 * @param message a imprimir
	 * @param cause excepcion que se quiere convertir
	 */
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

}
