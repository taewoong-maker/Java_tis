package net.tis.day07;

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

public class DBGuest  {
	
	Connection CN=null; //DB���������� user/pwd���, CN�����ؼ� ��ɾ����
	Statement ST=null;
	PreparedStatement PST=null;  //�����θ�ɾ� ST=CN.createStatement(X);
	CallableStatement CST=null; //storedprocedure ����
	ResultSet RS=null;  //RS=ST.executeQuery("select~"); ��ȸ����� RS�� ���
	String msg="";
	
	public int countRecord() {
		int cnt = 0;
		try {			
			String msg="select count(*) cnt from guest";
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
	    
    public void dbSelectAll() {
    	try {
//       		System.out.println("��ü ������ �� : " +countRecord());
    		ST=CN.createStatement();
        	RS = ST.executeQuery("select rownum, a.* from guest a");
    		  while(RS.next()) {
    			  int row = RS.getInt("rownum");
    			  int a = RS.getInt("sabun");
    			  String b = RS.getString("name");
    			  String c = RS.getString("title");
    			  Date d = RS.getDate("wdate");
    			  int e =  RS.getInt("pay");
    			  int f =  RS.getInt("hit");
    			  String g = RS.getString("email");
    			  System.out.println(row + "  " + a+"\t"+b+"\t"+c+"\t"+d+"\t"+e+"\t"+f+"\t"+g);
    		  }
    	}catch (Exception e) {}	//try catch
    }
    
    public void dbCorrect(String name) {
    	try {
    	   	ST=CN.createStatement();
    		RS = ST.executeQuery("select * from guest where name like"
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
    		
    		System.out.println("�˻��ϰ� ���� �������� �Է��ϼ���");
    		System.out.println("(���� �Է�)");
    		int page = Integer.parseInt(sc.nextLine());
    		
			ST=CN.createStatement();
			System.out.println(2);
			RS = ST.executeQuery("select * from("
					+ "select rownum rn, a.* from ("
					+ " select * from guest a where "
					+ " name like '%"+name+"%' order by sabun)"
					+ "a) where rn between "+ (page*10-9)+ " and "+ (page*10));
			
		   	
			while(RS.next()==true) {
			  int row = RS.getInt("rn");
  			  int a = RS.getInt("sabun");
  			  String b = RS.getString("name");
  			  String c = RS.getString("title");
  			  Date d = RS.getDate("wdate");
  			  int e =  RS.getInt("pay");
  			  int f =  RS.getInt("hit");
  			  String g = RS.getString("email");
  			  System.out.println(row + "  " + a+"\t"+b+"\t"+c+"\t"+d+"\t"+e+"\t"+f+"\t"+g);
			}		   	    	   
		} catch (SQLException e) {
			System.out.println("��ȸ�ϰ��� �ϴ� �̸��� �������� �ʽ��ϴ�.");
			e.printStackTrace();
		}
    }
    
    public void dbPage() {
    	try {    		
    		Scanner sc = new Scanner(System.in);
    		
    		System.out.println("�˻��ϰ� ���� �������� �Է��ϼ���");
    		System.out.println("(���� �Է�)");
    		int page = Integer.parseInt(sc.nextLine());
    		
			ST=CN.createStatement();
			
			RS = ST.executeQuery("select * from ("
					+ "select rownum rn, a.* from guest a order by sabun"
					+ ") where rn between "
					+  (page*10-9)
					+ " and "
					+ (page*10)
					);
			
		   	
			while(RS.next()==true) {
			  int row = RS.getInt("rn");
  			  int a = RS.getInt("sabun");
  			  String b = RS.getString("name");
  			  String c = RS.getString("title");
  			  Date d = RS.getDate("wdate");
  			  int e =  RS.getInt("pay");
  			  int f =  RS.getInt("hit");
  			  String g = RS.getString("email");
  			  System.out.println(row + "  " + a+"\t"+b+"\t"+c+"\t"+d+"\t"+e+"\t"+f+"\t"+g);
			}		   	    	   
		} catch (SQLException e) {
			System.out.println("��½���.");
			e.printStackTrace();
		}
    }

	public static void main(String[] args) {
		DBGuest db = new DBGuest();
		 try{
			db.dbConnection();
			int cheak;
			Scanner sc = new Scanner(System.in);		
		 do {
	         System.out.println(" < M E N U >");
	         System.out.print("1.��ü ���  2.���ϴ� ������ ���  3.�̸��˻�  9.���� >>> ");
	         cheak = Integer.parseInt(sc.nextLine());
	         
	         switch (cheak) {
	         // �űԵ��
	         case 1:
	        	 System.out.println("��ü ������ �� : " + db.countRecord());
		         db.dbSelectAll();	            
		         break;
	         // ��ü���
	         case 2:
	        	 db.dbPage();
	        	 break;
	         // �̸�
	         case 3:
	            db.dbSearchName();
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
