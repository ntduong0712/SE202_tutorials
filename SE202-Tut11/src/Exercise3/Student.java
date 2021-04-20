package Exercise3;

public class Student extends Human {
	
	private String falcutyNo;
	
	public Student(String firstName, String lastName, String falcutyNo) {
		super(firstName, lastName);
		this.setFalcutyNo(falcutyNo);
	}
	
	public String getFalcutyNo() {
		return falcutyNo;
	}
	
	protected void setFalcutyNo(String falcutyNo) {
		if (falcutyNo.length() <5 || falcutyNo.length() > 10) {
			throw new IllegalArgumentException("Invalid faculty number!");
		}
		this.falcutyNo = falcutyNo;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append(String.format("First Name: %s\r\n" + 
								"Last Name: %s\r\n" + 
								"Faculty number: %s", 
								this.getFirstName(), this.getLastName(), this.getFalcutyNo()));
		return sb.toString();
	}
}
