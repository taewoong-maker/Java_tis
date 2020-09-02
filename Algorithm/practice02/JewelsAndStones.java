package practice02;

import java.util.*;

public class JewelsAndStones {

	public static void main(String[] args) {
		String J = "aA";
		String S = "aAaAbbb";
		JewelsAndStones js = new JewelsAndStones();
		System.out.println(js.solve2(J, S));
//		js.solve2(J, S);
	}
	
	
	public int solve(String jew, String stone) {
		
		int cnt = 0;
		char[]sto = stone.toCharArray();
		char[]je = jew.toCharArray();
		for(int i=0;i<je.length;i++) {
			for(int j=0;j<sto.length;j++) {
				if(je[i]==sto[j])
					cnt++;
			}
		}		
		return cnt;
	}
	
	public int solve2(String jew, String stone) {
		
		int cnt = 0;
		char[]sto = stone.toCharArray();
		char[]je = jew.toCharArray();
		Set<Character> jewel = new HashSet<Character>();
		
		for(int i=0;i<je.length;i++)
			jewel.add(je[i]);
		
		for(int i=0;i<sto.length;i++) {
			if(jewel.contains(sto[i]))
				cnt++;
		}
		return cnt;
	}


	
}
