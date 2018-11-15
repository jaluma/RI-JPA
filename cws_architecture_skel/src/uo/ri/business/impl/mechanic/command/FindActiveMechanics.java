package uo.ri.business.impl.mechanic.command;

import java.util.List;

import uo.ri.business.dto.MechanicDto;
import uo.ri.business.impl.Command;
import uo.ri.business.impl.util.DtoAssembler;
import uo.ri.business.repository.MecanicoRepository;
import uo.ri.conf.Factory;
import uo.ri.model.Mecanico;

public class FindActiveMechanics implements Command<List<MechanicDto>> {

	private MecanicoRepository repo = Factory.repository.forMechanic();

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.impl.Command#execute()
	 */
	@Override
	public List<MechanicDto> execute() {
		List<Mecanico> mecanicos = repo.findActive();
		return DtoAssembler.toMechanicDtoList(mecanicos);
	}

}
