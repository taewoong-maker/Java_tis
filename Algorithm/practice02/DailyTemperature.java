package practice02;

import java.util.*;
import java.util.Stack;


public class DailyTemperature {

	public static void main(String[] args) {
		
		int[] nums= {73,74,76,71,69,72,86,73};
		int[] degs= new int[nums.length];
		
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]<nums[j]) {
					degs[i]=j-i;
					break;	
				}else if(j==degs.length){
					degs[i]=0;
				}					
			}
		}
		
		for(int i:degs)
			System.out.println(i);
	}
	
	
}
