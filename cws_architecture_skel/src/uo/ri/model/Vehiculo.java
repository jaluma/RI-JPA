package uo.ri.model;

import java.util.HashSet;
import java.util.Set;

public class Vehiculo {
	private Long id;

	private String marca;
	private String matricula;
	private String modelo;

	private int numAverias = 0;

	private Cliente cliente;
	private TipoVehiculo tipo;
	private Set<Averia> averias = new HashSet<>();

	/*
	 * Constructor usado por el mapper
	 */
	Vehiculo() {
	}

	/**
	 * Constructor de Vehiculo
	 * @param matricula del vehiculo
	 */
	public Vehiculo(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * Constructor de Vehiculo
	 * @param matricula del vehiculo
	 * @param marca del vehiculo
	 * @param modelo del vehiculo
	 */
	public Vehiculo(String matricula, String marca, String modelo) {
		this(matricula);
		this.marca = marca;
		this.modelo = modelo;
	}

	/**
	 * Getter para la asociacione
	 * @return set de averias
	 */
	Set<Averia> _getAverias() {
		return averias;
	}
	
	/**
	 * Setter de tipo de la asociacion
	 * @param tipo del vehiculo
	 */
	void _setTipo(TipoVehiculo tipo) {
		this.tipo = tipo;
	}

	/**
	 * Setter de tipo de la asociacion
	 * @param tipo del vehiculo
	 */
	void _setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * Getter de averias
	 * @return set de averias
	 */
	public Set<Averia> getAverias() {
		return new HashSet<Averia>(averias);
	}

	/**
	 * Setter de tipo de la asociacion
	 * @param averias set de averias
	 */
	void _setAverias(Set<Averia> averias) {
		this.averias = averias;
	}
	
	/**
	 * Getter de ID
	 * @return id del vehiculo
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Getter de marca
	 * @return marca del vehicuo
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Getter de matricula
	 * @return matricula del vehicuo
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Getter de modelo
	 * @return modelo del vehicuo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Getter de numero de averias
	 * @return numero de averias del vehicuo
	 */
	public int getNumAverias() {
		numAverias = averias.size();
		return numAverias;
	}
	
	/**
	 * Getter de cliente
	 * @return cliente del vehicuo
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Getter de tipo
	 * @return tipo del vehicuo
	 */
	public TipoVehiculo getTipo() {
		return tipo;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
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
		Vehiculo other = (Vehiculo) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vehiculo [marca=" + marca + ", matricula=" + matricula
				+ ", modelo=" + modelo + ", numAverias=" + numAverias
				+ ", cliente=" + cliente + ", tipo=" + tipo + ", averias="
				+ averias + "]";
	}
}
