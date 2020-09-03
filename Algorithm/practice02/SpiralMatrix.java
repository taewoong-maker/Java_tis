package practice02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpiralMatrix {
	public static void main(String[] args) {
		int[][] spiral = {
				{1,2,3},
				{4,5,6},
				{7,8,9},
				{10,11,12}
		};
		System.out.println(solve(spiral));
	}
	
	
	public static ArrayList<Integer> solve(int[][]spiral){
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int rowStart = 0;
		int rowEnd = spiral.length-1;
		
		int colStart = 0;
		int colEnd = spiral[0].length-1;
		
		while(rowStart<=rowEnd&&colStart<=colEnd) {
			for(int j=colStart;j<colEnd+1;j++) {
				nums.add(spiral[rowStart][j]);
			}
			rowStart++;
			
			for(int j=rowStart;j<rowEnd+1;j++) {
				nums.add(spiral[j][colEnd]);
			}
			colEnd--;
			
			for(int j=colEnd;j>=colStart;j--) {
				nums.add(spiral[rowEnd][j]);
			}
			rowEnd--;
			
			for(int j=rowEnd;j>=rowStart;j--) {
				nums.add(spiral[j][colStart]);
			}
			colStart++;
		}	
			
		
		return nums;
	}
}
