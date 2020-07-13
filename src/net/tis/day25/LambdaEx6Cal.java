package net.tis.day25;


interface Calc{
	public double add(int a, int b);
	public double sub(int a, int b);
	public double multi(int a, int b);
	public double divi(int a, int b);	
}//interface end


public class LambdaEx6Cal implements Calc{
	@Override
	public double add(int a, int b) {
		return a+b;
	}

	@Override
	public double sub(int a, int b) {
		return a-b;
	}

	@Override
	public double multi(int a, int b) {
		return a*b;
	}

	@Override
	public double divi(int a, int b) {
		return (double)a/b;
	}
	
	public static void main(String[] args) {
		LambdaEx6Cal ob=new LambdaEx6Cal();
		System.out.println("합=" + (int)ob.add(7,5));
		System.out.println("차=" + (int)ob.sub(7,5));
		System.out.println("곱=" + (int)ob.multi(7,5));
		System.out.println("몫=" + ob.divi(7,5));
	}
}//class END



/* [문제]간단한 계산기를 람다식으로 작성하시오
 * 
 * 1. 인터페이스명 : Calc
 *  +calc(a:int,b:int):double
 *    
 * 2. LambdaExCal6에서 
 *    Calc객체변수를 만들고 2,5값을 가지고 더하기/빼기/곱하기/나누기를 완성하시오
 *    
 * [실행결과]
 * 합= 7
 * 차= -3
 * 곱= 10
 * 몫= 0.4   
 */




/*
//@FunctionalInterface 생략가능
interface Calc{
	public double calc(int a, int b);
}//end


public class LambdaEx6Cal {
	public static void main(String[] args) {
	
		
		System.out.println("합=");
		System.out.println("차=" );
		System.out.println("곱=" );
		System.out.println("몫=" );
	}
}//class END
*/


