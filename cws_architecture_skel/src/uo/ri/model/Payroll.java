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

	Payroll() {
	}

	public Payroll(Contract contract, Date date, double totalOfInterventions) {
		Association.Payrolls.link(contract, this);
		setDate(date);
		setProductivity(totalOfInterventions);
		setBaseSalary();
		setExtraSalary();
		setTrienium();
		setSocialSecurity();
		setGrossTotal();
		setIrpf();
		setDiscountTotal();
		setNetoTotal();
	}

	private void setDate(Date date) {
		if (!Dates.isBefore(contract.getStartDate(), date)) {
			throw new IllegalArgumentException("La fecha debe ser posterior a la del inicio de contrato");
		}
		this.date = Dates.trunc(Dates.lastDayOfMonth(Dates.subMonths(date, 1)));
	}

	public Long getId() {
		return id;
	}

	public Date getDate() {
		return new Date(date.getTime());
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public double getExtraSalary() {
		return extraSalary;
	}

	public double getProductivity() {
		return productivity;
	}

	public double getTriennium() {
		return triennium;
	}

	public double getIrpf() {
		return irpf;
	}

	public double getSocialSecurity() {
		return socialSecurity;
	}

	public double getGrossTotal() {
		return grossTotal;
	}

	public double getDiscountTotal() {
		return discountTotal;
	}

	public double getNetTotal() {
		return netTotal;
	}

	public Contract getContract() {
		return contract;
	}

	void _setContract(Contract contract) {
		this.contract = contract;
	}

	private void setNetoTotal() {
		this.netTotal = getGrossTotal() - getDiscountTotal();
	}

	private void setDiscountTotal() {
		this.discountTotal = getIrpf() + getSocialSecurity();
	}

	private void setGrossTotal() {
		this.grossTotal = getBaseSalary() + getExtraSalary() + getProductivity() + getTriennium();
	}

	private void setTrienium() {
		long yearsOld = Dates.diffDays(date, contract.getStartDate()) / 365;
		this.triennium = yearsOld / 3 * contract.getContractCategory().getTrieniumSalary();
	}

	private void setIrpf() {
		this.irpf = contract.getIrpfPercent() * getGrossTotal();
	}

	private void setSocialSecurity() {
		this.socialSecurity = contract.getBaseSalaryPerYear() / 12 * 0.05;
	}

	private void setProductivity(double totalOfInterventions) {
		this.productivity = contract.getContractCategory().getProductivityPlus() * totalOfInterventions;
	}

	private void setExtraSalary() {
		int june = Month.JUNE.getValue();
		int december = Month.DECEMBER.getValue();
		if (Dates.month(date).equals(june) || Dates.month(date).equals(december)) {
			this.extraSalary = getBaseSalary();
		}
	}

	private void setBaseSalary() {
		this.baseSalary = contract.getBaseSalaryPerYear() / 14;
	}

	@Override
	public String toString() {
		return "Payroll [date=" + date + ", baseSalary=" + baseSalary
				+ ", extraSalary=" + extraSalary + ", productivity="
				+ productivity + ", triennium=" + triennium + ", irpf=" + irpf
				+ ", socialSecurity=" + socialSecurity + ", grossTotal="
				+ grossTotal + ", discountTotal=" + discountTotal
				+ ", netTotal=" + netTotal + ", contract=" + contract + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((contract == null) ? 0 : contract.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
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
	
	
}
