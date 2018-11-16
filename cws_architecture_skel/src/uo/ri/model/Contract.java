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

	/*
	 * Constructor usado por el mapper
	 */
	Contract() {
	}

	/**
	 * Constructor de contrato
	 * @param mecanico del contrato
	 * @param startDate del contrato
	 */
	public Contract(Mecanico mecanico, Date startDate) {
		this.mechanic = mecanico;
		setStartDate(startDate);
		status = ContratoStatus.ACTIVE;
		Association.Hire.link(this, mecanico);
	}

	/**
	 * Constructor de contrato
	 * @param mecanico del contrato
	 * @param startDate del contrato
	 * @param baseSalary del contrato
	 */
	public Contract(Mecanico mechanic, Date startDate, double baseSalary) {
		this(mechanic, startDate);
		setBaseSalaryPerYear(baseSalary);
	}

	/**
	 * Constructor de contrato
	 * @param mecanico del contrato
	 * @param startDate del contrato
	 * @param endDate del contrato
	 * @param baseSalary del contrato
	 */
	public Contract(Mecanico mechanic, Date startDate, Date endDate,
			double baseSalary) {
		this(mechanic, startDate, baseSalary);
		setEndDate(endDate);
	}

	/**
	 * Constructor de contrato
	 * @param mecanico del contrato
	 * @param startDate del contrato
	 * @param endDate del contrato
	 * @param yearBaseSalary del contrato
	 * @param compensation del contrato
	 * @param status del contrato
	 * @param c categoria del contrato
	 * @param t tipo del contrato
	 */
	public Contract(Mecanico m, Date startDate, Date endDate,
			double yearBaseSalary, double compensation, ContratoStatus status,
			ContractCategory c, ContractType t) {
		this(m, startDate, endDate, yearBaseSalary);
		this.compensation = compensation;
		this.status = status;
		this.contractCategory = c;
		this.contractType = t;
		Association.Typefy.link(this, contractType);
		Association.Categorize.link(this, contractCategory);
	}

	/**
	 * Getter de id
	 * @return id del contrato
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Getter de fecha inicio
	 * @return fecha inicio del contrato
	 */
	public Date getStartDate() {
		return new Date(startDate.getTime());
	}

	/**
	 * Getter de fecha fin
	 * @return fecha fin del contrato
	 */
	public Date getEndDate() {
		return new Date(endDate.getTime());
	}

	/**
	 * Getter de salario base por año
	 * @return salario base por año del contrato
	 */
	public double getBaseSalaryPerYear() {
		return baseSalaryPerYear;
	}

	/**
	 * Getter de compensacion
	 * @return compensacion del contrato
	 */
	public double getCompensation() {
		setCompensation();
		return compensation;
	}

	/**
	 * Getter de estado
	 * @return estado del contrato
	 */
	public ContratoStatus getStatus() {
		return status;
	}

	/**
	 * Getter de categoria de contrato
	 * @return categoria de contrato del contrato
	 */
	public ContractCategory getContractCategory() {
		return contractCategory;
	}

	/**
	 * Getter de tipo de contrato
	 * @return tipo de contrato del contrato
	 */
	public ContractType getContractType() {
		return contractType;
	}

	/**
	 * Getter de mecanico
	 * @return mecanico del contrato
	 */
	public Mecanico getMechanic() {
		return mechanic;
	}

	/**
	 * Getter de nominas
	 * @return nominas del contrato
	 */
	public Set<Payroll> getPayrolls() {
		return new HashSet<>(payrolls);
	}

	/**
	 * Setter de compensacion
	 */
	private void setCompensation() {
		int days = Dates.diffDays(endDate, startDate);
		if (days >= 364) {
			this.compensation = contractType.getCompensationDays()
					* baseSalaryPerYear / 365;
		}
	}

	/**
	 * Setter de salario base anual
	 * @param baseSalaryPerYear a asignar
	 */
	public void setBaseSalaryPerYear(double baseSalaryPerYear) {
		checkSalary(baseSalaryPerYear);
		this.baseSalaryPerYear = baseSalaryPerYear;
	}
	
	/**
	 * Comprueba que el salario no sea negativo
	 * @param baseSalary a comprobar
	 */
	private void checkSalary(double baseSalary) {
		if (baseSalary < 0) {
			throw new IllegalArgumentException(
					"El salario base no puede ser negativo");
		}
	}

	/**
	 * Setter de compensacion
	 * @param compensacion a asignar
	 */
	public void setCompensation(double compensation) {
		this.compensation = compensation;
	}

	/**
	 * Setter de fecha de incio
	 * @param fecha de incio a asignar
	 */
	private void setStartDate(Date startDate) {
		if (startDate != null)
			this.startDate = Dates.firstDayOfMonth(startDate);
	}

	/**
	 * Setter de fecha de fin
	 * @param fecha de fin a asignar
	 */
	public void setEndDate(Date endDate) {
		if (endDate != null)
			this.endDate = Dates.lastDayOfMonth(endDate);
	}

	/**
	 * Getter de nominas
	 * @return set de nominas
	 */
	Set<Payroll> _getPayrolls() {
		return payrolls;
	}

	/**
	 * Setter de mecanico usado por asociacion
	 * @param mecanico a asignar
	 */
	void _setMechanic(Mecanico mechanic) {
		this.mechanic = mechanic;
	}

	/**
	 * Setter de categoria de contratos usado por asociacion
	 * @param categoria de contratos a asignar
	 */
	void _setContractCategory(ContractCategory category) {
		contractCategory = category;
	}

	/**
	 * Setter de tipo de contratos usado por asociacion
	 * @param tipo de contratos a asignar
	 */
	void _setContractType(ContractType type) {
		contractType = type;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
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

	/*
	 * (non-Javadoc)
	 * 
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Contract [startDate=" + startDate + ", endDate=" + endDate
				+ ", baseSalaryPerYear=" + baseSalaryPerYear + ", compensation="
				+ compensation + ", status=" + status + ", contractCategory="
				+ contractCategory + ", contractType=" + contractType
				+ ", mechanic=" + mechanic + ", payrolls=" + payrolls + "]";
	}

	/**
	 * Devuelve si un contrato es finalizado
	 * 
	 * @return true si esta finalizado, false en otro caso
	 */
	public boolean isFinished() {
		return status == ContratoStatus.FINISHED;
	}

	/**
	 * Devuelve el valor de irpf
	 * 
	 * @return el valor porcentual del irpf
	 */
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

	/**
	 * Devuelve la ultima nomina
	 * @return la ultima factura o null si no hay
	 */
	public Payroll getLastPayroll() {
		if (payrolls.size() == 0) {
			return null;
		}

		return payrolls.stream()
				.sorted((o1, o2) -> o2.getDate().compareTo(o1.getDate()))
				.findFirst().get();
	}

	/**
	 * Marca como finalizado el contrato
	 * @param endDate fecha de fin de contratos
	 */
	public void markAsFinished(Date endDate) {
		if (status != null && status.equals(ContratoStatus.FINISHED)) {
			throw new IllegalStateException("El contrato ya esta finalizado.");
		}

		if (Dates.isAfter(startDate, endDate)) {
			throw new IllegalArgumentException(
					"La fecha debe de ser posterior al inicio del contrato");
		}

		setEndDate(endDate);
		this.status = ContratoStatus.FINISHED;

	}

}
