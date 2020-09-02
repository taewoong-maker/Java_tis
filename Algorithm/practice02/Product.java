package practice02;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Product {
	public static void main(String[] args) {
		Map<String, Double> productPrice = new HashMap<>();

		// add value
		productPrice.put("Rice", 6.9);
		productPrice.put("Flour", 3.9);
		productPrice.put("Sugar", 4.9);
		productPrice.put("Milk", 3.9);
		productPrice.put("Egg", 1.9);
		
		Set<String> keys = productPrice.keySet();
		
//		keys.forEach(key->System.out.println(key));//람다식
//		productPrice.keySet().forEach(key->System.out.println(key));//람다식
//		
//		System.out.println("--------------------------------");
//		
//		Collection<Double> col = productPrice.values();
//		col.forEach(price->System.out.println(price));
		
//		Set<Map.Entry<String, Double>> entries = productPrice.entrySet();
//		entries.forEach(entry->System.out.println(entry));
//		
//		for(Map.Entry<String, Double> entry:entries) {
//			System.out.println("key : " + entry.getKey());
//			System.out.println("value : " + entry.getValue());
//		}
		
		double aa = productPrice.getOrDefault("Fish", 29.4)+1;
		System.out.println(aa);
		aa =  productPrice.getOrDefault("Rice", 29.4)+1;
		System.out.println(aa);
//		productPrice.keySet().forEach(key->System.out.println(key));
//		System.out.println(productPrice.toString());
		
	}
}
