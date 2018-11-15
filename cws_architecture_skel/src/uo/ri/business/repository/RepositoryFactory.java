package uo.ri.business.repository;

public interface RepositoryFactory {

	MecanicoRepository forMechanic();

	AveriaRepository forAveria();

	MedioPagoRepository forMedioPago();

	FacturaRepository forFactura();

	ClienteRepository forCliente();

	RepuestoRepository forRepuesto();

	IntervencionRepository forIntervencion();

	ContratoRepository forContrato();

	CategoriaContratoRepository forCategoriaContrato();

	TipoContratoRepository forTipoContrato();

	CargoRepository forCargo();

	NominaRepository forNomina();

}
