package net.tis.day06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DBTest  {
	public static void main(String[] args) {
		Connection CN; //DB���������� user/pwd���, CN�����ؼ� ��ɾ����
		Statement ST;  //�����θ�ɾ� ST=CN.createStatement(X);
		 try{
	     Class.forName("oracle.jdbc.driver.OracleDriver"); //����̺�ε�
	     String url="jdbc:oracle:thin:@127.0.0.1:1521:XE" ;
	     CN=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","system","1234");
	     System.out.println("����Ŭ���Ἲ��success ������");
	   
//	     Scanner sc = new Scanner(System.in);
//	      ST=CN.createStatement();	      
//	      System.out.println("�ڵ�, �̸�, ����, ��¥, ī��Ʈ�� ���ʷ� �Է��ϼ���");
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
//	      	System.out.println("test���̺� ���强��success");
//	      	//���强���� ��ü���
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
	      		      
		 }catch(Exception ex) { System.out.println("����: " + ex); }
		  
	}//main end
}// class END

