package application;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import entities.Product;

public class ProgramRemoveIf {
	
	

	public static void main(String[] args) {

		List<Product> products = new ArrayList<>();
		
		products.add(new Product("TV", 900.00));
		products.add(new Product("Mouse", 50.00));
		products.add(new Product("Tablet", 350.50));
		products.add(new Product("Hd Case", 89.90));
		
		double min = 100.0; // posso obter via teclado
		
		// variavel do tipo product
		products.removeIf(p -> p.getPrice() >= min); 
		
		for (Product p : products) {
			System.out.println(p);
		}
	}

}
