package uo.ri.business.impl.invoice;

import java.util.List;
import java.util.Map;

import uo.ri.business.InvoiceService;
import uo.ri.business.dto.BreakdownDto;
import uo.ri.business.dto.InvoiceDto;
import uo.ri.business.dto.PaymentMeanDto;
import uo.ri.business.exception.BusinessException;
import uo.ri.business.impl.CommandExecutor;
import uo.ri.business.impl.invoice.command.CreateInvoiceFor;
import uo.ri.business.impl.invoice.command.FindInvoice;
import uo.ri.business.impl.invoice.command.FindPayMethodsforInvoice;
import uo.ri.business.impl.invoice.command.FindRepairsByClient;
import uo.ri.business.impl.invoice.command.SettleInvoice;
import uo.ri.conf.Factory;

public class InvoiceServiceImpl implements InvoiceService {

	private CommandExecutor executor = Factory.executor.forExecutor();

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.InvoiceService#createInvoiceFor(java.util.List)
	 */
	@Override
	public InvoiceDto createInvoiceFor(List<Long> idsAveria) throws BusinessException {
		return executor.execute(new CreateInvoiceFor(idsAveria));
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.InvoiceService#findInvoice(java.lang.Long)
	 */
	@Override
	public InvoiceDto findInvoice(Long numeroInvoiceDto) throws BusinessException {
		return executor.execute(new FindInvoice(numeroInvoiceDto));
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.InvoiceService#findPayMethodsForInvoice(java.lang.Long)
	 */
	@Override
	public List<PaymentMeanDto> findPayMethodsForInvoice(Long idInvoiceDto) throws BusinessException {
		return executor.execute(new FindPayMethodsforInvoice(idInvoiceDto));
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.InvoiceService#settleInvoice(java.lang.Long, java.util.Map)
	 */
	@Override
	public void settleInvoice(Long idInvoiceDto, Map<Long, Double> cargos) throws BusinessException {
		executor.execute(new SettleInvoice(idInvoiceDto, cargos));
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.InvoiceService#findRepairsByClient(java.lang.String)
	 */
	@Override
	public List<BreakdownDto> findRepairsByClient(String dni) throws BusinessException {
		return executor.execute(new FindRepairsByClient(dni));
	}

}
