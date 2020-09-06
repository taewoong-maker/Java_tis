package practice04;

import java.util.Stack;

public class BaseBallGame {
	public static void main(String[] args) {
		String[]input = {"5","-2","4","C","D","9","+","+"};		
		System.out.println(solve(input));
		
	}
	public static int solve(String[]input) {
		
		Stack<Integer> stack = new Stack<Integer>();
		int result = 0;
		
		for(int i=0;i<input.length;i++) {
			
			if(input[i]=="C") {
				stack.pop();
			}else if(input[i]=="D") {
				int a = stack.pop();
				stack.push(a);
				stack.push(a*2);
			}else if(input[i]=="+") {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b);
				stack.push(a);
				stack.push(a+b);
			}else {
				stack.push(Integer.parseInt(input[i]));
			}					
			System.out.println(stack);
		}//for End
		
		while(!stack.empty()) {
			result +=stack.pop();
		}
		return result;
	}
}
