package net.tis.day06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class DBTest2  { 
 
   public static void main(String[] args) {
      Connection CN=null;  //DB���������� user/pwd���, CN�����ؼ� ��ɾ����
      Statement ST=null;   //�����θ�ɾ� ST=CN.createStatement(X);
      ResultSet RS=null;  //RS=ST.executeQuery("select~") ; ��ȸ����� RS���
      String msg="" ; 
      
       try{
        Class.forName("oracle.jdbc.driver.OracleDriver"); //����̺�ε�
        String url="jdbc:oracle:thin:@127.0.0.1:1521:XE" ;
        CN=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","system","1234");
        System.out.println("����Ŭ���Ἲ��success ������");
      
      Scanner sc = new Scanner(System.in);
      System.out.print("code >> ");
      String code = sc.nextLine();
      
      System.out.print("name >> ");
      String name = sc.nextLine();
      
      System.out.print("title >> ");
      String title = sc.nextLine();      
      
      //SQL> delete from test where code > 6600 ; 
      //SQL> commit ;
       ST=CN.createStatement();
       //msg= "insert into test values(8800, 'LG', 'LB' ,sysdate, 0)";
       //msg= "insert into test values(code, 'name', 'title' ,sysdate, 0)";
       msg= "insert into test values("+code+",'"+name+"','"+title+"',sysdate, 0)";
       System.out.println(msg);
       int OK = ST.executeUpdate(msg);
       if(OK>0){System.out.println("test���̺� ���强��success");}
           
     // ��ü���
     System.out.println("=============================================");
     RS = ST.executeQuery("select * from test order by code");
     while(RS.next()==true) {
        int a=RS.getInt("code");
        String b = RS.getString("name");
        String c = RS.getString("title");
        Date dt = RS.getDate("wdate");
        int hit = RS.getInt("cnt");
        System.out.println(a+"\t"+b+"\t"+c+"\t"+dt+"\t"+hit);
     }
     System.out.println("=============================================");
                
       //�Ѱ���ȸ
       //�Ѱǻ��� 
       
       }catch(Exception ex){System.out.println("����: "+ ex.toString() );   }
   }//main end
   
   public void dbInsert( ) {
      
   }//end--------------------
   
   public void dbSelectAll( ) {
      
   }//end--------------------
   
   public void dbSearchName( ) {
      
   }//end--------------------
   
   public void dbDelete( ) {
      
   }//end--------------------
}// class END


//1�űԵ��  2.��ü���  3.�̸�  4.����  9.����
//������  Class.forName(); CN=DriverManager.getConnection(1,2,3)
//dbInsert(  )  dbSelectAll( )  dbSearchName()  , dbDelete()










