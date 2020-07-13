package net.tis.day25;

public class LambdaEx2 {
	
	public static void main(String[] args) {
		Print m1=()->System.out.println("Æë¼ö Lambda");
		Print m2=()->System.out.println("ÆëÇÏ Lambda");
		Print m3=()->System.out.println("ÆëÆÄ Lambda");
		
		m1.view();
		m2.view();
		m3.view();
	}
}//class end
