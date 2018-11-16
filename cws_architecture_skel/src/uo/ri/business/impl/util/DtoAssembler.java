package uo.ri.business.impl.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import uo.ri.business.dto.BreakdownDto;
import uo.ri.business.dto.CardDto;
import uo.ri.business.dto.CashDto;
import uo.ri.business.dto.ClientDto;
import uo.ri.business.dto.ContractCategoryDto;
import uo.ri.business.dto.ContractDto;
import uo.ri.business.dto.ContractTypeDto;
import uo.ri.business.dto.InvoiceDto;
import uo.ri.business.dto.MechanicDto;
import uo.ri.business.dto.PaymentMeanDto;
import uo.ri.business.dto.PayrollDto;
import uo.ri.business.dto.VoucherDto;
import uo.ri.model.Averia;
import uo.ri.model.Bono;
import uo.ri.model.Cliente;
import uo.ri.model.Contract;
import uo.ri.model.ContractCategory;
import uo.ri.model.ContractType;
import uo.ri.model.Factura;
import uo.ri.model.Mecanico;
import uo.ri.model.MedioPago;
import uo.ri.model.Metalico;
import uo.ri.model.Payroll;
import uo.ri.model.TarjetaCredito;

public class DtoAssembler {

	/**
	 * Convierte un cliente en una dto de cliente
	 * @param c cliente
	 * @return dto del cliente dado
	 */
	public static ClientDto toDto(Cliente c) {
		ClientDto dto = new ClientDto();

		dto.id = c.getId();
		dto.dni = c.getDni();
		dto.name = c.getNombre();
		dto.surname = c.getApellidos();

		return dto;
	}

	/**
	 * Convierte una lista de clientes to una lista de dtos
	 * @param clientes lista
	 * @return lista de dtos
	 */
	public static List<ClientDto> toClientDtoList(List<Cliente> clientes) {
		List<ClientDto> res = new ArrayList<>();
		for (Cliente c : clientes) {
			res.add(DtoAssembler.toDto(c));
		}
		return res;
	}

	/**
	 * Convierte un mecanico en una dto de mecanico
	 * @param m mecanico
	 * @return dto del mecanico dado
	 */
	public static MechanicDto toDto(Mecanico m) {
		MechanicDto dto = new MechanicDto();
		dto.id = m.getId();
		dto.dni = m.getDni();
		dto.name = m.getNombre();
		dto.surname = m.getApellidos();
		return dto;
	}

	/**
	 * Convierte una lista de mecanicos to una lista de dtos
	 * @param list lista
	 * @return lista de dtos
	 */
	public static List<MechanicDto> toMechanicDtoList(List<Mecanico> list) {
		List<MechanicDto> res = new ArrayList<>();
		for (Mecanico m : list) {
			res.add(toDto(m));
		}
		return res;
	}

	/**
	 * Convierte una lista de clientes to una lista de dtos
	 * @param clientes lista
	 * @return lista de dtos
	 */
	public static List<VoucherDto> toVoucherDtoList(List<Bono> list) {
		List<VoucherDto> res = new ArrayList<>();
		for (Bono b : list) {
			res.add(toDto(b));
		}
		return res;
	}

	/**
	 * Convierte un bono en una dto de bono
	 * @param b bono
	 * @return dto del bono dado
	 */
	public static VoucherDto toDto(Bono b) {
		VoucherDto dto = new VoucherDto();
		dto.id = b.getId();
		dto.clientId = b.getCliente().getId();
		dto.accumulated = b.getAcumulado();
		dto.code = b.getCodigo();
		dto.description = b.getDescripcion();
		dto.available = b.getDisponible();
		return dto;
	}

	/**
	 * Convierte un tarjeta en una dto de tarjeta
	 * @param tc tarjeta
	 * @return dto del tarjeta dado
	 */
	public static CardDto toDto(TarjetaCredito tc) {
		CardDto dto = new CardDto();
		dto.id = tc.getId();
		dto.clientId = tc.getCliente().getId();
		dto.accumulated = tc.getAcumulado();
		dto.cardNumber = tc.getNumero();
		dto.cardExpiration = tc.getValidez();
		dto.cardType = tc.getTipo();
		return dto;
	}

	/**
	 * Convierte un metalico en una dto de metalico
	 * @param m metalico
	 * @return dto del metalico dado
	 */
	public static CashDto toDto(Metalico m) {
		CashDto dto = new CashDto();
		dto.id = m.getId();
		dto.clientId = m.getCliente().getId();
		dto.accumulated = m.getAcumulado();
		return dto;
	}

	/**
	 * Convierte una factura en una dto de factura
	 * @param factura factura
	 * @return dto del factura dado
	 */
	public static InvoiceDto toDto(Factura factura) {
		InvoiceDto dto = new InvoiceDto();
		dto.id = factura.getId();
		dto.number = factura.getNumero();
		dto.date = factura.getFecha();
		dto.total = factura.getImporte();
		dto.vat = factura.getIva();
		dto.status = factura.getStatus().toString();
		return dto;
	}

	/**
	 * Convierte una lista de medios de pago to una lista de dtos
	 * @param list lista
	 * @return lista de dtos
	 */
	public static List<PaymentMeanDto> toPaymentMeanDtoList(List<MedioPago> list) {
		return list.stream().map(mp -> toDto(mp)).collect(Collectors.toList());
	}

	/**
	 * Convierte un medio de pago en una dto de medio de pago
	 * @param mp medio de pago
	 * @return dto del medio de pago dado
	 */
	private static PaymentMeanDto toDto(MedioPago mp) {
		if (mp instanceof Bono) {
			return toDto((Bono) mp);
		} else if (mp instanceof TarjetaCredito) {
			return toDto((TarjetaCredito) mp);
		} else if (mp instanceof Metalico) {
			return toDto((Metalico) mp);
		} else {
			throw new RuntimeException("Unexpected type of payment mean");
		}
	}

	/**
	 * Convierte una lista de averia to una lista de dtos
	 * @param list lista
	 * @return lista de dtos
	 */
	public static List<BreakdownDto> toBreakdownDtoList(List<Averia> list) {
		return list.stream().map(a -> toDto(a)).collect(Collectors.toList());
	}

	/**
	 * Convierte una averia en una dto de averia
	 * @param mp averia
	 * @return dto de averia dado
	 */
	public static BreakdownDto toDto(Averia a) {
		BreakdownDto dto = new BreakdownDto();
		dto.id = a.getId();
		dto.invoiceId = a.getFactura().getId();
		dto.vehicleId = a.getVehiculo().getId();
		dto.description = a.getDescripcion();
		dto.date = a.getFecha();
		dto.total = a.getImporte();
		dto.status = a.getStatus().toString();
		return dto;
	}

	/**
	 * Convierte un contrato en una dto de contrato
	 * @param c contrato
	 * @return dto del contrato dado
	 */
	public static ContractDto toDto(Contract c) {
		ContractDto dto = new ContractDto();
		dto.mechanicId = c.getMechanic().getId();
		dto.typeId = c.getContractType().getId();
		dto.categoryId = c.getContractCategory().getId();
		dto.startDate = c.getStartDate();
		dto.endDate = c.getEndDate();
		dto.yearBaseSalary = c.getBaseSalaryPerYear();
		dto.id = c.getId();
		dto.compensation = c.getCompensation();
		dto.status = c.getStatus().toString();
		dto.dni = c.getMechanic().getDni();
		dto.categoryName = c.getContractCategory().getName();
		dto.typeName = c.getContractType().getName();

		return dto;
	}

	/**
	 * Convierte una lista de contratos to una lista de dtos
	 * @param list lista
	 * @return lista de dtos
	 */
	public static List<ContractDto> toContractDtoList(List<Contract> list) {
		return list.stream().map(c -> toDto(c)).collect(Collectors.toList());
	}

	/**
	 * Convierte una categoria de contrato en una dto de categoria de contrato
	 * @param c categoria de contrato
	 * @return dto de categoria de contrato dado
	 */
	public static ContractCategoryDto toDto(ContractCategory c) {
		ContractCategoryDto dto = new ContractCategoryDto();
		dto.id = c.getId();
		dto.name = c.getName();
		dto.productivityPlus = c.getProductivityPlus();
		dto.trieniumSalary = c.getTrieniumSalary();
		return dto;
	}

	/**
	 * Convierte una lista de categorias de contrato to una lista de dtos
	 * @param list lista
	 * @return lista de dtos
	 */
	public static List<ContractCategoryDto> toContractCategoryDtoList(List<ContractCategory> list) {
		return list.stream().map(c -> toDto(c)).collect(Collectors.toList());
	}

	/**
	 * Convierte un tipo de contrato en una dto de tipo de contrato
	 * @param c tipo de ocntrato
	 * @return dto del tipo de contrato dado
	 */
	public static ContractTypeDto toDto(ContractType c) {
		ContractTypeDto dto = new ContractTypeDto();
		dto.id = c.getId();
		dto.name = c.getName();
		dto.compensationDays = c.getCompensationDays();
		return dto;
	}

	/**
	 * Convierte una lista de tipo de contratos to una lista de dtos
	 * @param list lista
	 * @return lista de dtos
	 */
	public static List<ContractTypeDto> toContractTypeDtoList(List<ContractType> list) {
		return list.stream().map(t -> toDto(t)).collect(Collectors.toList());
	}

	/**
	 * Convierte una nomina en una dto de nomina
	 * @param p nomina
	 * @return dto de la nomina dada
	 */
	public static PayrollDto toDto(Payroll p) {
		PayrollDto dto = new PayrollDto();
		dto.id = p.getId();
		dto.baseSalary = p.getBaseSalary();
		dto.date = p.getDate();
		dto.discountTotal = p.getDiscountTotal();
		dto.extraSalary = p.getExtraSalary();
		dto.grossTotal = p.getGrossTotal();
		dto.irpf = p.getIrpf();
		dto.netTotal = p.getNetTotal();
		dto.productivity = p.getProductivity();
		dto.socialSecurity = p.getSocialSecurity();
		dto.triennium = p.getTriennium();

		return dto;
	}

	/**
	 * Convierte una lista de medios de pago to una lista de dtos
	 * @param list lista
	 * @return lista de dtos
	 */
	public static List<PayrollDto> toPayrollDtoList(List<Payroll> list) {
		return list.stream().map(p -> toDto(p)).collect(Collectors.toList());
	}

}
