package practice02;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
	
	public static void main(String[] args) {
		int[] nums = {2,3,5,50,75};
		int lower = 0, upper = 99;
		System.out.println(solve(nums, lower, upper));
	}
	
	public static List<String> solve(int[]nums, int lower, int upper) {
		List<String> fn = new ArrayList<String>();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for(int i=0;i<nums.length;i++) {
			
			if(nums[i]>lower) {
				System.out.println("i : " + i);
				List<Integer> arr = new ArrayList<Integer>();
				for(int j=lower;j<nums[i];j++) {
					arr.add(j);
				}//for End
				lower=nums[i]+1;
				list.add(arr);
			}else {
				lower++;
			}			

		}//for End
		
		List<Integer> arr = new ArrayList<Integer>();
		for(int i=lower;i<=upper;i++) {
			arr.add(i);
		}
		list.add(arr);
		
		for(List<Integer> a:list) {
			Object[]obj =  a.toArray();
			if(obj.length==1) {
				fn.add(String.valueOf(obj[0]));
			}else {
				String abc = String.valueOf(obj[0]) + "->" + String.valueOf(obj[obj.length-1]);
				fn.add(abc);
			}
		}//for End
		
		return fn;
	}//solve End
}
