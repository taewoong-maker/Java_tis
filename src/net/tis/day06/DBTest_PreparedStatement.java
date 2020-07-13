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
	
	Connection CN=null; //DB서버정보및 user/pwd기억, CN참조해서 명령어생성
	Statement ST=null;
	PreparedStatement PST=null;  //정적인명령어 ST=CN.createStatement(X);
	CallableStatement CST=null; //storedprocedure 연결
	ResultSet RS=null;  //RS=ST.executeQuery("select~"); 조회결과를 RS가 기억
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
			System.out.println("기록이 올바르게 출력되지 않았습니다.");
			return 0;
		}			
	}
	
	public void dbConnection() {
		try {
  		 Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이브로드
  	     String url="jdbc:oracle:thin:@127.0.0.1:1521:XE" ;
  	     CN=DriverManager.getConnection(url,"system","1234");
		}catch (Exception e) {}
	}
	
    public void dbInsert() {      
    	 try{       
    	 
    	 System.out.println("등록하고자 하는 코드번호, 이름, 타이틀을 "
    	 		+ "순서대로 입력하세요");
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
	 	 
	 	 System.out.println("데이터가 성공적으로 등록되었습니다.");
	 	 dbSelectAll();
    	 }catch (Exception e) {
			System.out.println("데이터 저장 실패");
		}      
    }
    
    public void dbSelectAll() {
    	try {
//       		System.out.println("전체 데이터 수 : " +countRecord());
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
	    	      System.out.println("존재하지 않는 이름입니다");
	    	   }
    	   } catch (SQLException e) {
    		   System.out.println("에러 : " + e.toString());
    	   }
    }
    
    public void dbSearchName() {
    	try {    		
    		Scanner sc = new Scanner(System.in);
    		System.out.println("검색하고 싶은 이름을 입력하세요");
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
			System.out.println("조회하고자 하는 이름이 존재하지 않습니다.");
			e.printStackTrace();
		}
    }
    
    public void dbDelete() {
    	try {    		
    		Scanner sc = new Scanner(System.in);
    		dbSelectAll();
    		System.out.println("=================================");
    		System.out.println("삭제하고 싶은 데이터의 코드번호를 입력하세요");
    		System.out.print("code>>");
    		int code=sc.nextInt();
			ST=CN.createStatement();
			int OK=PST.executeUpdate("delete from test where code = "+code);
			if(OK>0){System.out.println("데이터 삭제성공success");}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
    }
    
    public void dbUpdate() {
    	try {
    		Scanner sc = new Scanner(System.in);
    		dbSelectAll();
    		System.out.println("변경하고자 하는 필드명을 선택해주세요");
    		System.out.println("1.code, 2.name, 3.title 중 선택");
    		int field=Integer.parseInt(sc.nextLine());    		
    		
			System.out.println("바꾸기 전 값을 입력해주세요");
			String before=sc.nextLine();
			
			System.out.println("바꾼 후의 값을 입력해주세요");
			String after=sc.nextLine();
			
			msg= "update TEST set code = ? where code = ?";			
    	 	PST=CN.prepareStatement(msg);     	 		 	 	
	 	 	PST.setString(1, after);	 		
	 	 	PST.setString(2, before);
	 	 	System.out.println("1");
    	 	PST.executeUpdate();
    	 	System.out.println("1");
    	 	System.out.println("데이터가 성공적으로 변경되었습니다.");
    	 	dbSelectAll();
    	}catch (Exception e) {
			// TODO: handle exception
    		System.out.println("데이터 변경을 실패하였습니다.");
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
	         System.out.print("1신규등록  2.전체출력  3.이름  4.삭제 5.데이터값 변경  9.종료 >>> ");
	         cheak = sc.nextInt();
	         
	         switch (cheak) {
	         // 신규등록
	         case 1:
	            db.dbInsert();
	            break;
	         // 전체출력
	         case 2:
	        	 System.out.println("전체 데이터 수 : " + db.countRecord());
	            db.dbSelectAll();	            
	            break;
	         // 이름
	         case 3:
	            db.dbSearchName();
	            break;
	         // 삭제
	         case 4:
	            db.dbDelete();
	            break;
	         // 종료
	         case 5:
	        	 db.dbUpdate();
	        	 break;
	         case 9:
	            System.out.println("시스템이 종료되었습니다.");
	            break;
	         }
		  }while(cheak!=9);	
		 }catch (Exception e) {}
	}//main end
}// class END
