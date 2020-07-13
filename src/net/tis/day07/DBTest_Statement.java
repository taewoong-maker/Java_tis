package net.tis.day07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class DBTest_Statement  {
	
	Connection CN=null; //DB���������� user/pwd���, CN�����ؼ� ��ɾ����
	Statement ST=null;  //�����θ�ɾ� ST=CN.createStatement(X);
	ResultSet RS=null;  //RS=ST.executeQuery("select~"); ��ȸ����� RS�� ���
	String msg="";
	
	public void dbConnection() {
		try {
  		 Class.forName("oracle.jdbc.driver.OracleDriver"); //����̺�ε�
  	     String url="jdbc:oracle:thin:@127.0.0.1:1521:XE" ;
  	     CN=DriverManager.getConnection(url,"system","1234");
  	     System.out.println("���Ἲ��");
		}catch (Exception e) {
			System.out.println("�������");
			System.out.println(e);
		}
	}
	
    public void dbInsert() {
      
    	 try{
    	 System.out.println("����ϰ��� �ϴ� �ڵ��ȣ, �̸�, Ÿ��Ʋ�� "
    	 		+ "������� �Է��ϼ���");
	     Scanner sc = new Scanner(System.in);
	     while(true) {
	    	 System.out.print("code >> ");
	    	
		 	 int code = Integer.parseInt(sc.nextLine());
		 	
		 	ST=CN.createStatement();
		 	 RS=ST.executeQuery("select count(*) hit from test where code = " + code);
		 	System.out.println(3);
		 	 if(RS.next()) {
		 		 if(RS.getInt("hit")==1) {
		 			 System.out.println("������Դϴ�.");
		 			 continue;
		 		 }
		 	 }
		 	 
		 	 System.out.print("name >> ");
		 	 String name = sc.nextLine();
		 	 
		 	 System.out.print("title >> ");
		 	 String title = sc.nextLine();
		 	   
		 	 msg= "INSERT INTO TEST VALUES("+code+",'"+name+"','"+title+"',SYSDATE, 0)";
		 	 ST=CN.prepareStatement(msg);
	     }
	 	 
//	 	 RS=ST.executeQuery("select * from test");
//	 	  
//	 	 while(RS.next()) {	 		 
//	 		 if(RS.getString("code").equals(code)) {
//	 			 System.out.println("�ߺ��Ǵ� �ڵ��Դϴ�.");
//	 			continue;
//	 		 }else {
//	 			ST.executeUpdate(msg);   
//	 			break;
//	 		 }
//	 	 }
    	 }catch (Exception e) {
			System.out.println("��Ͻ���");
			System.out.println(e);
		}
    }
    
    public void dbSelectAll() {
    	try {
    		
    		ST=CN.createStatement();
        	RS = ST.executeQuery("select * from test order by code");
    		  while(RS.next()) {
    			  int a = RS.getInt("code");
    			  String b = RS.getString("name");
    			  String c = RS.getString("title");
    			  Date d = RS.getDate("wdate");
    			  int e =  RS.getInt("CNT");
    			  System.out.println(a+"\t"+b+"\t"+c+"\t"+d+"\t"+e);
    		  }
    	}catch (Exception e) {}	//try catch
    }
    
    public void dbCorrect(String name) {
    	try {
    	   	ST=CN.createStatement();
    		RS = ST.executeQuery("select * from test where name like"
    					+ " '%" + name+"%'");
    		   
	    	   if (RS.next()==false) {
	    	      System.out.println("�������� �ʴ� �̸��Դϴ�");
	    	   }
    	   } catch (SQLException e) {
    		   System.out.println("���� : " + e.toString());
    	   }
    }
    
    public void dbSearchName() {
    	try {    		
    		Scanner sc = new Scanner(System.in);
    		System.out.println("�˻��ϰ� ���� �̸��� �Է��ϼ���");
    		System.out.print("name>");
    		String name =sc.nextLine();
    		dbCorrect(name);
    		    		
			ST=CN.createStatement();
			RS = ST.executeQuery("select * from test where name like"
					+ " '%" + name+"%'");
		   	
			while(RS.next()==true) {
		        int a=RS.getInt("code");
		        String b = RS.getString("name");
		        String c = RS.getString("title");
		        Date dt = RS.getDate("wdate");
		        int hit = RS.getInt("cnt");
		        System.out.println(a+"\t"+b+"\t"+c+"\t"+dt+"\t"+hit);
			}
		   	    	   
		} catch (SQLException e) {
			System.out.println("��ȸ�ϰ��� �ϴ� �̸��� �������� �ʽ��ϴ�.");
			e.printStackTrace();
		}
    }
    
    public void dbDelete() {
    	try {
    		
    		Scanner sc = new Scanner(System.in);
    		dbSelectAll();
    		System.out.println("=================================");
    		System.out.println("�����ϰ� ���� �������� �ڵ��ȣ�� �Է��ϼ���");
    		System.out.print("code>>");
    		int code=sc.nextInt();
			ST=CN.createStatement();
			int OK=ST.executeUpdate("delete from test where code = "+code);
			if(OK>0){System.out.println("������ ��������success");}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
    }

	public static void main(String[] args) {
		DBTest_Statement db = new DBTest_Statement();
		 try{
			db.dbConnection();
			int cheak;
			Scanner sc = new Scanner(System.in);		
		 do {
	         System.out.println(" < M E N U >");
	         System.out.print("1�űԵ��  2.��ü���  3.�̸�  4.����  9.���� >>> ");
	         cheak = sc.nextInt();
	         
	         switch (cheak) {
	         // �űԵ��
	         case 1:
	            db.dbInsert();
	            break;
	         // ��ü���
	         case 2:
	            db.dbSelectAll();
	            break;
	         // �̸�
	         case 3:
	            db.dbSearchName();
	            break;
	         // ����
	         case 4:
	            db.dbDelete();
	            break;
	         // ����
	         case 9:
	            System.out.println("�ý����� ����Ǿ����ϴ�.");
	            break;
	         }
		  }while(cheak!=9);	
		 }catch (Exception e) {}
	}//main end
}// class END
