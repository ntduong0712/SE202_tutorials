package Exercise3;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("STUDENT \nEnter first name: ");
			String studentFirstName = scanner.nextLine();
			System.out.println("Enter last name: ");
			String studentLastName = scanner.nextLine();
			System.out.println("Enter faculty: ");
			String faculty = scanner.nextLine();
			System.out.println("WORKER \nEnter first name: ");
			String workerFirstName = scanner.nextLine();
			System.out.println("Enter last name: ");
			String workerLastName = scanner.nextLine();
			System.out.println("Enter week salary: ");
			double weekSalary = Double.valueOf(scanner.nextLine());
			System.out.println("Enter hour per day: ");
			double hourPerDay = Double.valueOf(scanner.nextLine());
			
			Student student = new Student(studentFirstName, studentLastName, faculty); 
			Worker worker = new Worker(workerFirstName, workerLastName, weekSalary, hourPerDay);
			Method[] studentDeclaredMethods = Student.class.getDeclaredMethods();
			Method[] workerDeclaredMethods = Worker.class.getDeclaredMethods();
			System.out.println(student.toString());
			System.out.println(worker.toString());
		} catch (IllegalArgumentException error) {
			System.out.println(error.getMessage());
		}
	}
}
