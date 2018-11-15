package uo.ri.business.impl.mechanic;

import java.util.List;

import uo.ri.business.MechanicCrudService;
import uo.ri.business.dto.MechanicDto;
import uo.ri.business.exception.BusinessException;
import uo.ri.business.impl.CommandExecutor;
import uo.ri.business.impl.mechanic.command.AddMechanic;
import uo.ri.business.impl.mechanic.command.DeleteMechanic;
import uo.ri.business.impl.mechanic.command.FindActiveMechanics;
import uo.ri.business.impl.mechanic.command.FindAllMechanics;
import uo.ri.business.impl.mechanic.command.FindMechanicById;
import uo.ri.business.impl.mechanic.command.UpdateMechanic;
import uo.ri.conf.Factory;

public class MechanicCrudServiceImpl implements MechanicCrudService {

	private CommandExecutor executor = Factory.executor.forExecutor();

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.MechanicCrudService#addMechanic(uo.ri.business.dto.MechanicDto)
	 */
	@Override
	public void addMechanic(MechanicDto mecanico) throws BusinessException {
		executor.execute(new AddMechanic(mecanico));
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.MechanicCrudService#updateMechanic(uo.ri.business.dto.MechanicDto)
	 */
	@Override
	public void updateMechanic(MechanicDto mecanico) throws BusinessException {
		executor.execute(new UpdateMechanic(mecanico));
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.MechanicCrudService#deleteMechanic(java.lang.Long)
	 */
	@Override
	public void deleteMechanic(Long idMecanico) throws BusinessException {
		executor.execute(new DeleteMechanic(idMecanico));
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.MechanicCrudService#findAllMechanics()
	 */
	@Override
	public List<MechanicDto> findAllMechanics() throws BusinessException {
		return executor.execute(new FindAllMechanics());
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.MechanicCrudService#findMechanicById(java.lang.Long)
	 */
	@Override
	public MechanicDto findMechanicById(Long id) throws BusinessException {
		return executor.execute(new FindMechanicById(id));
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.MechanicCrudService#findActiveMechanics()
	 */
	@Override
	public List<MechanicDto> findActiveMechanics() throws BusinessException {
		return executor.execute(new FindActiveMechanics());
	}

}