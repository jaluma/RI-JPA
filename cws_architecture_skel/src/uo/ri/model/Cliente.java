package uo.ri.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Embedded;

import uo.ri.model.types.Address;

public class Cliente {
	private Long id;

	private String dni;
	private String nombre;
	private String apellidos;
	private String email;
	private String phone;
	@Embedded
	private Address address;

	private Set<MedioPago> mediosPago = new HashSet<>();

	private Set<Vehiculo> vehiculos = new HashSet<>();

	Cliente() {
	}

	public Cliente(String dni) {
		this.dni = dni;
	}

	public Cliente(String dni, String nombre, String apellidos) {
		this(dni);
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public Long getId() {
		return id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	Set<Vehiculo> _getVehiculo() {
		return vehiculos;
	}

	public Set<Vehiculo> getVehiculos() {
		return new HashSet<Vehiculo>(vehiculos);
	}

	public Set<MedioPago> getMediosPago() {
		return new HashSet<>(mediosPago);
	}

	Set<MedioPago> _getMedioPago() {
		return mediosPago;
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
		Cliente other = (Cliente) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", email=" + email + ", phone=" + phone
				+ ", address=" + address + ", mediosPago=" + mediosPago
				+ ", vehiculos=" + vehiculos + "]";
	}

}
