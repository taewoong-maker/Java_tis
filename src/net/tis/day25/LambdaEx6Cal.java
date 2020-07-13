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
		System.out.println("��=" + (int)ob.add(7,5));
		System.out.println("��=" + (int)ob.sub(7,5));
		System.out.println("��=" + (int)ob.multi(7,5));
		System.out.println("��=" + ob.divi(7,5));
	}
}//class END



/* [����]������ ���⸦ ���ٽ����� �ۼ��Ͻÿ�
 * 
 * 1. �������̽��� : Calc
 *  +calc(a:int,b:int):double
 *    
 * 2. LambdaExCal6���� 
 *    Calc��ü������ ����� 2,5���� ������ ���ϱ�/����/���ϱ�/�����⸦ �ϼ��Ͻÿ�
 *    
 * [������]
 * ��= 7
 * ��= -3
 * ��= 10
 * ��= 0.4   
 */




/*
//@FunctionalInterface ��������
interface Calc{
	public double calc(int a, int b);
}//end


public class LambdaEx6Cal {
	public static void main(String[] args) {
	
		
		System.out.println("��=");
		System.out.println("��=" );
		System.out.println("��=" );
		System.out.println("��=" );
	}
}//class END
*/


