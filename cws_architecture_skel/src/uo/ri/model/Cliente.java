package uo.ri.model;

import java.util.HashSet;
import java.util.Set;

import uo.ri.model.types.Address;

public class Cliente {
	private Long id;

	private String dni;
	private String nombre;
	private String apellidos;
	private String email;
	private String phone;
	private Address address;

	private Set<MedioPago> mediosPago = new HashSet<>();

	private Set<Vehiculo> vehiculos = new HashSet<>();

	/*
	 * Constructor usado por el mapper
	 */
	Cliente() {
	}

	/**
	 * Constructor de cliente
	 * @param dni del cliente
	 */
	public Cliente(String dni) {
		this.dni = dni;
	}

	/**
	 * Constructor del cliente
	 * @param dni del cliente
	 * @param nombre del cliente
	 * @param apellidos del cliente
	 */
	public Cliente(String dni, String nombre, String apellidos) {
		this(dni);
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	/**
	 * Getter de ID
	 * @return la id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Getter de dni
	 * @return la dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Setter de dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Getter de nombre
	 * @return la nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter de nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Getter de apellido
	 * @return la apellido
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Setter de apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Getter de email
	 * @return la email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Setter de email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter del telefono
	 * @return la telefono
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Setter de telefono
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Getter de la fecha
	 * @return la fecha
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Setter de direccion
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Getter usado en la asociaciones
	 * @return la id
	 */
	Set<Vehiculo> _getVehiculo() {
		return vehiculos;
	}

	/**
	 * Getter de vehiculos
	 * @return set de vehiculo
	 */
	public Set<Vehiculo> getVehiculos() {
		return new HashSet<Vehiculo>(vehiculos);
	}

	/**
	 * Getter de medio de pago
	 * @return set de medio de pago
	 */
	public Set<MedioPago> getMediosPago() {
		return new HashSet<>(mediosPago);
	}

	/**
	 * Getter de medio de pago
	 * @return set de medio de pago
	 */
	Set<MedioPago> _getMedioPago() {
		return mediosPago;
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
		Cliente other = (Cliente) obj;
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
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", email=" + email + ", phone=" + phone
				+ ", address=" + address + ", mediosPago=" + mediosPago
				+ ", vehiculos=" + vehiculos + "]";
	}

}
