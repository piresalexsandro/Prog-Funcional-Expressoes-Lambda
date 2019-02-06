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

import entities.Product;

public class ProgramExResolvido {

	public static void main(String[] args) throws IOException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter full file path: C:\\Temp\\avgProduct.txt");
		//String path = sc.next();
		String path = "C:\\Temp\\avgProduct.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			List<Product> products = new ArrayList<>();

			String line = br.readLine();
			
			while(line != null) {
				String[] fields = line.split(",");
				products.add(new Product(fields[0], Double.parseDouble(fields[1])));
				
				line = br.readLine();
			}
			
			//o aquivo ja voi lido por inteiro
			// pipeline
			double avg = products.stream()
					.map(p -> p.getPrice()) //stream com preco do produtos
					.reduce(0.0, (x,y) -> x + y) / products.size();
			
			System.out.println();
			System.out.println("Average price: " + String.format("%.2f", avg));
			
			Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
			
			// preco abaixo da media em ordem decrescente
			// C:\Temp\avgProduct.txt
			List<String> names = products.stream()
					.filter(p -> p.getPrice() < avg)
					.map(p -> p.getName())
					.sorted(comp.reversed())
					.collect(Collectors.toList());
			
			names.forEach(System.out::println);
			
					
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}

}
