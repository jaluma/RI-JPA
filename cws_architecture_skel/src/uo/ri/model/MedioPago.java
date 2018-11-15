package uo.ri.model;

import java.util.HashSet;
import java.util.Set;

public abstract class MedioPago {

	private Long id;

	protected double acumulado = 0.0;

	protected Cliente cliente;
	private Set<Cargo> cargos = new HashSet<>();

	public void actualizarAcumulado(double importe) {
		this.acumulado += importe;
	}

	void _setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "MedioPago [acumulado=" + acumulado + ", cliente=" + cliente
				+ ", cargos=" + cargos + "]";
	}

	Set<Cargo> _getCargos() {
		return cargos;
	}

	public Set<Cargo> getCargos() {
		return cargos;
	}

	public double getAcumulado() {
		return acumulado;
	}

	protected void actualizarImportes(double importe) {
	}
}
