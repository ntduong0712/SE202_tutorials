package Exercise1;

public class Person {
	// 1. Add the Fields
	private String name;
	private int age;
	// 2. Add the Constructor
	public Person(String name, int age) {
		this.setName(name);
		this.setAge(age);
	}
	// 3. Add the Properties
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	// 4. Add the Methods
	protected void setAge(int age) throws IllegalArgumentException {
		if (age < 1) {
			throw new IllegalArgumentException("Age must be positive!");
		}
		this.setAge(age);
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append(String.format("Name: %s, Age: %d", this.getName(), this.getAge()));
		return sb.toString();
	}
}
