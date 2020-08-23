package practice01;

import java.util.Scanner;

public class Practice04 {

	public static void main(String[] args) {
		
		int counter = 0;
		
		for (int n=2;n<=13;n++) {
			int i;
			for(i=2;i<n;i++) {
				counter++;
				if(n%i==0) {
					break;
				}				
			}
			if(n==i)
				System.out.println(n);
		}
		System.out.println("³ª´°¼ÀÀ» ¼öÇàÇÑ È½¼ö : " +counter);
	}
	
}
