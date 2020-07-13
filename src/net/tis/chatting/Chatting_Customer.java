package net.tis.chatting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Chatting_Customer {
	
	public static String[][] getcustomers(){
		try {	
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement(
					"Select Identity, password, name, phone, gender, age, birth From customer8");
			ResultSet result = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(result.next()) {
				list.add(new String[] {
					result.getString("Identity"),
					result.getString("password"),
					result.getString("name"),
					result.getString("phone"),
					result.getString("gender"),
					result.getString("age"),
					result.getString("birth")					
				}); 
			}
			System.out.println("The Data has been fetched!");
			String[][] arr = new String[list.size()][7];
			return list.toArray(arr);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static void creatCustomer(String Identity, String password,
									String name, String phone, String gender,
									String age, String birth) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+ "INSERT INTO customer8"
					+ "(Identity, password, name, phone, gender, age, birth) "
					+ "VALUE "
					+ "('" +Identity +"','" + password + "','" + name + "','"
					+ phone + "','" + gender + "','" + age + "','" + birth + "')");
			insert.executeUpdate();
			System.out.println("The data has been saved!");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}	
	
	 public static void createTable() {
         try {
            Connection con = getConnection();
            PreparedStatement create = con.prepareStatement(
                  "create table if not exists customer8(\r\n" + 
                  "id int(10) NOT NULL AUTO_INCREMENT,\r\n" + 
                  "Identity varchar(200),\r\n" + 
                  "password varChar(200),\r\n" + 
                  "name varchar(200),\r\n" + 
                  "phone varChar(200),\r\n" + 
                  "gender varchar(200),\r\n" + 
                  "age varchar(200),\r\n" + 
                  "birth varchar(200),\r\n"
                  + "PRIMARY KEY(id))");
            create.execute();
            
         }catch (Exception e) {
            System.out.println(e.getMessage());
         }finally {
        	 System.out.println("Table Created!");
         }
      }
	
	public static Connection getConnection() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://sql3.freemysqlhosting.net:3306/sql3350093";
			String user = "sql3350093";
			String pass = "IU59HYE1NK";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println("Get connecion successful");
			return con;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
//	public static void main(String[] args) {
//
//		creatCustomer("nutopia002", "123456", "Kyle", "123456789", "Male", "28", "11/16");
//		creatCustomer("abcdef", "010101", "Kyle", "123456789", "Male", "28", "11/16");
//
//	}
	
}
