package uo.ri.model;

import java.util.Date;

public class TarjetaCredito extends MedioPago {

	protected String numero;
	protected String tipo;
	protected Date validez;

	/*
	 * Constructor usado por el mapper
	 */
	TarjetaCredito() {
	}

	/**
	 * Constrcutor de tarjetas de credito
	 * @param numero de la tarjeta
	 */
	public TarjetaCredito(String numero) {
		this.numero = numero;
	}

	/**
	 * Constrcutor de tarjetas de credito
	 * @param numero de la tarjeta
	 * @param tipo de la tarjeta
	 * @param validez de la tarjeta
	 */
	public TarjetaCredito(String numero, String tipo, Date validez) {
		this(numero);
		this.tipo = tipo;
		this.validez = new Date(validez.getTime());
	}

	/**
	 * Getter de numero de tarjeta de credito
	 * @return el numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Getter del tipo
	 * @return el tipo de la tarjeta
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Getter de la validez
	 * @return fecha de caducidad de la tarjeta
	 */
	public Date getValidez() {
		return new Date(validez.getTime());
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		TarjetaCredito other = (TarjetaCredito) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see uo.ri.model.MedioPago#toString()
	 */
	@Override
	public String toString() {
		return "TarjetaCredito [numero=" + numero + ", tipo=" + tipo
				+ ", validez=" + validez + "]";
	}

}
