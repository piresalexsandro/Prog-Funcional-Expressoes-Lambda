package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import entities.Product;
import util.UpperCaseName;

public class ProgramFunction {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		List<Product> products = new ArrayList<>();
		
		products.add(new Product("TV", 900.00));
		products.add(new Product("Mouse", 50.00));
		products.add(new Product("Tablet", 350.50));
		products.add(new Product("Hd Case", 89.90));

		//products.stream().map(new UpperCaseName()); // transformando em stream
		                       // lista => stream                        |    stream  => lista
		List<String> prodNames = products.stream().map(Product::nonStaticUpperCaseName).collect(Collectors.toList()); // lista para stream e stream para lista
		
		prodNames.forEach(System.out::println);
	}

}
