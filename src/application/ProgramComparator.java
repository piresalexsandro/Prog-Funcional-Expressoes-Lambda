package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import entities.Product;

public class ProgramComparator {

	public static void main(String[] args) {
		
		List<Product> products = new ArrayList<>();
		
		products.add(new Product("TV", 900.00));
		products.add(new Product("Notebook", 1200.00));
		products.add(new Product("Tablet", 450.00));
		
		//funcao anonima
		/*Comparator<Product> comp = (p1, p2) -> {
			return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
		};*/
		
		//Comparator<Product> comp = (p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
		
	
		//implementacao de uma classe anonima
		/*Comparator<Product> comp = new Comparator<Product>() {
			@Override
			public int compare(Product p1, Product p2) {
				return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
			}
		};*/
		
		//Collections.sort(products);
		//products.sort(new MyComparator());
		//products.sort(comp);
		
		products.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));
		
		for (Product p : products) {
			System.out.println(p);
		}
	}
}
