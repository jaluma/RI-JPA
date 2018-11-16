package uo.ri.business.impl.util;

import uo.ri.business.dto.ClientDto;
import uo.ri.business.dto.ContractCategoryDto;
import uo.ri.business.dto.ContractDto;
import uo.ri.business.dto.ContractTypeDto;
import uo.ri.business.dto.MechanicDto;
import uo.ri.conf.Factory;
import uo.ri.model.Cliente;
import uo.ri.model.Contract;
import uo.ri.model.ContractCategory;
import uo.ri.model.ContractType;
import uo.ri.model.Mecanico;
import uo.ri.model.types.Address;
import uo.ri.model.types.ContratoStatus;

public class EntityAssembler {

	public static Mecanico toEntity(MechanicDto dto) {
		return new Mecanico(dto.dni, dto.name, dto.surname);
	}

	public static Cliente toEntity(ClientDto dto) {
		Cliente c = new Cliente(dto.dni, dto.name, dto.surname);
		Address addr = new Address(dto.addressStreet, dto.addressCity, dto.addressZipcode);
		c.setAddress(addr);
		c.setPhone(dto.phone);
		c.setEmail(dto.email);
		return c;
	}

	public static Contract toEntity(ContractDto dto) {
		Mecanico m = Factory.repository.forMechanic().findByDni(dto.dni);
		ContractCategory category = Factory.repository.forCategoriaContrato().findById(dto.categoryId);
		ContractType type = Factory.repository.forTipoContrato().findById(dto.typeId);

		Contract c = new Contract(m, dto.startDate, dto.endDate, dto.yearBaseSalary, dto.compensation,
				Enum.valueOf(ContratoStatus.class, dto.status), category, type);

		return c;
	}

	public static ContractCategory toEntity(ContractCategoryDto dto) {
		ContractCategory category = new ContractCategory(dto.name, dto.trieniumSalary, dto.productivityPlus);
		return category;
	}

	public static ContractType toEntity(ContractTypeDto dto) {
		ContractType type = new ContractType(dto.name, dto.compensationDays);
		return type;
	}

}
