package net.tis.day25;

public class LambdaEx3 {
	public static void main(String[] args) {
		
		Thread  ice = new Thread(){
			public void run( ) {System.out.println("아이스 아메"); }
		};
		ice.start();
		
		
		new Thread( 
				new  Runnable() {//러너블을 디파인한다???
					public void run( ) {System.out.println("달달달 라테"); }
				}
		).start();
		
		
		Thread orange = new Thread();
		orange.start();  //호출안됨
	}//main end
	
  public void run( ) {System.out.println("오렌지쥬스"); }
  
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