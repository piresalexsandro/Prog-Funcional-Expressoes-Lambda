package application;

import java.util.ArrayList;
import java.util.List;
import entities.Product;
import util.ProductPredicate;

public class ProgramRemoveIf {

	public static void main(String[] args) {

		List<Product> products = new ArrayList<>();
		
		products.add(new Product("TV", 900.00));
		products.add(new Product("Mouse", 50.00));
		products.add(new Product("Tablet", 350.50));
		products.add(new Product("Hd Case", 89.90));
		
		//products.removeIf(p -> p.getPrice() >= 100);
		//products.removeIf(p -> p.getPrice() >= 100);
		products.removeIf(new ProductPredicate()); // <= onde esta a expressao
		
		for (Product p : products) {
			System.out.println(p);
		}
	}

}
