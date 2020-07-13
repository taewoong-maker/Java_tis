package net.hb.day22;
import java.io.*;
import java.net.*;
import java.util.*;  //벡터를 사용
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Server implements Runnable{  //스레드 사용
	private  Vector vc=new Vector();
	private  TextArea ta ;
	private  Frame fr;
	
	public Server()	{
			ta= new TextArea();
			fr = new Frame("서버");
			fr.add(ta);
			fr.setTitle("채팅창");
			fr.setBounds(200, 200, 300,550);
			fr.setVisible(true);
			
			fr.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e) {
						System.out.println("서버 창 종료합니다");
						System.exit(1);
				} 				
			});
	} //end
	
	public void run(){
		ServerSocket ss=null;
		try{
			ss=new ServerSocket(5555);  //서버에서 계속 감시하는 포트번호(약속할 포트)
		}catch(Exception ex){System.out.println("오류:"+ex); return;}
		while(true){
			try{
			
					ta.append("클라이언트 접속대기중\n");
				Socket s=ss.accept();  //소켓 정보를 읽음. 최초의 연결(실제 접속한 클라이언트와 연결)
				//클라이언트에서 접속요구가 있으면 이를 소켓객체에 할당하고, 할당된 소켓객체가 
				//실제 접속을 담당하게 되는 구조를 갖는다. 이를 위해 accept() 사용
				ta.append("클라이언트 접속처리 \n");
				
				Service cs=new Service(s);  //아래에 클래스 기술(객체 생성시 소켓전달이 필수)
				cs.start();   //run() 메소드 호출
				cs.myname=cs.in.readLine();
				cs.messageAll("/c"+cs.myname);
				vc.add(cs); //이미 접속되어 있는 다른 클라이언트에게 나를 알리고 나를 벡터에 등록

				for(int i=0;i<vc.size();i++){
					Service cs1=(Service)vc.elementAt(i); //벡터 요소 꺼내기
					cs.message("/c"+cs1.myname); //myname을 가지고 클라이언트에 전송하기
					//새로 접속한 경우... 기존의 정보를 가져와야함.
				}
			}catch(Exception ex){ex.printStackTrace(); return;}
		}//while 끝
	} //run메소드 끝
	
	class Service extends Thread{  //내부클래스...Run()메소드 재정의
		String myname="guest";   //대화명
		BufferedReader in;
		OutputStream out;
		Socket s;
		
		public Service(Socket s){
			try{
				this.s=s;  //연결된 클라이언트에 의해 서버 소켓 생성
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
				           //InputStreamReader는 in과 s의 다리 역할.
				out=s.getOutputStream();
			}
			catch(Exception ex){ex.printStackTrace(); return;}
		}//end
		
		public void run(){
			while(true){
				try{
					String msg=in.readLine(); //대화명 또는 메세지 받음. 계속해서 읽혀짐
						ta.append("읽음 : " + msg + "\n");
				
					if(msg==null) return;

					if(msg.charAt(0)=='/'){
						if(msg.charAt(1)=='n'){ // /n:이름바꾸기, /i:귓속말, /t:따돌림
							if(msg.charAt(2)==' '){
								// /n 공백 현재이름 변경할 이름
								messageAll("/n"+myname+"-"+msg.substring(3).trim());
								this.myname=msg.substring(3).trim();
							}
						}
						else if(msg.charAt(1)=='q'){
							try{
								for(int i=0 ; i<vc.size(); i++)
								{
									Service  svc = (Service)vc.get(i);
									if(myname.equals(svc.myname))
									{
										vc.remove(i);
										break;
									}
								}
								
								messageAll("/q"+myname);
								
							in.close();
							out.close();
								s.close();  //소켓 끊기
								return;
							}catch(Exception ex){messageAll("/q"+myname);}
						}
						else if(msg.charAt(1)=='s'){
							String name=msg.substring(2, msg.indexOf('-')).trim();
							for(int i=0;i<vc.size();i++){
								Service cs3=(Service)vc.elementAt(i);
								if(name.equals(cs3.myname)){
									cs3.message(myname+">(귓속말)"+msg.substring(msg.indexOf('-')+1));
									break;
								}
							}
						}
					}
					else
						messageAll(myname+">"+msg);  //대화명과message
				}catch(Exception ex){ex.printStackTrace(); return;}
			}//while끝
		}//run끝
		
		public void messageAll(String msg){  
			//벡터의 자료 꺼내어 클라이언트에게 보내기
			for(int i=0;i<vc.size();i++){
				try{
					Service cs=(Service)vc.elementAt(i); //i번째 벡터값으로 아래처럼 뿌리기
					cs.message(msg);
				}catch(Exception ex){vc.removeElementAt(i--);} //예외발생시 제거
			}			
		}//messageAll끝

		public void message(String msg) throws Exception{
			//서버가 클라이언트로 정보를 보내주는 메소드
			out.write((msg+"\n").getBytes());
			ta.append("보냄 : " + msg + "\n");
		}
	}//Service클래스 끝

	public static void main(String[] args){
		Server cs=new Server();
		new Thread(cs).start();  //Thread t=new Thread(cs); t.start()와 동일
	}//main end
} //Server clas END
