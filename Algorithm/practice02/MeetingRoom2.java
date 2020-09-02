package practice02;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Interval3{
	int start, end;
	Interval3(){
		this.start =0;
		this.end =0;
	}
	Interval3(int s, int e){
		this.start = s;
		this.end = e;
	}
}
public class MeetingRoom2 {
	
	public static void main(String[] args) {
		MeetingRoom2 a = new MeetingRoom2();
		Interval3 in1 = new Interval3(1,10);
		Interval3 in2 = new Interval3(2,8);
		Interval3 in3 = new Interval3(3,5);
		Interval3 in4 = new Interval3(6,7);
		Interval3 in5 = new Interval3(9,13);
		Interval3 in6 = new Interval3(6,8);
		Interval3 in7 = new Interval3(4,7);
		Interval3[] intervals = {in1,in2,in3,in4,in5,in6,in7};
//		System.out.println(a.solve(intervals));
		MeetingRoom2 mt = new MeetingRoom2();
		int max = mt.solve2(intervals);
		System.out.println(max);
//		mt.print(intervals);
	}
	public int solve(Interval3[] intervals) {
		if(intervals==null||intervals.length==0) {return 0;}
		
		Arrays.sort(intervals, (a,b)->(a.start-b.start));
		Queue<Interval3> minHeap = new PriorityQueue<>(intervals.length,(a,b)->(a.end-b.end));
		int max = 0;
		
		//for
		for(int i=0; i<intervals.length;i++) {
			while(!minHeap.isEmpty()
					&& minHeap.peek().end <intervals[i].start) {
				minHeap.poll();
			}
			minHeap.offer(intervals[i]);//첫번째가 들어감
			max=Math.max(max, minHeap.size());
		}
				
		return max;
	}
	
	public int solve2(Interval3[] intervals) {
		if(intervals==null||intervals.length==0) {return 0;}
		
		Arrays.sort(intervals,Comp);
		Queue<Interval3> heap = new PriorityQueue<Interval3>(intervals.length,Comp2);
		
		heap.offer(intervals[0]);
		
		for(int i=1;i<intervals.length;i++) {
			Interval3 inter = heap.poll();
			if(inter.end<intervals[i].start) {
				inter.end=intervals[i].end;
			}else {
				heap.offer(intervals[i]);
			}
			heap.offer(inter);
		}
				
		return heap.size();
	}
	
	Comparator<Interval3> Comp2 = new Comparator<Interval3>() {
		@Override
		public int compare(Interval3 o1, Interval3 o2) {
			// TODO Auto-generated method stub
			return o1.end - o2.end;
		}
	};
	
	Comparator<Interval3> Comp = new Comparator<Interval3>() {
		@Override
		public int compare(Interval3 o1, Interval3 o2) {
			// TODO Auto-generated method stub
			return o1.start - o2.start;
		}
	};
	public void print(Interval3[] intervals) {
		for(int i =0;i<intervals.length;i++) {
			System.out.print(intervals[i].start + "  " + intervals[i].end);
			System.out.println();
		}
	}
}
