package uo.ri.business.impl.contract.type.command;

import uo.ri.business.exception.BusinessCheck;
import uo.ri.business.exception.BusinessException;
import uo.ri.business.impl.Command;
import uo.ri.business.repository.TipoContratoRepository;
import uo.ri.conf.Factory;
import uo.ri.model.ContractType;

public class DeleteContractType implements Command<Void> {

	private Long idTipo;
	private TipoContratoRepository repo = Factory.repository.forTipoContrato();

	public DeleteContractType(Long idTipo) {
		this.idTipo = idTipo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see uo.ri.business.impl.Command#execute()
	 */
	@Override
	public Void execute() throws BusinessException {
		ContractType c = repo.findById(idTipo);
		checkCanBeDelete(c);
		repo.remove(c);

		return null;
	}

	private void checkCanBeDelete(ContractType t) throws BusinessException {
		BusinessCheck.isNotNull(t, "El tipo de contrato no existe.");
		BusinessCheck.isTrue(t.getContracts().size() <= 0,
				"No se puede borrar el tipo de contrato al tener "
				+ "contratos pertenecientes a este tipo.");
	}

}
