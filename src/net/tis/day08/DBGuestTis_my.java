package net.tis.day08;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;


public class DBGuestTis_my { 
		Connection CN=null;//DB���������� user/pwd���, CN�����ؼ� ��ɾ����
		Statement ST=null;//�����θ�ɾ� ST=CN.createStatement(X);
		PreparedStatement PST=null; //�����θ�ɾ� PST=CN.prepareStatememt(msg)
		CallableStatement CST=null; //storedprocedure����
		ResultSet RS=null;//RS=ST.executeQuery("select~") ; ��ȸ����� RS���
		String msg="" ; 
		int Gtotal=0; //��ü���ڵ尹��
		Scanner sc = new Scanner(System.in);
			
	 public DBGuestTis_my() {
		 try{
	     Class.forName("oracle.jdbc.driver.OracleDriver"); //����̺�ε�
	     String url="jdbc:oracle:thin:@127.0.0.1:1521:XE" ;
	     CN=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","system","1234");
	     System.out.println("����Ŭ���Ἲ��success ������");
	     ST=CN.createStatement();
		 }catch (Exception e) {	}
	 }//������
	 
	public static void main(String[] args) {
		DBGuestTis_my gg = new DBGuestTis_my();
				
		Scanner scin = new Scanner(System.in);
		while(true) {
			System.out.print("\n1���  2��ü���  9����>>> ");
			int sel=scin.nextInt();
			if(sel==1){gg.guestInsert();}
			else if(sel==2){gg.guestSelectAll(); }
			else if(sel==9){ gg.myexit(); break; }
		}
		scin.close();
	}//main end
	
	

	public void guestSelectAll( ) {//��ü���
		try {
		msg="select * from guest  order by sabun" ;
		RS = ST.executeQuery(msg);
		while(RS.next()==true) {
		  System.out.println(RS.getInt("sabun")+"\t" + RS.getString("name")+"\t" + RS.getString("title"));
		}
		System.out.println("=============================================");
		}catch (Exception e) { System.out.println("��ü��ȸ����");}
	}//end--------------------
	

	
	public void myexit() {
		System.out.println("���α׷��� �����մϴ�");
		System.exit(1);
	}//end--------------------
	
	
	public void guestInsert() {
		try{
			int s= 7878;	 
			String n="blue"; 
			String t="color";   
			int p=92;  
			int h=7;
			String e="aa@LB.com" ;
		  CST=CN.prepareCall("{call guest_sp_insert(?, ?, ?, ?, ?, ?) }");
			CST.setInt(1,s);	
			CST.setString(2, n);
			CST.setString(3, t);
			CST.setInt(4, p);
			CST.setInt(5, h);
			CST.setString(6, e);
			CST.executeUpdate() ;
			 System.out.println("Stored procedure���强��"); 
		}catch(Exception ex) { System.out.println("Stored procedure�������");
		System.out.println(ex);}
	}//end--------------------
}/////////////////////////////////////////////class END

