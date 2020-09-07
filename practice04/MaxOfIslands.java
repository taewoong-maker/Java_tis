package practice05;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxOfIslands {
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
		
		MaxOfIslands mi = new MaxOfIslands();
		int a = mi.solve(input);
		System.out.println(a);
	}
	
	public int solve(int[][] input) {
		Queue<Integer> queue = new PriorityQueue<Integer>(Comp);
		if(input.length==0||input==null) {
			return 0;
		}
		for(int i=0;i<input.length;i++) {
			for(int j=0;j<input[i].length;j++) {
				if(input[i][j]==1) {
					check(input,i,j);
					queue.offer(count);
					count=0;
				}
			}
		}		
		prnt(input);
		return queue.peek();
	}
	
	public void check(int[][] input, int i, int j) {
		
		if(i<0||i>=input.length||j<0||j>=input[i].length||input[i][j]!=1)
			return;
		
		input[i][j]=2;
		count ++ ; 
		check(input,i+1,j);
		check(input,i-1,j);
		check(input,i,j+1);
		check(input,i,j-1);

	}
	
	public void prnt(int[][] input) {
		for(int i=0;i<input.length;i++) {
			for(int j=0;j<input[i].length;j++) {
				System.out.print(input[i][j] + "  ");
			}
			System.out.println();
		}		
	}
	
	Comparator<Integer> Comp = new Comparator<Integer>() {
		
		@Override
		public int compare(Integer a, Integer b) {
			// TODO Auto-generated method stub
			return b-a;
		}
	};
}
