package uo.ri.model;

import java.util.HashSet;
import java.util.Set;

public class ContractCategory {

	private Long id;

	private String name;
	private double trieniumSalary;
	private double productivityPlus;

	private Set<Contract> contracts = new HashSet<>();

	ContractCategory() {
	}

	public ContractCategory(String name) {
		this.name = name;
	}

	public ContractCategory(String name, double trienniumSalary, double productivityPlus) {
		this(name);
		this.trieniumSalary = trienniumSalary;
		this.productivityPlus = productivityPlus;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getTrieniumSalary() {
		return trieniumSalary;
	}

	public double getProductivityPlus() {
		return productivityPlus;
	}

	public Set<Contract> getContracts() {
		return new HashSet<>(contracts);
	}

	Set<Contract> _getContracts() {
		return contracts;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTrieniumSalary(double trieniumSalary) {
		this.trieniumSalary = trieniumSalary;
	}

	public void setProductivityPlus(double productivityPlus) {
		this.productivityPlus = productivityPlus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContractCategory other = (ContractCategory) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ContractCategory [name=" + name + ", trieniumSalary="
				+ trieniumSalary + ", productivityPlus=" + productivityPlus
				+ ", contracts=" + contracts + "]";
	}
	
}
