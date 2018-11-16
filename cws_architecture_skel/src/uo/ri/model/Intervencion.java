package uo.ri.model;

import java.util.HashSet;
import java.util.Set;

public class Intervencion {

	private Long id;

	private Averia averia;
	private Mecanico mecanico;
	private int minutos;

	private Set<Sustitucion> sustituciones = new HashSet<>();

	/*
	 * Constructor usado por el mapper
	 */
	Intervencion() {
	}

	/**
	 * Constructor de intervencion
	 * @param mecanico de la intervencion
	 * @param averia que se trata
	 */
	public Intervencion(Mecanico mecanico, Averia averia) {
		Association.Intervenir.link(mecanico, averia, this);
	}

	/**
	 * Getter de sustituciones
	 * @return set de sustituciones
	 */
	public Set<Sustitucion> getSustituciones() {
		return new HashSet<>(sustituciones);
	}

	/**
	 * Getter de averai
	 * @return averia de la intervencion
	 */
	public Averia getAveria() {
		return averia;
	}

	/**
	 * Getter de mecanico
	 * @return mecanico que la trata
	 */
	public Mecanico getMecanico() {
		return mecanico;
	}

	/**
	 * Getter de minutos
	 * @return minutos usados
	 */
	public int getMinutos() {
		return minutos;
	}

	/**
	 * Getter de Id
	 * @return id de la intervencion
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Setter minutos
	 * @param minutos usados
	 */
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}
	
	/**
	 * Setter sustituciones usado por la asociacion
	 * @param set de sustituciones
	 */
	Set<Sustitucion> _getSustituciones() {
		return sustituciones;
	}
	
	/**
	 * Setter de mecanico usado por la asociacion
	 * @param mecanico encargado
	 */
	void _setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	/**
	 * Setter de averia usado por la asociacion
	 * @param averia tratada
	 */
	void _setAveria(Averia averia) {
		this.averia = averia;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((averia == null) ? 0 : averia.hashCode());
		result = prime * result
				+ ((mecanico == null) ? 0 : mecanico.hashCode());
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

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Intervencion [averia=" + averia + ", mecanico=" + mecanico
				+ ", minutos=" + minutos + ", sustituciones=" + sustituciones
				+ "]";
	}

	/**
	 * Calcula el importe de la intervencion
	 * @return importe
	 */
	public double getImporte() {
		return getImporteManoDeObra() + getImporteRepuestos();
	}

	/**
	 * Calcula el importe de la mano de obra
	 * @return importe
	 */
	private double getImporteManoDeObra() {
		return minutos / 60.0 * averia.getVehiculo().getTipo().getPrecioHora();
	}

	/**
	 * Calcula el importe de los repuestos
	 * @return importe
	 */
	private double getImporteRepuestos() {
		double importe = 0.0;
		for (Sustitucion sustitucion : sustituciones) {
			importe += sustitucion.getImporte();
		}
		return importe;
	}

}
