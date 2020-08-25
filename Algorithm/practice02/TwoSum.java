package practice02;

import java.util.*;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = {1,2,3,7};
        int target =10;
        
        TwoSum ts = new TwoSum();
        int result[]=ts.solve(nums, target);
        for(int i:result)
        	System.out.println(i);
	}
	
	//
	public int[] solve(int[] nums, int target) {
		int[] result = new int[2];
//		
		//첫번째 내가 푼것.
//		for(int i=0;i<nums.length;i++) {
//			for(int j=i+1;j<nums.length;j++)
//				if(nums[j]==target-nums[i]) {
//					result[0]=i+1;
//					result[1]=j+1;
//					break;
//				}		
//		}

		//두번째 강의보고 푼 것.
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++) {
			if(map.containsKey(nums[i])) {
				result[0]=map.get(nums[i])+1;
				result[1]=i+1;
			}else {
				map.put(target-nums[i], i);
			}
		}
		
		return result;	
	}
}
