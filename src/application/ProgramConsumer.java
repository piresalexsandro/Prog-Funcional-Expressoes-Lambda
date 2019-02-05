package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

import entities.Product;

public class ProgramConsumer {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		List<Product> products = new ArrayList<>();
		
		products.add(new Product("TV", 900.00));
		products.add(new Product("Mouse", 50.00));
		products.add(new Product("Tablet", 350.50));
		products.add(new Product("Hd Case", 89.90));
		
		double factor = 1.10;
		
		//Consumer<Product> cons = p -> p.setPrice(p.getPrice() * factor);
		
		//usa chaves quando a temos mais de uma linha (mais comum)
		Consumer<Product> cons = p -> {
			p.setPrice(p.getPrice() * factor);
		};
		
		products.forEach(cons);
		
		products.forEach (System.out::println);
	}

}
