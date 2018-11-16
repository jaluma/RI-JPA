package uo.ri.business.repository;

public interface RepositoryFactory {

	/**
	 * Devuelve una instancia del repositorio de mecanico
	 * @return una instancia del repositorio de mecanico
	 */
	MecanicoRepository forMechanic();

	/**
	 * Devuelve una instancia del repositorio de averia
	 * @return una instancia del repositorio de averia
	 */
	AveriaRepository forAveria();

	/**
	 * Devuelve una instancia del repositorio de medio de pago
	 * @return una instancia del repositorio de medio de pago
	 */
	MedioPagoRepository forMedioPago();

	/**
	 * Devuelve una instancia del repositorio de factura
	 * @return una instancia del repositorio de factura
	 */
	FacturaRepository forFactura();

	/**
	 * Devuelve una instancia del repositorio de cliente
	 * @return una instancia del repositorio de cliente
	 */
	ClienteRepository forCliente();

	/**
	 * Devuelve una instancia del repositorio de repuesto
	 * @return una instancia del repositorio de repuesto
	 */
	RepuestoRepository forRepuesto();

	/**
	 * Devuelve una instancia del repositorio de intervencion
	 * @return una instancia del repositorio de intervencion
	 */
	IntervencionRepository forIntervencion();

	/**
	 * Devuelve una instancia del repositorio de contrato
	 * @return una instancia del repositorio de contrato
	 */
	ContratoRepository forContrato();

	/**
	 * Devuelve una instancia del repositorio de categoria de contrato
	 * @return una instancia del repositorio de categoria de contrato
	 */
	CategoriaContratoRepository forCategoriaContrato();

	/**
	 * Devuelve una instancia del repositorio de tipo de contrato
	 * @return una instancia del repositorio de tipo de contrato
	 */
	TipoContratoRepository forTipoContrato();

	/**
	 * Devuelve una instancia del repositorio de cargo
	 * @return una instancia del repositorio de cargo
	 */
	CargoRepository forCargo();

	/**
	 * Devuelve una instancia del repositorio de nomina
	 * @return una instancia del repositorio de nomina
	 */
	NominaRepository forNomina();

}
