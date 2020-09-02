package practice02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KCloset {
	
	public static void main(String[] args) {
		
		int[][] clo = {{1,3},{-2,2}};
		int k = 1;
//		System.out.println(clo[k].length);
		
	}
	public int[][] solve(int[][] points, int k){
		Queue<int[]> heap = new PriorityQueue<>(points.length,Comp);

		int result [][]=new int[k][2];
		int index=0;
		for(int[] p:points) {
			heap.offer(p);
		}
		
		while(index<k) {
			result[index]=heap.poll();
			index++;
		}
		
		return result;
	}
	
	Comparator<int[]> Comp = new Comparator<int[]>() {
		
		@Override
		public int compare(int[] a, int[] b) {
			// TODO Auto-generated method stub
			return (a[0]*a[0]+a[1]*a[1])-(b[0]*b[0]+b[1]*b[1]);
		}
	};
}
