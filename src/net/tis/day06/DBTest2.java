package net.tis.day06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class DBTest2  { 
 
   public static void main(String[] args) {
      Connection CN=null;  //DB서버정보및 user/pwd기억, CN참조해서 명령어생성
      Statement ST=null;   //정적인명령어 ST=CN.createStatement(X);
      ResultSet RS=null;  //RS=ST.executeQuery("select~") ; 조회결과를 RS기억
      String msg="" ; 
      
       try{
        Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이브로드
        String url="jdbc:oracle:thin:@127.0.0.1:1521:XE" ;
        CN=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","system","1234");
        System.out.println("오라클연결성공success 월요일");
      
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
       if(OK>0){System.out.println("test테이블 저장성공success");}
           
     // 전체출력
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
                
       //한건조회
       //한건삭제 
       
       }catch(Exception ex){System.out.println("에러: "+ ex.toString() );   }
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


//1신규등록  2.전체출력  3.이름  4.삭제  9.종료
//생성자  Class.forName(); CN=DriverManager.getConnection(1,2,3)
//dbInsert(  )  dbSelectAll( )  dbSearchName()  , dbDelete()










