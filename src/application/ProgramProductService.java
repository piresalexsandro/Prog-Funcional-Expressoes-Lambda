package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;
import model.service.ProductService;

public class ProgramProductService {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		List<Product> products = new ArrayList<>();
		
		products.add(new Product("TV", 900.00));
		products.add(new Product("Mouse", 50.00));
		products.add(new Product("Tablet", 350.50));
		products.add(new Product("Hd Case", 89.90));

		ProductService ps = new ProductService();
		
		double sum = ps.filteredSum(products);
		
		System.out.println("Sum = " + String.format("%.2f",  sum));
		
	}

}
