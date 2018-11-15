package uo.ri.model;

import java.util.HashSet;
import java.util.Set;

public class ContractType {

	private Long id;

	private String name;
	private int compensationDays;

	private Set<Contract> contracts = new HashSet<>();

	ContractType() {
	}

	public ContractType(String name) {
		this.name = name;
	}

	public ContractType(String name, int compensationDays) {
		this(name);
		this.compensationDays = compensationDays;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getCompensationDays() {
		return compensationDays;
	}

	public Set<Contract> getContracts() {
		return new HashSet<>(contracts);
	}

	Set<Contract> _getContracts() {
		return contracts;
	}

}
