package net.tis.day25;

public class LambdaEx3 {
	public static void main(String[] args) {
		
		Thread  ice = new Thread(){
			public void run( ) {System.out.println("���̽� �Ƹ�"); }
		};
		ice.start();
		
		
		new Thread( 
				new  Runnable() {//���ʺ��� �������Ѵ�???
					public void run( ) {System.out.println("�޴޴� ����"); }
				}
		).start();
		
		
		Thread orange = new Thread();
		orange.start();  //ȣ��ȵ�
	}//main end
	
  public void run( ) {System.out.println("�������꽺"); }
  
}//LambdaEx3 class END


/*
class MyThread implements Runnable{
	@Override
	public void run() {
		System.out.println("Hello Thread");
	}
}

public class LambdaEx4 {
	public static void main(String[] args) {
//		MyThread ob=new MyThread();
//		Thread th=new Thread(ob);
//		th.start();
		
		new Thread(new MyThread()).start();
	}
}//class END
*/