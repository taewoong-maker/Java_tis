package net.tis.day25;

@FunctionalInterface      //권장 함수형 interface, 람다식으로 사용할 것을 선언 
public interface Print {  
	public void view();
	//@FunctionalInterface 함수는 하나만 선언해야 하는 단점  
	//public int getCount();
//	public void mycal();
}
