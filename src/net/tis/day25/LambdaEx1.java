package net.tis.day25;


public class LambdaEx1 implements Print {
	
	
	
	@Override
	public void view() {
		System.out.println("Hello Lambda");
		System.out.println("Hello kim");
		System.out.println("Hello Lee");
	}//end
	
	public static void main(String[] args) {
		LambdaEx1 m = new LambdaEx1();
		m.view();
	}//end
}//class END





/*
public class LambdaEx1{
	
	public static void main(String[] args) {
		Print m=new Print() {
			@Override
			public void view() {
				System.out.println("TIS Lambda 123");
				System.out.println("TIS Lambda 789");
			}
		};
		m.view();
	}
}
*/