package uo.ri.business.impl.mechanic.command;

import uo.ri.business.exception.BusinessCheck;
import uo.ri.business.exception.BusinessException;
import uo.ri.business.impl.Command;
import uo.ri.business.repository.MecanicoRepository;
import uo.ri.conf.Factory;
import uo.ri.model.Mecanico;

public class DeleteMechanic implements Command<Void> {

	private Long idMecanico;
	private MecanicoRepository repo = Factory.repository.forMechanic();

	public DeleteMechanic(Long idMecanico) {
		this.idMecanico = idMecanico;
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.impl.Command#execute()
	 */
	@Override
	public Void execute() throws BusinessException {
		Mecanico m = repo.findById(idMecanico);
		checkCanBeDelete(m);
		repo.remove(m);

		return null;
	}

	private void checkCanBeDelete(Mecanico m) throws BusinessException {
		BusinessCheck.isNotNull(m, "El mecánico no existe.");
		BusinessCheck.isTrue(m.getIntervenciones().size() <= 0,
				"No se puede borrar el mecánico al tener intervenciones.");
		BusinessCheck.isTrue(m.getAsignadas().size() <= 0,
				"No se puede borrar el mecánico al tener averias asignadas.");
	}

}
