package practice02;

import java.util.*;

class Interval2 {
	int start;
	int end;

	Interval2() {
		start = 0;
		end = 0;
	}

	Interval2(int s, int e) {
		start = s;
		end = e;
	}
}

public class MergeInterval {

	public static void main(String[] args) {

//		int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
		Interval2 in1 = new Interval2(1, 3);
		Interval2 in2 = new Interval2(2, 6);
		Interval2 in3 = new Interval2(8, 10);
		Interval2 in4 = new Interval2(15, 18);

		List<Interval2> intervals = new ArrayList<>();
		intervals.add(in1);
		intervals.add(in2);
		intervals.add(in3);
		intervals.add(in4);
		MergeInterval a = new MergeInterval();
//		a.print(intervals);
		System.out.println("-------------------");
		List<Interval2> list = a.merge(intervals);
		
		
		a.print(list);
	}

	public List<Interval2> merge(List<Interval2> intervals) {

		Collections.sort(intervals,comp);
		
		print(intervals);
		System.out.println("-------------------");
		
		
		for (int i = 0; i < intervals.size()-1; i++) {
			if(intervals.get(i).end>intervals.get(i+1).start){
				intervals.add(new Interval2(intervals.get(i).start, intervals.get(i+1).end));
//				System.out.println("get("+i+").end = " + intervals.get(i).end);
//				System.out.println("get("+(i+1)+").start = " + intervals.get(i+1).start);
				intervals.remove(i);
				intervals.remove(i);
				Collections.sort(intervals,comp);
			}
				
		}

		return intervals;
	}
	// 1
	Comparator comp = new Comparator<Interval2>() {
		public int compare(Interval2 a, Interval2 b) {
			// TODO Auto-generated method stub
			return a.start - b.start;
		}
	};

	void print(List<Interval2> list) {
		for (int i = 0; i < list.size(); i++) {
			Interval2 in = list.get(i);
			System.out.println(in.start + " " + in.end);
		}
	}
}
