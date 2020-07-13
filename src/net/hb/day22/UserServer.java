package net.hb.day22;

import  java.io.*; //data처리 
import  java.net.*;//소켓

public class UserServer {
	public static void main(String[ ] args){
		try{
			//순서1- 서버소켓생성후 - client접속을 대기중
			ServerSocket   server = new  ServerSocket(1111); 
			System.out.println("client접속 대기중...");
			
			//순서2-일반소켓으로 서버소켓의 접속을 받음
			Socket  socket = server.accept();
			System.out.println(  "client접속 대기중");
			
			//순서3-접속한 client주소표시 
			InetAddress  add = socket.getInetAddress();
			System.out.println( add +" client접속함");
			
			//순서4 - 소켓으로 접속한 stream처리
				InputStream  is   = socket.getInputStream();
				OutputStream  os = socket.getOutputStream();
			
			//순서5 - while문으로 소켓으로 연결된데이타 주고받기 
			InputStreamReader  isr = new  InputStreamReader(  is ) ;
			OutputStreamWriter   osw = new  OutputStreamWriter( os ) ; 
			BufferedReader    br = new BufferedReader(  isr ) ;
			PrintWriter   pw = new PrintWriter(   osw ) ;
			while(true){
				String  data = br.readLine();
				if(data=="quit" || data.equals("Quit") || data=="q" || data.equals("QUIT")) {
					System.out.println("에코Server채팅 종료") ; 
					break ; 
				} 
				System.out.println("client내용: " + data);
			}//while END
			br.close(); pw.close(); socket.close();  isr.close(); osw.close(); 
		}catch(Exception ex) {  }
	} //main end
} //class END






































