
public interface PayableEntity {
	double amountOwed();
}

abstract class Employee implements PayableEntity {
	private static int numEmployees = 0;
	private String name;
	private double bonus;

	public Employee(String name) {
		this.name = name;
		numEmployees++;
	}

	public abstract double calcPrebonusPay();

	public abstract String getJobCode();

	public static int getNumEmployees() {
		return numEmployees;
	}

	public double calcTotalPay() {
		return calcPrebonusPay() + bonus;
	}

	
	public double amountOwed() {
		return calcTotalPay();
	}

	public String getName() {
		return name;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	
	public String toString() {
		return String.format("%-15s %-4s $%8.2f $%8.2f", name, getJobCode(), calcPrebonusPay(), calcTotalPay());
	}
}

class HourlyEmployee extends Employee {
	private double hourlyWage;
	private double hoursWorked;

	public HourlyEmployee(String name, double hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}

	
	public double calcPrebonusPay() {
		if (hoursWorked <= 40) {
			return hourlyWage * hoursWorked;
		} else {
			return (hourlyWage * 40) + (1.5 * hourlyWage * (hoursWorked - 40));
		}
	}

	
	public String getJobCode() {
		return "HRLY";
	}

	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
}

class SalariedEmployee extends Employee {
	private double weeklyPay;

	public SalariedEmployee(String name, double weeklyPay) {
		super(name);
		this.weeklyPay = weeklyPay;
	}

	
	public double calcPrebonusPay() {
		return weeklyPay;
	}

	
	public String getJobCode() {
		return "SLRY";
	}
}

class CommissionEmployee extends Employee {
	private double commissionRate;
	private double salesAmount;

	public CommissionEmployee(String name, double commissionRate) {
		super(name);
		this.commissionRate = commissionRate;
	}
	
	public void setSales(double salesAmount) {
		this.salesAmount = salesAmount;
	}

	
	public double calcPrebonusPay() {
		return commissionRate * salesAmount;
	}

	
	public String getJobCode() {
		return "COMM";
	}

	public void setSalesAmount(double salesAmount) {
		this.salesAmount = salesAmount;
	}
}

class LimitedCommissionEmployee extends CommissionEmployee {
    private double basePay;

    public LimitedCommissionEmployee(String name, double commissionRate, double basePay) {
        super(name, commissionRate);
        this.basePay = basePay;
    }

    public double calcPrebonusPay() {
        double preBonusPay = super.calcPrebonusPay();
        return Math.max(basePay, Math.min(preBonusPay, 2 * basePay));
    }
}

class Utility implements PayableEntity {
	private String name;
	private double usage;
	private double rate;
	private double baseFee;

	public Utility(String name, double rate, double baseFee) {
		this.name = name;
		this.rate = rate;
		this.baseFee = baseFee;
	}

	public void setUsage(double usage) {
		this.usage = usage;
	}

	
	public double amountOwed() {
		return baseFee + (rate * usage);
	}

	
	public String toString() {
		return String.format("%-20s $%10.2f", name, amountOwed());
	}
}

class Company {
	private String name;
	private Employee[] employees;
	private Utility[] utilities;
	private int employeeIndex;
	private int utilityIndex;

	public Company(String name, int maxEmployees, int maxUtilities) {
		this.name = name;
		this.employees = new Employee[maxEmployees];
		this.utilities = new Utility[maxUtilities];
	}

	public String getName() {
		return name;
	}

	public void addEmployee(Employee employee) {
		if (employeeIndex < employees.length) {
			employees[employeeIndex++] = employee;
		}
	}

	public void addUtility(Utility utility) {
		if (utilityIndex < utilities.length) {
			utilities[utilityIndex++] = utility;
		}
	}

	public String createPayrollListing() {
		StringBuilder payrollListing = new StringBuilder();
		payrollListing.append(name).append(" Payroll\n");
		payrollListing.append(String.format("%-15s %-4s %-8s %-8s\n", "Name", "Code", "Pay", "Total Pay"));

		for (Employee employee : employees) {
			if (employee != null) {
				payrollListing.append(employee.toString()).append("\n");
			}
		}

		return payrollListing.toString();
	}

	public String createUtilityListing() {
		StringBuilder utilityListing = new StringBuilder();
		utilityListing.append(name).append(" Utilities\n");
		utilityListing.append(String.format("%-20s %-10s\n", "Name", "Bill Amount"));

		for (Utility utility : utilities) {
			if (utility != null) {
				utilityListing.append(utility.toString()).append("\n");
			}
		}

		return utilityListing.toString();
	}

	private double calcExpenditures(PayableEntity[] entities) {
		double totalExpenditure = 0.0;
		for (PayableEntity entity : entities) {
			if (entity != null) {
				totalExpenditure += entity.amountOwed();
			}
		}
		return totalExpenditure;
	}

	public double calcTotalExpenditures() {
		return calcExpenditures(employees) + calcExpenditures(utilities);
	}

	public static void main(String[] args) {
		Company company = new Company("XYZ Corp", 5, 3);

		Employee hourlyEmployee = new HourlyEmployee("John Doe", 15.0);
		((HourlyEmployee) hourlyEmployee).setHoursWorked(40.0);
		hourlyEmployee.setBonus(100.0);

		Employee salariedEmployee = new SalariedEmployee("Jane Smith", 1000.0);
		salariedEmployee.setBonus(200.0);

		Employee commissionEmployee = new CommissionEmployee("Bob Johnson", 0.1);
		((CommissionEmployee) commissionEmployee).setSalesAmount(5000.0);

		Employee limitedCommissionEmployee = new LimitedCommissionEmployee("Alice Lee", 0.08, 800.0);
		((LimitedCommissionEmployee) limitedCommissionEmployee).setSalesAmount(6000.0);

		Utility electricity = new Utility("Electricity", 0.05, 50.0);
		electricity.setUsage(1000.0);

		Utility water = new Utility("Water", 0.02, 20.0);
		water.setUsage(500.0);

		company.addEmployee(hourlyEmployee);
		company.addEmployee(salariedEmployee);
		company.addEmployee(commissionEmployee);
		company.addEmployee(limitedCommissionEmployee);

		company.addUtility(electricity);
		company.addUtility(water);

		System.out.println(company.createPayrollListing());
		System.out.println(company.createUtilityListing());

		System.out.println("Total Expenditures: $" + company.calcTotalExpenditures());
	}

}
