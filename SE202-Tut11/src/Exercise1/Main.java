package Exercise1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name:");
		String name = scanner.nextLine();
		System.out.println("Enter age:");
		int age = Integer.valueOf(scanner.nextLine());
		try {
			Person child = new Child(name, age);
			System.out.println(child.toString());
			String personClassName = Person.class.getSimpleName();
			String childClassName = Child.class.getSimpleName();
		} catch (IllegalArgumentException error) {
			System.out.println(error.getMessage());
		}
	}
}
