package practice02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public static void main(String[] args) {
		String [] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		System.out.println(solve(input));
	}
	
	
	public static List<List<String>> solve(String[]input){
		
		
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		List<List<String>> result = new ArrayList<List<String>>();
		
		for(String a: input) {
			char[]charArray = a.toCharArray();
			Arrays.sort(charArray);
			String key = String.valueOf(charArray);
			
			
			if(map.containsKey(key)) {
				map.get(key).add(a);
			}else {
				List<String> list = new ArrayList<String>();
				list.add(a);
				map.put(key, list);
			}
			
		}
		result.addAll(map.values());
		return result;
	}
}
