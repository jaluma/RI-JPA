package uo.ri.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import alb.util.date.Dates;
import uo.ri.model.types.ContratoStatus;

public class Contract {

	private Long id;

	private Date startDate;
	private Date endDate;
	private double baseSalaryPerYear;
	private double compensation = 0;
	private ContratoStatus status;

	private ContractCategory contractCategory;
	private ContractType contractType;
	private Mecanico mechanic;

	private Set<Payroll> payrolls = new HashSet<>();

	Contract() {
	}

	public Contract(Mecanico mecanico, Date startDate) {
		this.mechanic = mecanico;
		setStartDate(startDate);
		status = ContratoStatus.ACTIVE;
		Association.Hire.link(this, mecanico);
	}
	
	public Contract(Mecanico mechanic, Date date, double baseSalary) {
		this(mechanic, date);
		checkSalary(baseSalary);
		this.baseSalaryPerYear = baseSalary;
	}

	public Contract(Mecanico mechanic, Date startDate, Date endDate, double baseSalary) {
		this(mechanic, startDate, baseSalary);
		setEndDate(endDate);
	}

	public Contract(Mecanico m, Date startDate, Date endDate, double yearBaseSalary, double compensation,
			ContratoStatus status, ContractCategory c, ContractType t) {
		this(m, startDate, endDate, yearBaseSalary);
		this.compensation = compensation;
		this.status = status;
		this.contractCategory = c;
		this.contractType = t;
		Association.Typefy.link(this, contractType);
		Association.Categorize.link(this, contractCategory);
	}

	private void checkSalary(double baseSalary) {
		if (baseSalary < 0) {
			throw new IllegalArgumentException("El salario base no puede ser negativo");
		}
	}

	public Long getId() {
		return id;
	}

	public Date getStartDate() {
		return new Date(startDate.getTime());
	}

	public Date getEndDate() {
		return new Date(endDate.getTime());
	}

	public double getBaseSalaryPerYear() {
		return baseSalaryPerYear;
	}

	public double getCompensation() {
		setCompensation();
		return compensation;
	}

	public ContratoStatus getStatus() {
		return status;
	}

	public ContractCategory getContractCategory() {
		return contractCategory;
	}

	public ContractType getContractType() {
		return contractType;
	}

	public Mecanico getMechanic() {
		return mechanic;
	}

	public Set<Payroll> getPayrolls() {
		return new HashSet<>(payrolls);
	}

	public void setBaseSalaryPerYear(double baseSalaryPerYear) {
		this.baseSalaryPerYear = baseSalaryPerYear;
	}

	public void setCompensation(double compensation) {
		this.compensation = compensation;
	}

	void _setContractCategory(ContractCategory category) {
		contractCategory = category;
	}

	void _setContractType(ContractType type) {
		contractType = type;
	}

	void _setMechanic(Mecanico mechanic) {
		this.mechanic = mechanic;
	}

	public void setEndDate(Date endDate) {
		if (endDate != null)
			this.endDate = Dates.lastDayOfMonth(endDate);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((mechanic == null) ? 0 : mechanic.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
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
		Contract other = (Contract) obj;
		if (mechanic == null) {
			if (other.mechanic != null)
				return false;
		} else if (!mechanic.equals(other.mechanic))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}

	private void setStartDate(Date startDate) {
		if (startDate != null)
			this.startDate = Dates.firstDayOfMonth(startDate);
	}

	public boolean isFinished() {
		return status == ContratoStatus.FINISHED;
	}

	public double getIrpfPercent() {
		if (baseSalaryPerYear < 12000) {
			return 0;
		} else if (baseSalaryPerYear < 30000) {
			return 0.1;
		} else if (baseSalaryPerYear < 40000) {
			return 0.15;
		} else if (baseSalaryPerYear < 50000) {
			return 0.2;
		} else if (baseSalaryPerYear < 60000) {
			return 0.3;
		} else {
			return 0.4;
		}
	}

	public Payroll getLastPayroll() {
		if (payrolls.size() == 0) {
			return null;
		}

		return payrolls.stream().sorted((o1, o2) -> o2.getDate().compareTo(o1.getDate())).findFirst().get();
	}

	public void markAsFinished(Date endDate) {
		if (status != null && status.equals(ContratoStatus.FINISHED)) {
			throw new IllegalStateException("El contrato ya esta finalizado.");
		}

		if (Dates.isAfter(startDate, endDate)) {
			throw new IllegalArgumentException("La fecha debe de ser posterior al inicio del contrato");
		}

		setEndDate(endDate);
		this.status = ContratoStatus.FINISHED;

	}

	Set<Payroll> _getPayrolls() {
		return payrolls;
	}

	private void setCompensation() {
		int days = Dates.diffDays(endDate, startDate);
		if (days >= 364) {
			this.compensation = contractType.getCompensationDays() * baseSalaryPerYear / 365;
		}
	}

	@Override
	public String toString() {
		return "Contract [startDate=" + startDate + ", endDate=" + endDate
				+ ", baseSalaryPerYear=" + baseSalaryPerYear + ", compensation="
				+ compensation + ", status=" + status + ", contractCategory="
				+ contractCategory + ", contractType=" + contractType
				+ ", mechanic=" + mechanic + ", payrolls=" + payrolls + "]";
	}
	
	

}
