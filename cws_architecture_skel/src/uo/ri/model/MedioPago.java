package uo.ri.model;

import java.util.HashSet;
import java.util.Set;

public abstract class MedioPago {

	private Long id;

	protected double acumulado = 0.0;

	protected Cliente cliente;
	private Set<Cargo> cargos = new HashSet<>();

	/**
	 * Actualiza el acumulado de un cargo
	 * @param importe a aumentar
	 */
	public void actualizarAcumulado(double importe) {
		this.acumulado += importe;
	}

	/**
	 * Setter cliente
	 * @param cliente del medio de pago
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * Getter de Id
	 * @return id de medio de pago
	 */
	public Long getId() {
		return id;
	}
	/**
	 * Getter de cliente
	 * @return cliente que paga
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Getter de cargos
	 * @return set de cargos
	 */
	public Set<Cargo> getCargos() {
		return cargos;
	}

	/**
	 * Getter de acumulado
	 * @return acumulado
	 */
	public double getAcumulado() {
		return acumulado;
	}
	
	/**
	 * Getter de cargos usado por la asociacion
	 * @return set de cargos
	 */
	Set<Cargo> _getCargos() {
		return cargos;
	}

	/**
	 * Setter cliente usado por la asociacion
	 * @param cliente del medio de pago
	 */
	void _setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	protected void actualizarImportes(double importe) {
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MedioPago [acumulado=" + acumulado + ", cliente=" + cliente
				+ ", cargos=" + cargos + "]";
	}
}
