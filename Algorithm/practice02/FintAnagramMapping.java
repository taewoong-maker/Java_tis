package practice02;

import java.util.HashMap;
import java.util.Map;

public class FintAnagramMapping {
	public static void main(String[] args) {
		int[]a = {11,27,45,31,50};
		int[]b = {50,11,31,45,27};
		solve(a, b);
	}
	public static int[]solve(int[]a,int[]b){
		
		Map<Integer, Integer> map = new HashMap<>();
		int[]result = new int[a.length];
		
		for(int i=0;i<b.length;i++) {
			map.put(b[i],i);
		}
		System.out.println(map.toString());
		System.out.println(map.values());
		for(int i=0;i<result.length;i++) {
			if(map.containsKey(a[i]))
				result[i]=map.get(a[i]);
		}
		
		for(int i: result)
			System.out.println(i);
		
		return null;
	}
}
