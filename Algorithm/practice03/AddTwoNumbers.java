package practice03;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		this.val = x;
	}
}

public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode ln = new ListNode(2);
		ln.next = new ListNode(4);
		ln.next.next = new ListNode(3);
		
		ListNode ln2 = new ListNode(5);
		ln2.next =  new ListNode(6);
		ln2.next.next = new ListNode(2);
		
		ListNode node = solve(ln, ln2);
		
		while(node!=null) {
			System.out.println(node.val);
			node=node.next;
		}
	}
	
	public static ListNode solve(ListNode ln, ListNode ln2) {
		//1
		ListNode newHead = new ListNode(0);
		ListNode p1 = ln, p2 = ln2, p3=newHead;
		int carry =0;		
		
		//2
		while(p1!=null&& p2!=null) {
			if(p1!=null) {
				carry+=p1.val;
				p1=p1.next;
			}
			if(p2!=null) {
				carry+=p2.val;
				p2=p2.next;
			}
			p3.next = new ListNode(carry%10);
			p3=p3.next;
			carry/=10;
		}
		if(carry==1)
			p3.next=new ListNode(1);
		
		return newHead.next;
	}
}
