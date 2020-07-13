package net.hb.day22;

import  java.io.*; //data처리 
import  java.net.*;//소켓
public class UserClient {
	public static void main(String[ ] args){
		try{
			//순서1- 서버소켓생성후 - client접속을 대기중	
			//순서2-일반소켓으로 서버소켓의 접속을 받음
			//순서3-접속한 client주소표시 
			
			//순서A 서버접속을 위한 ip, port번호필요
			Socket  socket  = new  Socket("127.0.0.1", 1111);
			//순서B- 소켓으로 접속한 stream처리
				InputStream  is   = socket.getInputStream();
				OutputStream  os = socket.getOutputStream();
			
			//순서5 - while문으로 소켓으로 연결된데이타 주고받기 
			BufferedReader    br = new BufferedReader( new InputStreamReader( is)) ;
			PrintWriter   pw = new PrintWriter(   new OutputStreamWriter( os )) ;
			//client가 키보드에서 데이타 입력
			BufferedReader  key = new BufferedReader( new InputStreamReader(System.in)) ;
			while(true){
				System.out.print("메세지입력: " );
				String  data = key.readLine(); //키보드에서 입력 
				if(data=="quit" || data.equals("Quit") || data=="q" || data.equals("QUIT")) {
					System.out.println("에코Client채팅 종료") ; 
					break ; 
				} 
				pw.println(data); pw.flush() ; 
			}//while END
			br.close(); pw.close(); socket.close();  key.close();  
		}catch(Exception ex) {  }
	} //main end
} // class END










