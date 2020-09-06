package practice04;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthese {
	
	public static void main(String[] args) {
		
		String input1 = "{()}";
		String input2 = "(){}[]";
		String input3 = "{(})";
		String input4 = "(]";
		
		System.out.println(solve(input1));
		System.out.println(solve(input2));
		System.out.println(solve(input3));
		System.out.println(solve(input4));
		System.out.println(solve2(input1));
		System.out.println(solve2(input2));
		System.out.println(solve2(input3));
		System.out.println(solve2(input4));
	}
	public static boolean solve (String str) {
		
		Stack<Character> stack = new Stack<Character>();
		char[] c = str.toCharArray();
		Map<Character, Character> map = new HashMap<Character, Character>();
		char key;
		char value='a';
		
		for(int i=0;i<c.length;i++) {
			key = c[i];
			
			if(stack.isEmpty()==false && stack.peek()==map.get(key)) {
				stack.pop();
			}else {
				if(key=='(') {
					 value=')';
				}else if(key==')') {
					 value='(';
				}else if(key=='[') {
					 value = ']';
				}else if(key==']') {
					 value = '[';
				}else if(key=='{') {
					 value = '}';
				}else if(key=='}') {
					 value = '{';
				}
				
				map.put(value, key);
				stack.push(key);			
			}
		}		
		
		return stack.isEmpty();
	}
	
public static boolean solve2(String str) {
		
		Stack<Character> stack = new Stack<Character>();
		
		if(str.length()%2!=0)
			return false;
		
		for(int i=0;i<str.length();i++) {
			switch(str.charAt(i)) {
				case ')' : 
					if(stack.isEmpty()==false&&stack.peek()=='(')
						stack.pop();
						break;
				case '}' : 
					if(stack.isEmpty()==false&&stack.peek()=='{')
						stack.pop();
						break;
				case ']' : 
					if(stack.isEmpty()==false&&stack.peek()=='[')
						stack.pop();
						break;
				default :
					stack.push(str.charAt(i));
			}
			
		}		
		
		return stack.isEmpty();
	}
}
