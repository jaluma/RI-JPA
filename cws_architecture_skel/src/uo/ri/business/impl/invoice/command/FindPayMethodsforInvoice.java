package uo.ri.business.impl.invoice.command;

import java.util.List;

import uo.ri.business.dto.PaymentMeanDto;
import uo.ri.business.exception.BusinessException;
import uo.ri.business.impl.Command;
import uo.ri.business.impl.util.DtoAssembler;
import uo.ri.business.repository.MedioPagoRepository;
import uo.ri.conf.Factory;

public class FindPayMethodsforInvoice implements Command<List<PaymentMeanDto>> {
	private Long idInvoice;
	private MedioPagoRepository repoMedio = Factory.repository.forMedioPago();

	/**
	 * Constructor que permite encontrar metodos de pago de una factura
	 * @param idInvoiceDto de la factura
	 */
	public FindPayMethodsforInvoice(Long idInvoiceDto) {
		this.idInvoice = idInvoiceDto;
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.impl.Command#execute()
	 */
	@Override
	public List<PaymentMeanDto> execute() throws BusinessException {
		return DtoAssembler.toPaymentMeanDtoList(repoMedio.FindPayMethodsforInvoice(idInvoice));
	}

}
