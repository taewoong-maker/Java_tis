package practice04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		val=x;
	}
}

public class BinaryTreeLevelOrder {
	
	public static void main(String[] args) {
		int[] input = {3,4,5,6,7};
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(9);
		solve(root);
		System.out.println(solve(root));
	}
		
	public static List<List<Integer>> solve(TreeNode root) {
		//1
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root==null)
			return result;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		//2
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new LinkedList<>();
			for(int i=0; i<size; i++) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if(node.left!=null) {
					queue.offer(node.left);
				}
				if(node.right!=null) {
					queue.offer(node.right);
				}
			}
			result.add(list);
		}//while End
		return result;
	}//solve End
	
}
