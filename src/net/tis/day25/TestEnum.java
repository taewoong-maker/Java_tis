package net.tis.day25;

public class TestEnum {

  public enum Lession{JAVA, XML, SPRING } //�����ݷо���

  public enum Item{ 
	  //�������� �ٸ����� �ٶ��� �Ǹ������� �����ݷ� ��´�
	  Add(5), Del(12), Search(7), Cancel(24); //�����ݷ�����
	  private final int var;
	  Item(int v){ var=v; }  //�����ھտ� public ����ϸ� �����߻� 
	  public int getVar(){ return var;}
   }//Item end	
  
  public static void main(String[] args){	
	  Tis  tt = Tis.ANDROID;
	  System.out.println("6/25 ����� = " + tt);
    Lession le=Lession.JAVA;
    System.out.println("le="+le);
    System.out.println("XML="+Lession.XML);
    System.out.println();
    

	//��������ü���� �迭�� ����
	Item[ ] it=Item.values();
	System.out.println("�������� ������="+it.length);

    //��������ü���� �迭�� ����
    for(Item n: Item.values()){
     System.out.println( n + " : " + n.getVar());	
    }
    
  }//main end
}//class END

