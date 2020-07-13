package net.tis.chatting;

import java.util.ArrayList;
import java.util.Vector;

public class Chatting_ArrayListEx {

	public static void main(String[] args) {
		
		ArrayList<String[]> list = new ArrayList<String[]>();
//		while(result.next()) {
//			list.add(new String[] {
//				result.getString("Identity"),
//				result.getString("password"),
//				result.getString("name"),
//				result.getString("phone"),
//				result.getString("gender"),
//				result.getString("age"),
//				result.getString("birth")					
//			}); 
//		}
		String []a = new String[]{"nutopia002", "123456", 
				"Kyle", "123456789", "Male", "28", "11/16"};
		list.add(a);
		
		String []b = new String[] {"abcabc", "456789", 
				"Jane", "123456789", "Male", "28", "11/16"};
		list.add(b);
		
		list.add(new String[]{"abcabc", "456789", 
				"Jane", "123456789", "Male", "28", "11/16"});
		list.add(new String[]{"abcabc", "456789", 
				"Jane", "123456789", "Male", "28", "11/16"});
		String[][] arr = new String[list.size()][7];
		list.toArray(arr);

//		for(int i = 0;i<arr.length;i++) {
//			for(int j = 0;j<arr[i].length;j++) 
//			System.out.print(arr[i][j] + "  ");
//			System.out.println();
//		}
//		System.out.println();
		for(int i = 0; i<arr.length;i++) {
			for(int j = 0;j<2;j++) 
				System.out.print(arr[i][j] + "  ");
				System.out.println();
		}
		
	}

}
