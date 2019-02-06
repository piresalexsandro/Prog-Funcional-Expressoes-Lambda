package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class ProgramExercicio {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter full file path: c:\\Temp\\nomeEmailSalario.txt");
		//String path = sc.next();
		String path = "c:\\Temp\\nomeEmailSalario.txt";
		
		System.out.print("Enter salary: ");
		double salary = sc.nextDouble();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			List<Employee> func = new ArrayList<>();
			
			String line = br.readLine();
			
			while(line != null) {
				String[] fields = line.split(",");
				func.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = br.readLine();
			}
			
			//func.removeIf(p -> p.getSalary() < salary).
			
			Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
			
			List<String> emails = func.stream()
					.filter(p -> p.getSalary() > salary)
					.map(p -> p.getEmail())
					.sorted(comp)
					.collect(Collectors.toList());
			
			System.out.println();
			System.out.println("Email of people whose salary is more than " + String.format("%.2f", salary));
			
			emails.forEach(System.out::println);
			
			double sum = func.stream()
					.filter(p -> p.getName().charAt(0) == 'M')
					.map(p -> p.getSalary()) //stream com preco do produtos
					.reduce(0.0, (x,y) -> x + y);
			
			System.out.println();
			System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sum));
			
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}

}
