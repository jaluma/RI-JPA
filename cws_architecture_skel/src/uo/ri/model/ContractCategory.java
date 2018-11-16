package uo.ri.model;

import java.util.HashSet;
import java.util.Set;

public class ContractCategory {

	private Long id;

	private String name;
	private double trieniumSalary;
	private double productivityPlus;

	private Set<Contract> contracts = new HashSet<>();

	/*
	 * Constructor usado por el mapper
	 */
	ContractCategory() {
	}

	public ContractCategory(String name) {
		this.name = name;
	}

	/**
	 * Constructo de categoria de contratos
	 * @param name de la categoria
	 * @param trienniumSalary de la categoria
	 * @param productivityPlus de la categoria
	 */
	public ContractCategory(String name, double trienniumSalary, double productivityPlus) {
		this(name);
		this.trieniumSalary = trienniumSalary;
		this.productivityPlus = productivityPlus;
	}

	/**
	 * Getter de Id
	 * @return la id de la categoria
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Getter de name
	 * @return la name de la categoria
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter de trienio
	 * @return la trienio de la categoria
	 */
	public double getTrieniumSalary() {
		return trieniumSalary;
	}

	/**
	 * Getter de la productividad
	 * @return la productividad de la categoria
	 */
	public double getProductivityPlus() {
		return productivityPlus;
	}

	/**
	 * Getter de contracts
	 * @return contratos asignados de la categoria
	 */
	public Set<Contract> getContracts() {
		return new HashSet<>(contracts);
	}

	/**
	 * Getter usado en la asociación
	 * @return contratos asignados de la categoria
	 */
	Set<Contract> _getContracts() {
		return contracts;
	}

	/**
	 * Setter de nombre
	 * @param name de la categoria
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Setter del trienio
	 * @param trienio de la categoria
	 */
	public void setTrieniumSalary(double trieniumSalary) {
		this.trieniumSalary = trieniumSalary;
	}

	/**
	 * Setter de la productividad
	 * @param la productividad de la categoria
	 */
	public void setProductivityPlus(double productivityPlus) {
		this.productivityPlus = productivityPlus;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ContractCategory [name=" + name + ", trieniumSalary="
				+ trieniumSalary + ", productivityPlus=" + productivityPlus
				+ ", contracts=" + contracts + "]";
	}
	
}
