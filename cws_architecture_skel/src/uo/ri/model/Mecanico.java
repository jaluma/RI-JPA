package uo.ri.model;

import java.util.HashSet;
import java.util.Set;

import uo.ri.model.types.ContratoStatus;

public class Mecanico {
	private Long id;

	private String dni;
	private String apellidos;
	private String nombre;

	private Set<Averia> asignadas = new HashSet<>();
	private Set<Intervencion> intervenciones = new HashSet<>();
	private Set<Contract> contracts = new HashSet<>();

	/*
	 * Constructor usado por el mapper
	 */
	Mecanico() {
	}

	/**
	 * Constructor de mecanico
	 * @param dni del mecanico
	 */
	public Mecanico(String dni) {
		this.dni = dni;
	}

	/**
	 * Constructor de mecanico
	 * @param dni del mecanico
	 * @param nombre del mecanico
	 * @param apellido del mecacico
	 */
	public Mecanico(String dni, String nombre, String apellido) {
		this(dni);
		this.nombre = nombre;
		this.apellidos = apellido;
	}

	/**
	 * Getter de Id
	 * @return id del mecanico
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Getter de intervenciones
	 * @return intervenciones del mecanico
	 */
	public Set<Intervencion> getIntervenciones() {
		return new HashSet<>(intervenciones);
	}

	/**
	 * Getter de dni
	 * @return dni del mecanico
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Getter de apellido
	 * @return apellido del mecanico
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Getter de nombre
	 * @return nombre del mecanico
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Getter de asignadas
	 * @return averias asignadas del mecanico
	 */
	public Set<Averia> getAsignadas() {
		return new HashSet<>(asignadas);
	}

	/**
	 * Getter de contratos
	 * @return contratos del mecanico
	 */
	public Set<Contract> getContracts() {
		return new HashSet<>(contracts);
	}
	
	/**
	 * Getter de contratos usado para la asociacion
	 * @return contratos del mecanico
	 */
	Set<Contract> _getContracts() {
		return contracts;
	}

	/**
	 * Getter de intervenciones usado para la asociacion
	 * @return intervenciones del mecanico
	 */
	Set<Intervencion> _getIntervenciones() {
		return intervenciones;
	}
	
	/**
	 * Getter de asignadas usado para la asociacion
	 * @return asignadas del mecanico
	 */
	Set<Averia> _getAsignadas() {
		return asignadas;
	}
	
	/**
	 * Setter de nombre
	 * @param nombre del mecanico
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Setter de apellido
	 * @param apellido del mecanico
	 */
	public void setApellidos(String apellido) {
		this.apellidos = apellido;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		Mecanico other = (Mecanico) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Mecanico [dni=" + dni + ", apellidos=" + apellidos + ", nombre="
				+ nombre + ", asignadas=" + asignadas + ", intervenciones="
				+ intervenciones + ", contracts=" + contracts + "]";
	}

	/**
	 * Devuelve el contrato activo
	 * @return contrato activo o null si no tiene ninguno
	 */
	public Contract getActiveContract() {
		for (Contract contract : contracts) {
			if (contract.getStatus() != null && contract.getStatus().equals(ContratoStatus.ACTIVE)) {
				return contract;
			}
		}
		return null;
	}

	/**
	 * Devuelve el último contrato
	 * @return ultimo contrato vigente
	 */
	public Contract getLastContract() {
		return contracts.stream().sorted((o1, o2) -> o2.getEndDate().compareTo(o1.getEndDate())).findFirst().get();
	}

	
}
