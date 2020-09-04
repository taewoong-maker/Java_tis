package practice03;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ReserveListNode {
	public static void main(String[] args) {
		ListNode ln = new ListNode(1);
		ln.next = new ListNode(2);
		ln.next.next = new ListNode(3);
		ReserveListNode rl = new ReserveListNode();
		ListNode result = rl.solve(ln);

		while(result!=null) {
			System.out.println(result.val);
			result=result.next;
		}
	}
	
	public ListNode solve(ListNode ln) {
		ListNode p = ln;
		ListNode result = null;
		ListNode p2=null;
		
		while(p!=null) {
			result=p;
			p=p.next;
			result.next=p2;
			p2=result;
		}
		
		return result;
	}
	
	Comparator<ListNode> Comp = new Comparator<ListNode>() {

		public int compare(ListNode a, ListNode b) {
			return b.val-a.val;
		}
	};
}
