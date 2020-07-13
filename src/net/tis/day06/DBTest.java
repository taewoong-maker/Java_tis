package net.tis.day06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DBTest  {
	public static void main(String[] args) {
		Connection CN; //DB서버정보및 user/pwd기억, CN참조해서 명령어생성
		Statement ST;  //정적인명령어 ST=CN.createStatement(X);
		 try{
	     Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이브로드
	     String url="jdbc:oracle:thin:@127.0.0.1:1521:XE" ;
	     CN=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","system","1234");
	     System.out.println("오라클연결성공success 월요일");
	   
//	     Scanner sc = new Scanner(System.in);
//	      ST=CN.createStatement();	      
//	      System.out.println("코드, 이름, 제목, 날짜, 카운트를 차례로 입력하세요");
//	      String CODE=sc.nextLine();
//	      String NAME=sc.nextLine();
//	      String TITLE=sc.nextLine();
//	      String WDATE=sc.nextLine();
//	      String CNT=sc.nextLine();
//	      
//	      String msg="insert into test values("
//	      +CODE+",'"+ NAME+"','"+TITLE
//	    		  +"','"+WDATE+"','"+CNT+"')";     
//	      
//	      int OK=ST.executeUpdate(msg);
//	      
//	      if(OK>0) {
//	      	System.out.println("test테이블 저장성공success");
//	      	//저장성공후 전체출력
//	      	System.out.println("=============================");
	     
	     System.out.println("CODE  NAME  TITLE  WDATE  CNT");
//	     PreparedStatement statement =CN.prepareStatement(
//			 "select * from test");

//	     ResultSet result = statement.executeQuery();
//	     while(result.next()) {	    	
//	    	 System.out.print(result.getString("CODE"));
//	    	 System.out.print("\t");
//	    	 System.out.print(result.getString("NAME"));
//	    	 System.out.print("\t");
//	    	 System.out.print(result.getString("TITLE"));
//	    	 System.out.print("\t");
//	    	 System.out.print(result.getString("WDATE"));
//	    	 System.out.print("\t");
//	    	 System.out.print(result.getString("CNT"));
//	    	System.out.println();
//	     }
	     
	     String msg="select * from test order by CODE";
	     ST=CN.createStatement();
	     ResultSet rs = ST.executeQuery(msg);
	     while(rs.next()) {
	    	 System.out.print(rs.getString("code"));
	    	 System.out.print("\t");
	    	 System.out.print(rs.getString("name"));
	    	 System.out.print("\t");
	    	 System.out.print(rs.getString("title"));
	    	 System.out.print("\t");
	    	 System.out.print(rs.getDate("wdate"));
	    	 System.out.print("\t");
	    	 System.out.print(rs.getString("cnt"));
	    	 System.out.println();
	     }	     
	      		      
		 }catch(Exception ex) { System.out.println("실패: " + ex); }
		  
	}//main end
}// class END

