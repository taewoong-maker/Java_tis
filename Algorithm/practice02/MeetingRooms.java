package practice02;

import java.util.Arrays;
import java.util.Comparator;
/*
* Arrays.sort() 
* time complexity of O(n logn n) 
* space complexity of O(1).
*/


class Interval{
	int start;
	int end;
	Interval(){
		this.start = 0;
		this.end =0;
	}
	Interval(int s, int e){
		this.start = s;
		this.end = e;
	}
}

public class MeetingRooms {
	public static void main(String[] args) {
		MeetingRooms a = new MeetingRooms();
		
		Interval in1 = new Interval(1,7);
		Interval in2 = new Interval(5,10);
		Interval in3 = new Interval(10,30);
		
		Interval[] intervals = {in1, in2,in3};
//		a.print(intervals);
		System.out.println(a.solve(intervals));
	}
	
	public boolean solve(Interval[] intervals) {
		
//		print(intervals);
		Arrays.sort(intervals,Comp);
		print(intervals);
		
		if(intervals==null)
			return false;
		
		for(int i=0; i<intervals.length-1; i++) {
			if((intervals[i].end-intervals[i+1].start)>0)
				return false;			
		}
		
		return true;		
	}
	
	public void print(Interval[] intervals) {
		for(int i=0; i<intervals.length; i++) {
			Interval in = intervals[i];
			System.out.println(in.start+" "+in.end);
		}
	}
	
	Comparator<Interval> Comp = new Comparator<Interval>() {

		@Override
		public int compare(Interval a, Interval b) {
			if((a.start-b.start)>0)
				return 1;
			return -1;
		}
		
	};
	
}
