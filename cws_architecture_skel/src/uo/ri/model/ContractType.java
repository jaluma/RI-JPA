package uo.ri.model;

import java.util.HashSet;
import java.util.Set;

public class ContractType {

	private Long id;

	private String name;
	private int compensationDays;

	private Set<Contract> contracts = new HashSet<>();

	/*
	 * Constructor usado por el mapper
	 */
	ContractType() {
	}

	/**
	 * Constructor de tipo de contrato
	 * @param name del tipo
	 */
	public ContractType(String name) {
		this.name = name;
	}

	/**
	 * Constructor de tipo de contrato
	 * @param name del tipo
	 * @param compensationDays del tipo
	 */
	public ContractType(String name, int compensationDays) {
		this(name);
		setCompensation(compensationDays);
	}

	/**
	 * Getter de Id
	 * @return Id del tipo
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Getter de nombre
	 * @return nombre del tipo
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter de compensacion
	 * @return compensacion del tipo
	 */
	public int getCompensationDays() {
		return compensationDays;
	}

	/**
	 * Getter de contratos
	 * @return set de contratos
	 */
	public Set<Contract> getContracts() {
		return new HashSet<>(contracts);
	}

	/**
	 * Getter de contratos usados en la asociacion
	 * @return contrato
	 */
	Set<Contract> _getContracts() {
		return contracts;
	}

	/**
	 * Setter de compensacion
	 * @param compensationDays del tipo
	 */
	public void setCompensation(int compensationDays) {
		this.compensationDays = compensationDays;		
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
		ContractType other = (ContractType) obj;
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
		return "ContractType [name=" + name + ", compensationDays="
				+ compensationDays + ", contracts=" + contracts + "]";
	}
}
