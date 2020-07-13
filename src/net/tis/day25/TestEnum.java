package net.tis.day25;

public class TestEnum {

  public enum Lession{JAVA, XML, SPRING } //세미콜론없음

  public enum Item{ 
	  //열거형에 다른값을 줄때는 맨마지막에 세미콜론 찍는다
	  Add(5), Del(12), Search(7), Cancel(24); //세미콜론있음
	  private final int var;
	  Item(int v){ var=v; }  //생성자앞에 public 기술하면 에러발생 
	  public int getVar(){ return var;}
   }//Item end	
  
  public static void main(String[] args){	
	  Tis  tt = Tis.ANDROID;
	  System.out.println("6/25 목요일 = " + tt);
    Lession le=Lession.JAVA;
    System.out.println("le="+le);
    System.out.println("XML="+Lession.XML);
    System.out.println();
    

	//열거형객체들은 배열로 관리
	Item[ ] it=Item.values();
	System.out.println("열거형의 사이즈="+it.length);

    //열거형객체들은 배열로 관리
    for(Item n: Item.values()){
     System.out.println( n + " : " + n.getVar());	
    }
    
  }//main end
}//class END

