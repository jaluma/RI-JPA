package uo.ri.business.exception;

public class BusinessCheck {

	/**
	 * Comprueba que el objeto pasado por parametro sea null
	 * @param o objeto a comprobar
	 * @param errorMsg mensaje a mostrar si es null
	 * @throws BusinessException en caso de no cumplirse
	 */
	public static void isNull(Object o, String errorMsg) throws BusinessException {
		isTrue(o == null, errorMsg);
	}

	/**
	 * Comprueba que el objeto pasado por parametro sea null
	 * @param o objeto a comprobar
	 * @throws BusinessException en caso de no cumplirse
	 */
	public static void isNull(Object o) throws BusinessException {
		isTrue(o == null, o.getClass().getName() + " cannot be null here");
	}

	/**
	 * Comprueba que el objeto pasado por parametro no sea null
	 * @param o objeto a comprobar
	 * @param errorMsg mensaje a mostrar si es no null
	 * @throws BusinessException en caso de no cumplirse
	 */
	public static void isNotNull(Object o, String errorMsg) throws BusinessException {
		isTrue(o != null, errorMsg);
	}

	/**
	 * Comprueba que el objeto pasado por parametro no sea null
	 * @param o objeto a comprobar
	 * @throws BusinessException en caso de no cumplirse
	 */
	public static void isNotNull(Object o) throws BusinessException {
		isTrue(o != null, o.getClass().getName() + " cannot be null here");
	}

	/**
	 * Comprueba que la condicion pasado por parametro sea falsa
	 * @param condition a comprobar
	 * @throws BusinessException en caso de no cumplirse
	 */
	public static void isFalse(boolean condition) throws BusinessException {
		isTrue(!condition, "Invalid assertion");
	}

	/**
	 * Comprueba que la condicion pasado por parametro sea falsa
	 * @param condition a comprobar
	 * @param errorMsg mensaje a mostrar si la condicion no se cumple
	 * @throws BusinessException en caso de no cumplirse
	 */
	public static void isFalse(boolean condition, String errorMsg) throws BusinessException {
		isTrue(!condition, errorMsg);
	}

	/**
	 * Comprueba que la condicion pasado por parametro sea verdadera
	 * @param condition a comprobar
	 * @throws BusinessException en caso de no cumplirse
	 */
	public static void isTrue(boolean condition) throws BusinessException {
		isTrue(condition, "Invalid assertion");
	}

	/**
	 * Comprueba que la condicion pasado por parametro sea verdadera
	 * @param condition a comprobar
	 * @param errorMsg mensaje a mostrar si es verdadera
	 * @throws BusinessException en caso de no cumplirse
	 */
	public static void isTrue(boolean condition, String errorMsg) throws BusinessException {
		if (condition == true)
			return;
		throw new BusinessException(errorMsg);
	}

}
