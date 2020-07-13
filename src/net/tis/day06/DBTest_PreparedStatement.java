package net.tis.day06;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class DBTest_PreparedStatement  {
	
	Connection CN=null; //DB���������� user/pwd���, CN�����ؼ� ��ɾ����
	Statement ST=null;
	PreparedStatement PST=null;  //�����θ�ɾ� ST=CN.createStatement(X);
	CallableStatement CST=null; //storedprocedure ����
	ResultSet RS=null;  //RS=ST.executeQuery("select~"); ��ȸ����� RS�� ���
	String msg="";
	
	public int countRecord() {
		int cnt = 0;
		try {			
			String msg="select count(*) cnt from test";
			ST=CN.createStatement();
			RS=ST.executeQuery(msg);
			 while(RS.next()) {
				 cnt=RS.getInt("cnt");
			 }
			 return cnt;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("����� �ùٸ��� ��µ��� �ʾҽ��ϴ�.");
			return 0;
		}			
	}
	
	public void dbConnection() {
		try {
  		 Class.forName("oracle.jdbc.driver.OracleDriver"); //����̺�ε�
  	     String url="jdbc:oracle:thin:@127.0.0.1:1521:XE" ;
  	     CN=DriverManager.getConnection(url,"system","1234");
		}catch (Exception e) {}
	}
	
    public void dbInsert() {      
    	 try{       
    	 
    	 System.out.println("����ϰ��� �ϴ� �ڵ��ȣ, �̸�, Ÿ��Ʋ�� "
    	 		+ "������� �Է��ϼ���");
	     Scanner sc = new Scanner(System.in);
	 	 System.out.print("code >> ");
	 	 int code = Integer.parseInt(sc.nextLine());
	 	   
	 	 System.out.print("name >> ");
	 	 String name = sc.nextLine();
	 	 
	 	 System.out.print("title >> ");
	 	 String title = sc.nextLine();
	 	   
	 	 msg= "INSERT INTO TEST VALUES(?,?,?,SYSDATE, 0)";
	 	 PST=CN.prepareStatement(msg);
	 	 	PST.setInt(1, code);
	 	 	PST.setString(2, name);
	 	 	PST.setString(3, title);
	 	 PST.executeUpdate();
	 	 
	 	 System.out.println("�����Ͱ� ���������� ��ϵǾ����ϴ�.");
	 	 dbSelectAll();
    	 }catch (Exception e) {
			System.out.println("������ ���� ����");
		}      
    }
    
    public void dbSelectAll() {
    	try {
//       		System.out.println("��ü ������ �� : " +countRecord());
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
			int OK=PST.executeUpdate("delete from test where code = "+code);
			if(OK>0){System.out.println("������ ��������success");}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
    }
    
    public void dbUpdate() {
    	try {
    		Scanner sc = new Scanner(System.in);
    		dbSelectAll();
    		System.out.println("�����ϰ��� �ϴ� �ʵ���� �������ּ���");
    		System.out.println("1.code, 2.name, 3.title �� ����");
    		int field=Integer.parseInt(sc.nextLine());    		
    		
			System.out.println("�ٲٱ� �� ���� �Է����ּ���");
			String before=sc.nextLine();
			
			System.out.println("�ٲ� ���� ���� �Է����ּ���");
			String after=sc.nextLine();
			
			msg= "update TEST set code = ? where code = ?";			
    	 	PST=CN.prepareStatement(msg);     	 		 	 	
	 	 	PST.setString(1, after);	 		
	 	 	PST.setString(2, before);
	 	 	System.out.println("1");
    	 	PST.executeUpdate();
    	 	System.out.println("1");
    	 	System.out.println("�����Ͱ� ���������� ����Ǿ����ϴ�.");
    	 	dbSelectAll();
    	}catch (Exception e) {
			// TODO: handle exception
    		System.out.println("������ ������ �����Ͽ����ϴ�.");
		}
    }    	    	

	public static void main(String[] args) {
		DBTest_PreparedStatement db = new DBTest_PreparedStatement();
		 try{
			db.dbConnection();
			int cheak;
			Scanner sc = new Scanner(System.in);		
		 do {
	         System.out.println(" < M E N U >");
	         System.out.print("1�űԵ��  2.��ü���  3.�̸�  4.���� 5.�����Ͱ� ����  9.���� >>> ");
	         cheak = sc.nextInt();
	         
	         switch (cheak) {
	         // �űԵ��
	         case 1:
	            db.dbInsert();
	            break;
	         // ��ü���
	         case 2:
	        	 System.out.println("��ü ������ �� : " + db.countRecord());
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
	         case 5:
	        	 db.dbUpdate();
	        	 break;
	         case 9:
	            System.out.println("�ý����� ����Ǿ����ϴ�.");
	            break;
	         }
		  }while(cheak!=9);	
		 }catch (Exception e) {}
	}//main end
}// class END
