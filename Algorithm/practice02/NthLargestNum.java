package practice02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class NthLargestNum {

	public static void main(String[] args) {
		int[] nums = {3,2,1,5,6,4};
		int k = 2;
//		//return = 5
		System.out.println("solve : " + solve(nums, k));
		System.out.println("solve2 : " + solve2(nums, k));
		System.out.println("solve3 : " + solve3(nums, k));;
		NthLargestNum nl = new NthLargestNum();
		nl.solve4(nums, k);
	}
	
	public static int solve(int[]nums, int k) {//LinkedHashSet 规过
		
		Arrays.sort(nums);
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		
		for(int i:nums) {
			set.add(i);
		}

		Object obj[]=set.toArray();
		int num = (int) obj[obj.length-k];
			
		return num;
	}
	
	public static int solve2(int[]nums, int k) {//硅凯 规过
		
		Arrays.sort(nums);
		int num = nums[nums.length-k];
		
		
		return num;
	}
	
	public static int solve3(int[]nums, int k) {//PriorityQueue 规过
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=0;i<nums.length;i++) {			
			pq.add(nums[i]);
			if(i>1)
				pq.poll();
		}
		
		return pq.peek();
	}
	
	public int solve4(int[]nums, int k) {//PriorityQueue 规过
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comp2);
		for(int i=0;i<nums.length;i++) {			
			pq.offer(nums[i]);
		}	
		System.out.println(pq);
		System.out.println(pq.peek());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		
		return pq.poll();
	}
	
	Comparator<Integer> Comp = new Comparator<Integer>() {
		
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o1-o2;
		}
	};
	
	Comparator<Integer> Comp2 = new Comparator<Integer>() {
		
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2-o1;
		}
	};
}
