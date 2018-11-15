package uo.ri.business.impl.mechanic.command;

import uo.ri.business.dto.MechanicDto;
import uo.ri.business.exception.BusinessCheck;
import uo.ri.business.exception.BusinessException;
import uo.ri.business.impl.Command;
import uo.ri.business.impl.util.EntityAssembler;
import uo.ri.business.repository.MecanicoRepository;
import uo.ri.conf.Factory;
import uo.ri.model.Mecanico;

public class AddMechanic implements Command<Void> {

	private MechanicDto dto;
	private MecanicoRepository repo = Factory.repository.forMechanic();

	public AddMechanic(MechanicDto mecanico) {
		this.dto = mecanico;
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.impl.Command#execute()
	 */
	@Override
	public Void execute() throws BusinessException {
		checkUniqueDni(dto.dni);
		Mecanico mecanico = EntityAssembler.toEntity(dto);
		repo.add(mecanico);

		return null;
	}

	private void checkUniqueDni(String dni) throws BusinessException {
		Mecanico m = repo.findByDni(dto.dni);
		BusinessCheck.isNull(m, "El mecánico no existe.");
	}

}
