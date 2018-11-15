package uo.ri.model;

public class Association {

	public static class Poseer {

		public static void link(Cliente cliente, Vehiculo vehiculo) {
			vehiculo._setCliente(cliente);
			cliente._getVehiculo().add(vehiculo);
		}

		public static void unlink(Cliente cliente, Vehiculo vehiculo) {
			cliente._getVehiculo().remove(vehiculo);
			vehiculo._setCliente(null);
		}
	}

	public static class Clasificar {

		public static void link(TipoVehiculo tipoVehiculo, Vehiculo vehiculo) {
			vehiculo._setTipo(tipoVehiculo);
			tipoVehiculo._getVehiculo().add(vehiculo);

		}

		public static void unlink(TipoVehiculo tipoVehiculo, Vehiculo vehiculo) {
			tipoVehiculo._getVehiculo().remove(vehiculo);
			vehiculo._setTipo(null);
		}
	}

	public static class Pagar {

		public static void link(MedioPago medioPago, Cliente cliente) {
			medioPago._setCliente(cliente);
			cliente._getMedioPago().add(medioPago);
		}

		public static void unlink(MedioPago medioPago, Cliente cliente) {
			cliente._getMedioPago().remove(medioPago);
			medioPago._setCliente(null);
		}

		public static void unlink(Cliente cliente, MedioPago metalico) {
			unlink(metalico, cliente);
		}
	}

	public static class Averiar {

		public static void link(Vehiculo vehiculo, Averia averia) {
			averia._setVehiculo(vehiculo);
			vehiculo._getAverias().add(averia);
		}

		public static void unlink(Vehiculo vehiculo, Averia averia) {
			vehiculo._getAverias().remove(averia);
			averia._setVehiculo(null);
		}
	}

	public static class Facturar {
		public static void link(Factura factura, Averia averia) {
			averia._setFactura(factura);
			factura._getAverias().add(averia);
		}

		public static void unlink(Factura factura, Averia averia) {
			factura._getAverias().remove(averia);
			averia._setFactura(null);
		}
	}

	public static class Cargar {

		public static void link(Factura factura, MedioPago medioPago, Cargo cargo) {
			cargo._setMedioPago(medioPago);
			cargo._setFactura(factura);
			medioPago._getCargos().add(cargo);
			factura._getCargos().add(cargo);
		}

		public static void unlink(Cargo cargo) {
			cargo.getFactura()._getCargos().remove(cargo);
			cargo.getMedioPago()._getCargos().remove(cargo);
			cargo._setMedioPago(null);
			cargo._setFactura(null);
		}
	}

	public static class Asignar {

		public static void link(Mecanico mecanico, Averia averia) {
			averia._setMecanico(mecanico);
			mecanico.getAverias().add(averia);
		}

		public static void unlink(Mecanico mecanico, Averia averia) {
			mecanico.getAverias().remove(averia);
			averia._setMecanico(null);
		}
	}

	public static class Intervenir {
		public static void link(Mecanico mecanico, Averia averia, Intervencion intervencion) {
			intervencion._setMecanico(mecanico);
			intervencion._setAveria(averia);
			mecanico._getIntervenciones().add(intervencion);
			averia._getIntervenciones().add(intervencion);
		}

		public static void unlink(Intervencion intervencion) {
			intervencion.getMecanico()._getIntervenciones().remove(intervencion);
			intervencion.getAveria()._getIntervenciones().remove(intervencion);
			intervencion._setMecanico(null);
			intervencion._setAveria(null);
		}
	}

	public static class Sustituir {
		public static void link(Intervencion intervencion, Repuesto repuesto, Sustitucion sustitucion) {
			sustitucion._setIntervencion(intervencion);
			sustitucion._setRepuesto(repuesto);
			intervencion._getSustituciones().add(sustitucion);
			repuesto._getSustituciones().add(sustitucion);
		}

		public static void unlink(Sustitucion sustitucion) {
			sustitucion.getIntervencion()._getSustituciones().remove(sustitucion);
			sustitucion.getRepuesto()._getSustituciones().remove(sustitucion);
			sustitucion._setIntervencion(null);
			sustitucion._setRepuesto(null);
		}
	}

	public static class Categorize {
		public static void link(Contract contract, ContractCategory category) {
			contract._setContractCategory(category);
			category._getContracts().add(contract);
		}

		public static void unlink(Contract contract) {
			contract.getContractCategory()._getContracts().remove(contract);
			contract._setContractCategory(null);
		}
	}

	public static class Typefy {
		public static void link(Contract contract, ContractType type) {
			contract._setContractType(type);
			type._getContracts().add(contract);
		}

		public static void unlink(Contract contract) {
			contract.getContractType()._getContracts().remove(contract);
			contract._setContractType(null);
		}
	}

	public static class Hire {
		public static void link(Contract contract, Mecanico mecanico) {
			contract._setMechanic(mecanico);
			mecanico._getContratos().add(contract);
		}

		public static void unlink(Contract contract) {
			contract.getMechanic()._getContratos().remove(contract);
			contract._setMechanic(null);
		}
	}

	public static class Payrolls {
		public static void link(Contract contract, Payroll payroll) {
			payroll._setContract(contract);
			contract._getPayrolls().add(payroll);
		}

		public static void unlink(Payroll payroll) {
			payroll.getContract()._getPayrolls().remove(payroll);
			payroll._setContract(null);
		}
	}

}
