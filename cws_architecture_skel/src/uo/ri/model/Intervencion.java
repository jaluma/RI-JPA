package uo.ri.model;

import java.util.HashSet;
import java.util.Set;

public class Intervencion {

	private Long id;

	private Averia averia;
	private Mecanico mecanico;
	private int minutos;

	private Set<Sustitucion> sustituciones = new HashSet<>();

	Intervencion() {
	}

	public Intervencion(Mecanico mecanico, Averia averia) {
		Association.Intervenir.link(mecanico, averia, this);
	}

	Set<Sustitucion> _getSustituciones() {
		return sustituciones;
	}

	public Set<Sustitucion> getSustituciones() {
		return new HashSet<>(sustituciones);
	}

	public Averia getAveria() {
		return averia;
	}

	public Mecanico getMecanico() {
		return mecanico;
	}

	public int getMinutos() {
		return minutos;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((averia == null) ? 0 : averia.hashCode());
		result = prime * result
				+ ((mecanico == null) ? 0 : mecanico.hashCode());
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
		Intervencion other = (Intervencion) obj;
		if (averia == null) {
			if (other.averia != null)
				return false;
		} else if (!averia.equals(other.averia))
			return false;
		if (mecanico == null) {
			if (other.mecanico != null)
				return false;
		} else if (!mecanico.equals(other.mecanico))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Intervencion [averia=" + averia + ", mecanico=" + mecanico
				+ ", minutos=" + minutos + ", sustituciones=" + sustituciones
				+ "]";
	}

	void _setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	void _setAveria(Averia averia) {
		this.averia = averia;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public double getImporte() {
		return getImporteManoDeObra() + getImporteRepuestos();
	}

	private double getImporteManoDeObra() {
		return minutos / 60.0 * averia.getVehiculo().getTipo().getPrecioHora();
	}

	private double getImporteRepuestos() {
		double importe = 0.0;
		for (Sustitucion sustitucion : sustituciones) {
			importe += sustitucion.getImporte();
		}
		return importe;
	}

}
