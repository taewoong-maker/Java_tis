package practice02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagrams {
	public static void main(String[] args) {
	
		String txt = "BACDGABCDA";
		String pat = "ABCD";
		char []a = txt.toCharArray();
		char []b = pat.toCharArray();
		
		System.out.println(solve2(a, b));
		System.out.println(solve(a, b));
		
	}
	
	public static List<Integer>solve2(char[]a,char[]b){
		char[]c = new char[b.length];
		List<Integer> nums = new ArrayList<Integer>();
		
		for(int i=0;i<a.length-b.length+1;i++) {
			
			List<Character> list = new ArrayList<Character>();
			
			for(int j=i;j<i+b.length;j++) {
				list.add(a[j]);
			}
			
			for(int x=0;x<list.size();x++) {
				c[x]=list.get(x);
			}
			Arrays.sort(c);
			if(Arrays.equals(b, c))
				nums.add(i);
		}
		
		return nums;
	}
	
	public static List<Integer>solve(char[]a,char[]b){
		
		char[]c = new char[b.length];
		List<Integer> nums = new ArrayList<Integer>();
		
		for(int i=0;i<a.length-b.length+1;i++) {
						
			for(int j=i;j<i+b.length;j++) {
				c[j-i]=a[j];
			}
			
			Arrays.sort(c);
			if(Arrays.equals(b, c))
				nums.add(i);
		}
		
		return nums;
	}
}
