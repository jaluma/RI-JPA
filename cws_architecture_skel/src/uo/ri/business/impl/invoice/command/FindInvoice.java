package uo.ri.business.impl.invoice.command;

import uo.ri.business.dto.InvoiceDto;
import uo.ri.business.exception.BusinessException;
import uo.ri.business.impl.Command;
import uo.ri.business.impl.util.DtoAssembler;
import uo.ri.business.repository.FacturaRepository;
import uo.ri.conf.Factory;

public class FindInvoice implements Command<InvoiceDto> {

	private Long numero;
	private FacturaRepository repoFactura = Factory.repository.forFactura();

	public FindInvoice(Long numero) {
		this.numero = numero;
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.impl.Command#execute()
	 */
	@Override
	public InvoiceDto execute() throws BusinessException {
		return DtoAssembler.toDto(repoFactura.findByNumber(numero));
	}
}
