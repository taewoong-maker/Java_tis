package net.hb.day22;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MClient extends JFrame implements ActionListener, Runnable, ItemListener {
	JFrame jf=new JFrame("Messenger");
	Canvas cv=new Canvas();
	BufferStrategy bs;
	BufferedImage img = null;
	Choice ch1=new Choice();
	Choice ch2=new Choice();
	JPanel jp1=new JPanel();
	JPanel jp2=new JPanel();
	JPanel jp3=new JPanel();
	JPanel jp4=new JPanel(new BorderLayout());
	JPanel jp5=new JPanel();
	JPanel jp6=new JPanel();
	JPanel jp7=new JPanel();
	JPanel jp8=new JPanel(new BorderLayout());
	JPanel jp9=new JPanel();
	JPanel jp10=new JPanel(new BorderLayout());
	JPanel jp11=new JPanel(new BorderLayout());
	JPanel jp12=new JPanel();
	JPanel jp13=new JPanel();
	JLabel jl_d=new JLabel("대화명");
	TextField tf_name=new TextField(10);
	TextField tf_change=new TextField(10);
	TextField tf_server=new TextField(14);
	TextField tf_msg=new TextField(30);
	JButton jb_con=new JButton("입장");
	CheckboxGroup group=new CheckboxGroup();
	Checkbox cb1=new Checkbox("모두에게", group, true);
	Checkbox cb2=new Checkbox("귓속말", group, false);
	TextArea ta_out=new TextArea(25,1);
	JButton jb_change=new JButton("대화명변경");
	JButton jb_cl=new JButton("지우개");
	JButton jb_send=new JButton("보내기");
	JButton jb_exit=new JButton("나가기");
	JLabel jl_ppl=new JLabel("접속자");
	List list=new List(23);
	JLabel jl_num=new JLabel("인원수", JLabel.LEFT);
	JLabel num=new JLabel("         ", JLabel.RIGHT);
	JLabel serverip=new JLabel("서버입력");
	JLabel serverch=new JLabel("서버선택");
	MenuBar mb=new MenuBar();
	Menu mfile=new Menu("파일");
	MenuItem mopen=new MenuItem("텍스트파일 열기");
	MenuItem msave=new MenuItem("대화내용 저장");
	MenuItem mexit=new MenuItem("종료");
	MenuItem mbb=new MenuItem("숫자야구");
	Calendar now;
	String time;
	int hh, mm,  ss;
	int count=0;	
	int ran;
	OutputStream out;
	BufferedReader in;
	Socket soc;

	public MClient(){
		initializeWindow();
		layoutCom();
	}//end

	public void layoutCom() {
		jp1.add(jl_d);
		jp1.add(tf_name);
		jp1.add(jb_con);
		jp1.add(tf_change);
		jp1.add(jb_change);
		jp1.add(cb1);
		jp1.add(cb2);
		jp4.add("North", jp1);
		jp4.add("Center", ta_out);
		jp3.add(jb_cl);
		jp3.add(ch1);
		jp3.add(tf_msg);
		jp3.add(jb_send);
		jp4.add("South", jp3);
		jp9.add(jp4);
		jp5.add(jl_ppl);
		jp8.add("North", jp5);
		for(int i=1; i<20; i++) list.add("");
		jp6.add(list);
		jp8.add("Center", jp6);
		jp7.add(jl_num);
		jp7.add(num);
		jp7.add(jb_exit);
		jp8.add("South",jp7);
		jp12.setBackground(Color.orange);
		jp13.setBackground(Color.orange);
		jp11.add("North",jp12);
		jp11.add("South",jp13);
		jp12.add(serverip);
		jp12.add(tf_server);
		jp13.add(serverch);
		jp13.add(ch2);
		jp10.add("North",jp11);
		jp10.add("South",jp8);
		jf.setMenuBar(mb);
		jf.getContentPane().add("West",jp10);
		jf.getContentPane().add("East", jp9);
		jf.setSize(1190,640);
		jf.setResizable(false);
		mb.add(mfile);
		mfile.add(mopen);
		mfile.add(msave);
		mfile.addSeparator();
		mfile.add(mexit);
		
		ch1.addItem("s(￣▽￣)/ 짜쟌~~");
		ch1.addItem("(*￣ .￣)a 어랏!! 머였더라?");
		ch1.addItem("♬(^0^)~♪ 랄랄라~ 즐거워");
		ch1.addItem("＼(*｀Д´)/  으라차차!!");
		ch1.addItem("(/ㅡ_-)/~ 저리가버렷!!");
		ch1.addItem("∠(- o -) 뚜웅~성!!");
		ch1.addItem("s(￣▽￣)v 김취~ 찰칵!!");
		ch1.addItem("s(￣へ￣ )z 흥!! 나 삐져따!");
		ch1.addItem("┌(ㆀ_ _)┐ 팔굽혀펴기");
		ch1.addItem("s(ごoご)グ 자자!! 주목!!");
		ch1.addItem("[_]a(^^* ) 커피 한잔 어때?");
		ch1.addItem("ㅡ..ㅡㆀ 흐미…");
		ch1.addItem("(::::[ ]::::) 내가 치료해줄께");
		ch1.addItem("(''  )(  '') 요리조리…");
		ch1.addItem("[(￣.￣)]zZ 잘좌~~");
		ch1.addItem("[(-.-)(^^*)] 여버~ 자?");
		ch1.addItem("O(￣▽￣)o 아싸아~~");
		ch1.addItem("(^(oo)^) 웃는 돼지");
		ch1.addItem("(T(oo)T) 우는 돼지");
		ch1.addItem("(-(oo)-) 삐진 돼지");
		ch1.addItem("@-m-m-- 꽃 받아영~~");
		ch1.addItem("＼(^0^*)/ 이만큼 살앙해!");
		ch1.addItem("＼(-0-)/ 기지개~");
		ch1.addItem("s(￣ 3￣)す=33 후우~ 담배 한대..");
		ch1.addItem("へ(￣⌒￣へ) 내 다리 내놔~");
		ch1.addItem("(*^^)/(__ ;) 애인으로 임명함다");
		ch1.addItem("(*ㅡ_(#ㅡ_ㅡ)_-) 형님! 당했슴다");
		ch1.addItem("(  ㅅ)=333 방구 뽕~~ ㅋㅋ");
		ch1.addItem("o('-'o) (o'-')o 요리보고 조리보고");
		
		ch2.addItem("자주가는 서버");
		ch2.addItem("127.0.0.1");
		ch2.addItem("118.130.22.159");
		ch2.addItem("203.236.209.121");
		ch2.addItem("203.236.209.127");
		
		cv.setSize(400,0);
		jf.getContentPane().add("Center",cv);
		cv.createBufferStrategy(2);
		bs=cv.getBufferStrategy();
		jf.pack();
		//jf.setLocationRelativeTo(null);
		
		while(true){
			try{
				random();
				img = ImageIO.read(new File("img"+ran+".jpg"));
			}catch(Exception e){}
			Graphics g = bs.getDrawGraphics();
			g.drawImage(img,WIDTH,HEIGHT,null);
			bs.show();
			try {Thread.sleep(5000);} catch (Exception e) {}
		}
	}//layout end
	
	public void random() {
		for(int i = 0; i < 20; i++){
			ran=(int)(Math.random()*20)+1;
		} //i end
	} //end
	
	public void setList(){ //list 다시 초기화하는 함수
		try{
		for(int i=0; i<20; i++){
			if(list.getItem(i)!=""){
				list.remove(i);
				list.add("", i);
				count--;
			}
		}
		}catch(Exception e){}
	}//end
	
	public void initializeWindow(){
		jf.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){exit();}});
		jp1.setBackground(Color.white);
		jp2.setBackground(Color.white);
		jp3.setBackground(Color.white);
		jp5.setBackground(Color.white);
		jp6.setBackground(Color.white);
		jp7.setBackground(Color.white);
		jp9.setBackground(Color.black);
		jp10.setBackground(Color.black);
		ta_out.setBackground(Color.black);
		ta_out.setFont(new Font("굴림체", Font.BOLD, 16));
		list.setFont(new Font("굴림체", Font.BOLD, 16));
		tf_server.setFont(new Font("굴림체", Font.BOLD, 14));
		ch2.setFont(new Font("굴림체", Font.BOLD, 14));
		jf.setResizable(true);
		ta_out.setEditable(true);
		//jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		mexit.addActionListener(this);
		msave.addActionListener(this);
		mopen.addActionListener(this);
		mbb.addActionListener(this);
		jb_exit.addActionListener(this);
		jb_send.addActionListener(this);
		tf_msg.addActionListener(this);
		tf_name.addActionListener(this);
		jb_con.addActionListener(this);
		tf_change.addActionListener(this);
		jb_change.addActionListener(this);
		ta_out.setForeground(Color.white);
		ch1.addItemListener(this);
		ch2.addItemListener(this);
		jb_cl.addActionListener(this);
	}//end

	public void fileSave(){
		FileDialog fd=new FileDialog(this, "대화내용 저장", FileDialog.SAVE);
		fd.show();
		String dir=fd.getDirectory();
		String file=fd.getFile();
		if(dir==null||file==null) return;
		File f=new File(dir+file);
		try{
			PrintWriter pw=new PrintWriter(f);
			pw.println(ta_out.getText());
			pw.close();
			ta_out.append("대화내용이 저장되었습니다\r\n");
		}catch(Exception e){  }
	}//end

	public void fileOpen(){
		FileDialog fd=new FileDialog(this, "파일 열기", FileDialog.LOAD);
		fd.show();
		String dir=fd.getDirectory();
		String file=fd.getFile();
		if(dir==null||file==null) return;
		try{
			FileReader fr=new FileReader(dir+file);
			BufferedReader br=new BufferedReader(fr);
			while(true){
				String data="";
				data=br.readLine();
				if(data==null)break;
				//ta_out.append(data+"\n");
				out.write((tf_name.getText()+data+"\n").getBytes());
			}
		}catch(Exception e){  }
	}//end

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==mexit || e.getSource()==jb_exit){
			try{
				out.write(("/q"+tf_name.getText()+"\n").getBytes());
				System.out.println("보냄 : " +tf_name.getText());
				ta_out.append("****"+tf_name.getText()+"님이 퇴장하셨습니다****\r\n");
				in.close();
				out.close();
				soc.close();
				setList();
			}catch(Exception ex ) {
				System.out.println("보내기 오류 " + ex.getMessage());
			}
			ta_out.setEnabled(false);
			tf_msg.setEnabled(false);
			jb_exit.setEnabled(false);
			tf_name.setEnabled(true);
			jb_con.setEnabled(true);
			tf_name.setText("");
			tf_name.requestFocus();
		}
		else if(e.getSource()==msave){ fileSave(); }
		else if(e.getSource()==mopen){ fileOpen(); }
		else if(e.getSource()==mbb){       }
		else if(e.getSource()==jb_send || e.getSource()==tf_msg){ sendProcess(); }
		else if(e.getSource()==jb_con || e.getSource()==tf_name){ connect(); }
		else if(e.getSource()==jb_change || e.getSource()==tf_change){ change(); }
		else if(e.getSource()==jb_cl){ ta_out.setText(""); }
	}//end
	
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==ch1 && e.getStateChange()==ItemEvent.SELECTED){
			String msg=tf_msg.getText();
			try{
				if(cb1.getState()==true){
					out.write((msg+e.getItem()+"\n").getBytes());
					}
				else if(cb2.getState()==true){
					String name=list.getSelectedItem();
					out.write(("/s"+name+"-"+msg+e.getItem()+"\n").getBytes());
					ta_out.append("(귓속말)"+name+"님께 >> "+msg+e.getItem()+"\r\n");
					}
			}catch(Exception ex){}
			tf_msg.setText("");
			tf_msg.requestFocus();
		}
		if(e.getSource()==ch2 && e.getStateChange()==ItemEvent.SELECTED){
			tf_server.setText("");
			String sv=tf_server.getText();
			try{
				tf_server.setText((sv+e.getItem()));
			}catch(Exception ex){}
			tf_name.requestFocus();
		}
	}//end
	
	public void exit(){
		try{
			out.write(("/q"+tf_name.getText()+"\n").getBytes());
			System.out.println("보냄 : " +tf_name.getText());
			ta_out.append("****"+tf_name.getText()+"님이 퇴장하셨습니다****\r\n");
			in.close();
			out.close();
			soc.close();
			setList();
		}catch(Exception ex ) {
			System.out.println("보내기 오류 " + ex.getMessage());
		}
		ta_out.setEnabled(false);
		tf_msg.setEnabled(false);
		jb_exit.setEnabled(false);
		tf_name.setEnabled(true);
		jb_con.setEnabled(true);
		tf_name.setText("");
		tf_name.requestFocus();
		System.exit(1);
	}//end
	
	public void sendProcess(){
		String str=tf_msg.getText();
		try {
			if(str.charAt(0)=='q'){  //q이면 서버 종료??뭐야 이게.....
				out.write(("/q"+tf_name.getText()+"\n").getBytes()); //서버로 대화명 보내고 in, out, soc 다 닫음
				System.out.println("서버로 보냄 >> "+tf_name.getText()+" \n");
				in.close();
				out.close();
				soc.close();
				System.exit(0);
			}
			if(cb1.getState()==true){ //모두에게 메시지 보내기
				out.write((tf_msg.getText()+"\n").getBytes());
				System.out.println("메시지를 서버로 보냄 >> "+tf_msg.getText());
			}
			else if(cb2.getState()==true){ //한사람에게 귓속말 보내기
				try{
					String name=list.getSelectedItem();
					if(name==null || name==""){
						ta_out.append(">>>대상을 찾을 수 없습니다"+"\r\n");
					}
					else{
					out.write(("/s"+name+"-"+tf_msg.getText()+"\n").getBytes());
					System.out.println("귓속말전달 >> /s"+name+"-"+tf_msg.getText());
					ta_out.append("(귓속말)"+name+"님께 >> "+tf_msg.getText()+"\r\n");
					}
				}catch(Exception e){ta_out.append(e.getMessage()); }
			}
			tf_msg.setText("");
			tf_msg.requestFocus();
		} catch (Exception e) { ta_out.append(e.getMessage()); } 
	}//end

	public void connect() { //대화명을 서버로 보내서 접속자에 등록. 
		ta_out.setEnabled(true);
		tf_msg.setEnabled(true);
		jb_exit.setEnabled(true);
		try {
			String svip=tf_server.getText();
			soc=new Socket(svip, 5555); //소켓지정
			in=new BufferedReader(new InputStreamReader(soc.getInputStream())); //서버에서 stream(접속자들 메시지 등등?)을 가져옴?
			out=soc.getOutputStream(); // 서버로 보냄
			out.write((tf_name.getText()+"\n").getBytes()); //접속자 대화명을 바이트로해서 서버에 내보냄?
			System.out.println("서버로 보냄 >> "+tf_name.getText()); 
			tf_name.setEnabled(false);
			jb_con.setEnabled(false);
			new Thread(this).start(); //다른 클라이언트들의 메시지를 서버로부터 가져옴
			tf_msg.requestFocus();
		} catch (Exception e) {  ta_out.append(e.getMessage()); }   //소켓에서 발생한 예외오류메시지를 출력하는듯...
	}//end
	
	public void change(){
			try{
				String msg =tf_change.getText();
				out.write(("/n "+msg+"\n").getBytes());
				tf_change.setText("");
				tf_msg.requestFocus();
			}catch(Exception ex){ }
	}//end

	public void run() {
		while(true){
			now=Calendar.getInstance();
			hh=now.get(now.HOUR_OF_DAY);
			mm=now.get(now.MINUTE);
			ss=now.get(now.SECOND);
			time=hh+":"+mm+":"+ss; 
			//서버로 내 메시지를 보내고, 서버에서 다른 클라이언트들의 메시지를 가져옴
			try {
				String msg = in.readLine();
				System.out.println("서버로부터 읽음 : "+msg);

				if(msg==null) return;
				if(msg.charAt(0)=='/'){
					if(msg.charAt(1)=='c'){ //c, s, 이런건 서버에서 설정해주는거임 	 
						list.replaceItem(msg.substring(2), count); //list에 msg.substring(2)값을 넣고, list index자리 지정
						count++;
						num.setText(String.valueOf(count)); //인원 수 변경
						ta_out.append("****"+msg.substring(2)+"님이 입장하셨습니다****\r\n"); //모든 클라이언트에게 입장을 알림 
						tf_name.setEnabled(false); //대화명 label 비활성
						jb_con.setEnabled(false); //접속버튼 비활성      
					}
					
					else if(msg.charAt(1)=='q'){ //나가기버튼 누르거나 /q를 입력하면 서버에 q가 입력이 돼. 왜 그렇게 되지? 퇴장
						String str=msg.substring(2);
						ta_out.append("****"+str+"님이 퇴장하셨습니다****\r\n");
						for(int i=0;i<list.getItemCount();i++){ //list목록에서 퇴장하는 대화명찾아 돌려서 remove
							if(str.equals(list.getItem(i))){
								list.remove(i);
								count--;
								num.setText(String.valueOf(count));
								break;
							}
						}
						//return;    얘 때문에 누군가가 퇴장을 하면 내 메시지가 서버로만 가고 클라이언트로 안 뿌려줌...
					}
					else if(msg.charAt(1)=='n'){ //대화명변경
						String oldname=msg.substring(2, msg.indexOf('-'));  
						String newname=msg.substring(msg.indexOf('-')+1);
						ta_out.append("*"+oldname+"님의 이름이 "+newname+"으로 변경되었습니다.*\r\n");

						for(int j=0;j<count;j++){
							if(oldname.equals(list.getItem(j))){
								list.replaceItem(newname, j);
								break;
							}
						}
					}
				}
				else  ta_out.append("["+time+"] "+msg+"\r\n");
			}catch (Exception e) { ta_out.append(e.getMessage()); } 
		}
	}//end

	public static void main(String[] args) {
		MClient mc=new MClient();
		Thread tr = new Thread(mc);
	}//main end
}//class END