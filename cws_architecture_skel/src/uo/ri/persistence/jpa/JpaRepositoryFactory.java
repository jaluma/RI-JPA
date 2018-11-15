package uo.ri.persistence.jpa;

import uo.ri.business.repository.AveriaRepository;
import uo.ri.business.repository.CargoRepository;
import uo.ri.business.repository.CategoriaContratoRepository;
import uo.ri.business.repository.ClienteRepository;
import uo.ri.business.repository.ContratoRepository;
import uo.ri.business.repository.FacturaRepository;
import uo.ri.business.repository.IntervencionRepository;
import uo.ri.business.repository.MecanicoRepository;
import uo.ri.business.repository.MedioPagoRepository;
import uo.ri.business.repository.NominaRepository;
import uo.ri.business.repository.RepositoryFactory;
import uo.ri.business.repository.RepuestoRepository;
import uo.ri.business.repository.TipoContratoRepository;

public class JpaRepositoryFactory implements RepositoryFactory {

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.repository.RepositoryFactory#forMechanic()
	 */
	@Override
	public MecanicoRepository forMechanic() {
		return new MechanicJpaRepository();
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.repository.RepositoryFactory#forAveria()
	 */
	@Override
	public AveriaRepository forAveria() {
		return new AveriaJpaRepository();
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.repository.RepositoryFactory#forMedioPago()
	 */
	@Override
	public MedioPagoRepository forMedioPago() {
		return new MedioPagoJpaRepository();
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.repository.RepositoryFactory#forFactura()
	 */
	@Override
	public FacturaRepository forFactura() {
		return new FacturaJpaRepository();
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.repository.RepositoryFactory#forCliente()
	 */
	@Override
	public ClienteRepository forCliente() {
		return new ClienteJpaRepository();
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.repository.RepositoryFactory#forRepuesto()
	 */
	@Override
	public RepuestoRepository forRepuesto() {
		return new RepuestoJpaRepository();
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.repository.RepositoryFactory#forIntervencion()
	 */
	@Override
	public IntervencionRepository forIntervencion() {
		return new InterventionJpaRepository();
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.repository.RepositoryFactory#forContrato()
	 */
	@Override
	public ContratoRepository forContrato() {
		return new ContratoJpaRepository();
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.repository.RepositoryFactory#forCategoriaContrato()
	 */
	@Override
	public CategoriaContratoRepository forCategoriaContrato() {
		return new CategoriaJpaRepository();
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.repository.RepositoryFactory#forTipoContrato()
	 */
	@Override
	public TipoContratoRepository forTipoContrato() {
		return new TipoContratoJpaRepository();
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.repository.RepositoryFactory#forCargo()
	 */
	@Override
	public CargoRepository forCargo() {
		return new CargoJpaRepository();
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.repository.RepositoryFactory#forNomina()
	 */
	@Override
	public NominaRepository forNomina() {
		return new NominaJpaRepository();
	}

}
