package uo.ri.business.impl.invoice.command;

import java.util.List;

import uo.ri.business.dto.InvoiceDto;
import uo.ri.business.exception.BusinessException;
import uo.ri.business.impl.Command;
import uo.ri.business.impl.util.DtoAssembler;
import uo.ri.business.repository.AveriaRepository;
import uo.ri.business.repository.FacturaRepository;
import uo.ri.conf.Factory;
import uo.ri.model.Averia;
import uo.ri.model.Factura;

public class CreateInvoiceFor implements Command<InvoiceDto> {

	private List<Long> idsAveria;
	private AveriaRepository repoAveria = Factory.repository.forAveria();
	private FacturaRepository repoFactura = Factory.repository.forFactura();

	/**
	 * Constructor para crear facturas para unas averia
	 * @param idsAveria lista con las averia
	 */
	public CreateInvoiceFor(List<Long> idsAveria) {
		this.idsAveria = idsAveria;
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.business.impl.Command#execute()
	 */
	@Override
	public InvoiceDto execute() throws BusinessException {
		Long numero = repoFactura.getNextInvoiceNumber();

		List<Averia> averias = repoAveria.findByIds(idsAveria);

		Factura f = new Factura(numero, averias);
		repoFactura.add(f);
		return DtoAssembler.toDto(f);
	}

}
