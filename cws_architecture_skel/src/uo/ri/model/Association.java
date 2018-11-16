package uo.ri.model;

public class Association {

	/**
	 * Clase que vincula un cliente con un vehiculo
	 * @author Javier Martinez
	 *
	 */
	public static class Poseer {

		/**
		 * Une un cliente con un vehiculo
		 * @param cliente a vincular
		 * @param vehiculo a vincular
		 */
		public static void link(Cliente cliente, Vehiculo vehiculo) {
			vehiculo._setCliente(cliente);
			cliente._getVehiculo().add(vehiculo);
		}

		/**
		 * Desvincula un cliente con un vehiculo
		 * @param cliente a desvincular
		 * @param vehiculo a desvincular
		 */
		public static void unlink(Cliente cliente, Vehiculo vehiculo) {
			cliente._getVehiculo().remove(vehiculo);
			vehiculo._setCliente(null);
		}
	}

	/**
	 * Clase que vincula un tipo de vehiculo con un vehiculo
	 * @author Javier Martinez
	 *
	 */
	public static class Clasificar {

		/**
		 * Vincula un tipo de vehiculo con un vehiculo
		 * @param tipoVehiculo a vincular
		 * @param vehiculo a vincular
		 */
		public static void link(TipoVehiculo tipoVehiculo, Vehiculo vehiculo) {
			vehiculo._setTipo(tipoVehiculo);
			tipoVehiculo._getVehiculo().add(vehiculo);

		}

		/**
		 * Vincula un tipo de vehiculo con un vehiculo
		 * @param tipoVehiculo a desvincular
		 * @param vehiculo a desvincular
		 */
		public static void unlink(TipoVehiculo tipoVehiculo, Vehiculo vehiculo) {
			tipoVehiculo._getVehiculo().remove(vehiculo);
			vehiculo._setTipo(null);
		}
	}

	/**
	 * Clase que vincula un medio de pago con un cliente
	 * @author Javier Martinez
	 *
	 */
	public static class Pagar {

		/**
		 * Vincula un medio de pago con un cliente
		 * @param medioPago a vincular
		 * @param cliente a vincular
		 */
		public static void link(MedioPago medioPago, Cliente cliente) {
			medioPago._setCliente(cliente);
			cliente._getMedioPago().add(medioPago);
		}

		/**
		 * Desvincular un cliente con un medio de pago
		 * @param medioPago a desvincular
		 * @param cliente a desvincular
		 */
		public static void unlink(Cliente cliente, MedioPago medioPago) {
			cliente._getMedioPago().remove(medioPago);
			medioPago._setCliente(null);
		}

	}

	/**
	 * Clase que vincula un cliente con un vehiculo
	 * @author Javier Martinez
	 *
	 */
	public static class Averiar {

		/**
		 * Vincula un vehiculo con una averia 
		 * @param vehiculo a vincular
		 * @param averia a vincular
		 */
		public static void link(Vehiculo vehiculo, Averia averia) {
			averia._setVehiculo(vehiculo);
			vehiculo._getAverias().add(averia);
		}

		/**
		 * Desvincula un vehiculo y una averia
		 * @param vehiculo a desvincular
		 * @param averia a desvincular
		 */
		public static void unlink(Vehiculo vehiculo, Averia averia) {
			vehiculo._getAverias().remove(averia);
			averia._setVehiculo(null);
		}
	}

	/**
	 * Clase que vincula una factura con una averia
	 * @author Javier Martinez
	 *
	 */
	public static class Facturar {
		/**
		 * Vincular una factura con una averia
		 * @param factura a vincular
		 * @param averia a vincular
		 */
		public static void link(Factura factura, Averia averia) {
			averia._setFactura(factura);
			factura._getAverias().add(averia);
		}

		/**
		 * Desvincula una factura de una averia
		 * @param factura a desvincular
		 * @param averia a desvincular
		 */
		public static void unlink(Factura factura, Averia averia) {
			factura._getAverias().remove(averia);
			averia._setFactura(null);
		}
	}

	/**
	 * Clase que vincula una factura con un medio de pago y un cargo
	 * @author Javier Martinez
	 *
	 */
	public static class Cargar {

		/**
		 * Vincula una factura, un medio de pago y un cargo
		 * @param factura a vincular
		 * @param medioPago a vincular
		 * @param cargo a vincular
		 */
		public static void link(Factura factura, MedioPago medioPago, Cargo cargo) {
			cargo._setMedioPago(medioPago);
			cargo._setFactura(factura);
			medioPago._getCargos().add(cargo);
			factura._getCargos().add(cargo);
		}

		/**
		 * Desvincula un cargo
		 * @param cargo a desvincular
		 */
		public static void unlink(Cargo cargo) {
			cargo.getFactura()._getCargos().remove(cargo);
			cargo.getMedioPago()._getCargos().remove(cargo);
			cargo._setMedioPago(null);
			cargo._setFactura(null);
		}
	}

	/**
	 * Clase que vincula una factura con un mecanico y una averia
	 * @author Javi Martinez
	 *
	 */
	public static class Asignar {

		/**
		 * Vincula un mecanico con una averia
		 * @param mecanico a vincular
		 * @param averia a vincular
		 */
		public static void link(Mecanico mecanico, Averia averia) {
			averia._setMecanico(mecanico);
			mecanico._getAsignadas().add(averia);
		}

		/**
		 * Desvincula un mecanico y una averia
		 * @param mecanico a desvincular
		 * @param averia a desvincular
		 */
		public static void unlink(Mecanico mecanico, Averia averia) {
			mecanico._getAsignadas().remove(averia);
			averia._setMecanico(null);
		}
	}

	/**
	 * Clase que vincula un mecanico, una averia y una intervencion
	 * @author Javier Martinez
	 *
	 */
	public static class Intervenir {
		/**
		 * Vincula un mecanico, una averia y una intervencion
		 * @param mecanico a vincular
		 * @param averia a vincular
		 * @param intervencion a vincular
		 */
		public static void link(Mecanico mecanico, Averia averia, Intervencion intervencion) {
			intervencion._setMecanico(mecanico);
			intervencion._setAveria(averia);
			mecanico._getIntervenciones().add(intervencion);
			averia._getIntervenciones().add(intervencion);
		}

		/**
		 * Desvincula una intervencion
		 * @param intervencion a desvincular
		 */
		public static void unlink(Intervencion intervencion) {
			intervencion.getMecanico()._getIntervenciones().remove(intervencion);
			intervencion.getAveria()._getIntervenciones().remove(intervencion);
			intervencion._setMecanico(null);
			intervencion._setAveria(null);
		}
	}

	/**
	 * Clase que vincula un intervencion, repuesto y sustitucion
	 * @author Javier Martinez
	 *
	 */
	public static class Sustituir {
		/**
		 * Vincula una intervencion, un repuesto y una sustitucion
		 * @param intervencion a vincular
		 * @param repuesto a vincular
		 * @param sustitucion a vincular
		 */
		public static void link(Intervencion intervencion, Repuesto repuesto, Sustitucion sustitucion) {
			sustitucion._setIntervencion(intervencion);
			sustitucion._setRepuesto(repuesto);
			intervencion._getSustituciones().add(sustitucion);
			repuesto._getSustituciones().add(sustitucion);
		}

		/**
		 * Desvincula una sustitucion
		 * @param sustitucion a desvincular
		 */
		public static void unlink(Sustitucion sustitucion) {
			sustitucion.getIntervencion()._getSustituciones().remove(sustitucion);
			sustitucion.getRepuesto()._getSustituciones().remove(sustitucion);
			sustitucion._setIntervencion(null);
			sustitucion._setRepuesto(null);
		}
	}

	/**
	 * Clase que vincula un contrato con una categoria de contrato
	 * @author Javier Martinez
	 *
	 */
	public static class Categorize {
		/**
		 * Vincula un contrato con una categoria de contratos
		 * @param contract a vincular
		 * @param category a vincular
		 */
		public static void link(Contract contract, ContractCategory category) {
			contract._setContractCategory(category);
			category._getContracts().add(contract);
		}

		/**
		 * Desvincula un contrato de una categoria
		 * @param contract a desvincular
		 */
		public static void unlink(Contract contract) {
			contract.getContractCategory()._getContracts().remove(contract);
			contract._setContractCategory(null);
		}
	}

	/**
	 * Clase que vincula un contrato con un tipo de contrato
	 * @author Javier Martinez
	 *
	 */
	public static class Typefy {
		/**
		 * Vincula un contrato con un tipo de contrato
		 * @param contract a vincular
		 * @param type a vincular
		 */
		public static void link(Contract contract, ContractType type) {
			contract._setContractType(type);
			type._getContracts().add(contract);
		}

		/**
		 * Desvincula un contrato con un tipo de contrato
		 * @param contract a desvincular
		 */
		public static void unlink(Contract contract) {
			contract.getContractType()._getContracts().remove(contract);
			contract._setContractType(null);
		}
	}

	/**
	 * Clase que vincula un contrato con un mecanico
	 * @author Javier Martinez
	 *
	 */
	public static class Hire {
		/**
		 * Vincula un contrato con un mecanico
		 * @param contract a vincular
		 * @param mecanico a vincular
		 */
		public static void link(Contract contract, Mecanico mecanico) {
			contract._setMechanic(mecanico);
			mecanico._getContracts().add(contract);
		}

		/**
		 * Desvincula un contrato con un mecanico
		 * @param contract
		 */
		public static void unlink(Contract contract) {
			contract.getMechanic()._getContracts().remove(contract);
			contract._setMechanic(null);
		}
	}

	/**
	 * Clase que vincula un contato con una nomina
	 * @author Javier Martinez
	 *
	 */
	public static class Payrolls {
		/**
		 * Vicnula un contrato con una nomina
		 * @param contract a vincular
		 * @param payroll a vincular
		 */
		public static void link(Contract contract, Payroll payroll) {
			payroll._setContract(contract);
			contract._getPayrolls().add(payroll);
		}

		/**
		 * Desvincula una nomina con un contrato
		 * @param payroll a desvincular
		 */
		public static void unlink(Payroll payroll) {
			payroll.getContract()._getPayrolls().remove(payroll);
			payroll._setContract(null);
		}
	}

}
