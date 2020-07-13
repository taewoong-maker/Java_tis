package net.tis.day25;

public class Fruit implements Print {
	
	public static void main(String[] args) {
	
		System.out.println("사과사과");
		String msg="풋사과";
		System.out.println(msg);
	   
		System.out.println("사과사과");
		String msg2="망고";
		System.out.println(msg2);
		
		System.out.println("사과사과");
		String msg1="딸기";
		System.out.println(msg1);
		
		int a = 2;
		int b =2;
		
	}//main end
	
	public void coffee() {
		System.out.println("non-static 메소드");
		System.out.println("coffee 메소드 11:51");
		
	}//end

	@Override
	public void view() {
		// TODO Auto-generated method stub
		
	}
}// class END