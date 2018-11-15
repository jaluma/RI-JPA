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

	Mecanico() {
	}

	public Mecanico(String dni) {
		this.dni = dni;
	}

	public Mecanico(String dni, String nombre, String apellido) {
		this(dni);
		this.nombre = nombre;
		this.apellidos = apellido;
	}

	public Long getId() {
		return id;
	}

	Set<Contract> _getContracts() {
		return contracts;
	}

	Set<Intervencion> _getIntervenciones() {
		return intervenciones;
	}

	public Set<Intervencion> getIntervenciones() {
		return new HashSet<>(intervenciones);
	}

	Set<Averia> _getAsignadas() {
		return asignadas;
	}

	@Override
	public String toString() {
		return "Mecanico [dni=" + dni + ", apellidos=" + apellidos + ", nombre="
				+ nombre + ", asignadas=" + asignadas + ", intervenciones="
				+ intervenciones + ", contracts=" + contracts + "]";
	}

	public String getDni() {
		return dni;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		Mecanico other = (Mecanico) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	public Set<Averia> getAsignadas() {
		return new HashSet<>(asignadas);
	}

	public Set<Contract> getContracts() {
		return new HashSet<>(contracts);
	}

	public Contract getActiveContract() {
		for (Contract contract : contracts) {
			if (contract.getStatus() != null && contract.getStatus().equals(ContratoStatus.ACTIVE)) {
				return contract;
			}
		}
		return null;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellido) {
		this.apellidos = apellido;
	}

	public Contract getLastContract() {
		return contracts.stream().sorted((o1, o2) -> o2.getEndDate().compareTo(o1.getEndDate())).findFirst().get();
	}

	
}
