package practice05;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxOfIslands2 {
	int count = 0;
	
	
	public static void main(String[] args) {

		int[][] input = {
				{1,1,0,1,1},
				{0,1,1,0,0},
				{0,0,0,0,0},
				{1,1,0,1,1},
				{1,0,1,1,1},
				{1,0,1,1,1}
				};		
		
		MaxOfIslands2 moi = new MaxOfIslands2();
		System.out.println(moi.solve(input));
	}
	
	public int solve(int[][] input) {
		int max = 0;
		if(input.length==0||input==null) {
			return 0;
		}
		for(int i=0;i<input.length;i++) {
			for(int j=0;j<input[i].length;j++) {
				if(input[i][j]==1) {
					int area = check(input,i,j, 0);
					max=Math.max(area, max);
				}
			}
		}		
		prnt(input);
		return max;
	}
	
	public int check(int[][] input, int i, int j, int area) {
		
		if(i<0||i>=input.length||j<0||j>=input[i].length||input[i][j]!=1)
			return area;
		
		input[i][j]=2;
		area++; 

		int[][]dirs = {{-1,0},{1,0},{0,1},{0,-1}};		
		for(int[]dir : dirs)
			area = check(input,i+dir[0],j+dir[1], area);

		return area;
	}
	
	public void prnt(int[][] input) {
		for(int i=0;i<input.length;i++) {
			for(int j=0;j<input[i].length;j++) {
				System.out.print(input[i][j] + "  ");
			}
			System.out.println();
		}		
	}
	
}
