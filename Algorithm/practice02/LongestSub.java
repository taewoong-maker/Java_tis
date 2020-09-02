package practice02;

import java.util.ArrayList;
import java.util.List;

public class LongestSub {
	
	public static void main(String[] args) {
		String s = "ccaabbb";//result = 5
		LongestSub ls = new LongestSub();
		System.out.println("aa");
		ls.solve(s);
	}
	
	public int solve(String a) {
		
		List<StringBuilder> list = new ArrayList<StringBuilder>();
		
		int cnt = 0;
		
		while(cnt<a.length()) {
			StringBuilder sb = new StringBuilder();
			sb.append(a.indexOf(cnt));
			
			for(int i=cnt+1;i<a.length();i++) {
//				System.out.println("123456");
				if(a.indexOf(i)==a.indexOf(i-1)) {
					sb.append(a.indexOf(i));
					continue;
				}		
				System.out.println(sb.toString());
				list.add(sb);
				cnt=i;
				break;
			}
		}
		System.out.println(list.indexOf(0));
			
		return 0;
	}
}
