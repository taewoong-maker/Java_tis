package practice03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class ListNode2{
	ListNode2 next;
	int val;
	public ListNode2(int a) {
		val=a;
	}
}

public class MergeKSortedList {
	public static void main(String[] args) {
		ListNode2 l1 = new ListNode2(1);
		l1.next = new ListNode2(4);
		l1.next.next = new ListNode2(5);
		
		ListNode2 l2 = new ListNode2(1);
		l2.next = new ListNode2(3);
		l2.next.next = new ListNode2(4);
		
		ListNode2 l3 = new ListNode2(2);
		l3.next = new ListNode2(6);
		
//		System.out.println(solve(l1, l2, l3));
		
		ListNode2[] list = new ListNode2[3];
		list[0]=l1;
		list[1]=l2;
		list[2]=l3;
		
		MergeKSortedList ms = new MergeKSortedList();
		ListNode2 result = ms.mergeKLists(list);
		while(result!=null) {
			System.out.println(result.val);
			result=result.next;
		}
		
	}
	public static List<Integer> solve(ListNode2 l1, ListNode2 l2, ListNode2 l3) {
		List<Integer> result = new ArrayList<Integer>();
		ListNode2 p1 = l1, p2=l2, p3=l3;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		while(p1!=null&&p2!=null&&p3!=null) {
			pq.add(p1.val);
			pq.add(p2.val);
			pq.add(p3.val);
			
			p1=p1.next;
			p2=p2.next;
			p3=p3.next;
		}

		while(!pq.isEmpty()) {
			result.add(pq.poll());
		}

		return result;
	}
	
	public ListNode2 mergeKLists(ListNode2[] list) {
		PriorityQueue<ListNode2> que = new PriorityQueue<ListNode2>(Comp);
		ListNode2 newHead = new ListNode2(0);
		ListNode2 p = newHead;
		
//		for(int i=0;i<list.length;i++) {
//			que.offer(list[i]);
//		}
			
//		while(!que.isEmpty()) {
//			ListNode2 node = que.poll();
//			p.next=node;
//			p=p.next;
//			if(node.next!=null) {
//				que.offer(node.next);
//			}
//		}
		
		for(int i=0;i<list.length;i++) {
			while(list[i]!=null) {
				que.add(list[i]);
				list[i]=list[i].next;
			}
		}
		
		while(!que.isEmpty()) {
			p.next=que.poll();
			p=p.next;
		}
		
		return newHead.next;		
	}
	
	Comparator<ListNode2> Comp = new Comparator<ListNode2>() {
		
		@Override
		public int compare(ListNode2 a, ListNode2 b) {
			// TODO Auto-generated method stub
			return a.val-b.val;
		}
	};
}
