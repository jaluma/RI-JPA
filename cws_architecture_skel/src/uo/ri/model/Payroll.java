package uo.ri.model;

import java.time.Month;
import java.util.Date;

import alb.util.date.Dates;

public class Payroll {

	private Long id;

	private Date date;
	private double baseSalary;
	private double extraSalary;
	private double productivity;
	private double triennium;
	private double irpf;
	private double socialSecurity;

	private double grossTotal;
	private double discountTotal;
	private double netTotal;

	private Contract contract;

	/*
	 * Constructor usado por el mapper
	 */
	Payroll() {
	}

	/**
	 * Constructor de nominas
	 * @param contract del mecanico
	 * @param date de la nomina
	 * @param totalOfInterventions en en el periodo
	 */
	public Payroll(Contract contract, Date date, double totalOfInterventions) {
		this.contract = contract;
		setDate(date);
		setProductivity(totalOfInterventions);
		Association.Payrolls.link(contract, this);
		setBaseSalary();
		setExtraSalary();
		setTrienium();
		setSocialSecurity();
		setGrossTotal();
		setIrpf();
		setDiscountTotal();
		setNetTotal();
	}

	/**
	 * Getter de Id
	 * @return id de la nomina
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Getter de Id
	 * @return id de la nomina
	 */
	public Date getDate() {
		return new Date(date.getTime());
	}

	/**
	 * Getter de salario base
	 * @return salario base de la nomina
	 */
	public double getBaseSalary() {
		return baseSalary;
	}

	/**
	 * Getter de salario extra
	 * @return salario extra de la nomina
	 */
	public double getExtraSalary() {
		return extraSalary;
	}

	/**
	 * Getter de productividad
	 * @return productividad de la nomina
	 */
	public double getProductivity() {
		return productivity;
	}

	/**
	 * Getter de trienio
	 * @return trienio de la nomina
	 */
	public double getTriennium() {
		return triennium;
	}

	/**
	 * Getter de irpf
	 * @return irpf de la nomina
	 */
	public double getIrpf() {
		return irpf;
	}

	/**
	 * Getter de seguridad social
	 * @return seguridad social de la nomina
	 */
	public double getSocialSecurity() {
		return socialSecurity;
	}

	/**
	 * Getter de bruto
	 * @return bruto de la nomina
	 */
	public double getGrossTotal() {
		return grossTotal;
	}

	/**
	 * Getter de descuento
	 * @return descuento de la nomina
	 */
	public double getDiscountTotal() {
		return discountTotal;
	}

	/**
	 * Getter de neto
	 * @return neto de la nomina
	 */
	public double getNetTotal() {
		return netTotal;
	}

	/**
	 * Getter de contrato
	 * @return contrato de la nomina
	 */
	public Contract getContract() {
		return contract;
	}

	/**
	 * Setter contrato usado por la asociacion
	 * @param contract a asignar
	 */
	void _setContract(Contract contract) {
		this.contract = contract;
	}
	
	/**
	 * Setter de fecha
	 * @param date fecha
	 */
	private void setDate(Date date) {
		if (!Dates.isBefore(contract.getStartDate(), date)) {
			throw new IllegalArgumentException("La fecha debe ser posterior a la del inicio de contrato");
		}
		this.date = Dates.trunc(Dates.lastDayOfMonth(Dates.subMonths(date, 1)));
	}

	/**
	 * Setter del neto
	 */
	private void setNetTotal() {
		this.netTotal = getGrossTotal() - getDiscountTotal();
	}

	/**
	 * Setter del descuento
	 */
	private void setDiscountTotal() {
		this.discountTotal = getIrpf() + getSocialSecurity();
	}

	/**
	 * Setter del bruto
	 */
	private void setGrossTotal() {
		this.grossTotal = getBaseSalary() + getExtraSalary() + getProductivity() + getTriennium();
	}

	/**
	 * Setter del trienio
	 */
	private void setTrienium() {
		long yearsOld = Dates.diffDays(date, contract.getStartDate()) / 365;
		this.triennium = yearsOld / 3 * contract.getContractCategory().getTrieniumSalary();
	}

	/**
	 * Setter del irpf
	 */
	private void setIrpf() {
		this.irpf = contract.getIrpfPercent() * getGrossTotal();
	}

	/**
	 * Setter del seguridad social
	 */
	private void setSocialSecurity() {
		this.socialSecurity = contract.getBaseSalaryPerYear() / 12 * 0.05;
	}

	/**
	 * Setter del productividad
	 */
	private void setProductivity(double totalOfInterventions) {
		this.productivity = contract.getContractCategory().getProductivityPlus() * totalOfInterventions;
	}

	/**
	 * Setter del salario extra
	 */
	private void setExtraSalary() {
		int june = Month.JUNE.getValue();
		int december = Month.DECEMBER.getValue();
		if (Dates.month(date).equals(june) || Dates.month(date).equals(december)) {
			this.extraSalary = getBaseSalary();
		}
	}

	/**
	 * Setter del salario base
	 */
	private void setBaseSalary() {
		this.baseSalary = contract.getBaseSalaryPerYear() / 14;
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
				+ ((contract == null) ? 0 : contract.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
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
		Payroll other = (Payroll) obj;
		if (contract == null) {
			if (other.contract != null)
				return false;
		} else if (!contract.equals(other.contract))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Payroll [date=" + date + ", baseSalary=" + baseSalary
				+ ", extraSalary=" + extraSalary + ", productivity="
				+ productivity + ", triennium=" + triennium + ", irpf=" + irpf
				+ ", socialSecurity=" + socialSecurity + ", grossTotal="
				+ grossTotal + ", discountTotal=" + discountTotal
				+ ", netTotal=" + netTotal + ", contract=" + contract + "]";
	}
}
