package Exercise3;

public class Worker extends Human{
	
	private double weekSalary;
	private double hoursPerDay;
	
	public Worker(String firstName, String lastName, double weekSalary, double hoursPerDay) {
		super(firstName, lastName);
		this.setWeekSalary(weekSalary);
		this.setHoursPerDay(hoursPerDay);
	}

	@Override
	protected void setLastName(String lastName) {
		if (lastName.length() < 3) {
			throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
		}	
		super.setLastName(lastName);
	}
	
	public double getWeekSalary() {
		return weekSalary;
	}

	protected void setWeekSalary(double weekSalary) {
		if (weekSalary < 10) {
			throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
		}
		this.weekSalary = weekSalary;
	}

	public double getHoursPerDay() {
		return hoursPerDay;
	}

	protected void setHoursPerDay(double hoursPerDay) {
		if (hoursPerDay < 1 || hoursPerDay > 12) {
			throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
		}
		this.hoursPerDay = hoursPerDay;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		double salaryPerHr = this.getWeekSalary() / (this.getHoursPerDay() * 7);
		sb.append(String.format("First Name: %s\r\n" + 
								"Last Name: %s\r\n" + 
								"Week Salary: %.2f\r\n" + 
								"Hours per day: %.2f\r\n" + 
								"Salary per hour: %.2f", 
								this.getFirstName(), this.getLastName(), this.getWeekSalary(), this.getHoursPerDay(), salaryPerHr));
		return sb.toString();
	}
}
