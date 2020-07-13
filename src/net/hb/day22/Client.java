package net.hb.day22;
import java.io.*;
import java.net.*;
import java.util.*; 
import java.awt.*;
import java.awt.event.*;
import java.awt.List;
//import java.applet.*;
public class Client extends Frame implements ActionListener,Runnable{
	Panel panel=new Panel();
	Panel center1=new Panel();
	Panel north=new Panel();
	Panel south=new Panel();
	Panel up1=new Panel();
	Panel up2=new Panel();
	Panel east=new Panel();
	Panel eastdown=new Panel();
	Panel east2=new Panel();
	Panel say=new Panel();
	TextArea txtarea=new TextArea();
	TextField txtsend=new TextField();
	Button btnok=new Button("Ȯ��");
	Button btnconn=new Button("����");
	Button btnclose=new Button("������");
	Button btnrename= new Button("��ȭ����");
	CheckboxGroup cg=new CheckboxGroup();
	Checkbox chksay1=new Checkbox("�ӼӸ�",cg,false);
	Checkbox chksay2=new Checkbox("�ӼӸ� ����",cg,true);
	Label lbl1=new Label("��ȭ��",Label.RIGHT);
	TextField txtname=new TextField();
	Label lbltitle=new Label("������ ���");
	Label lbl2=new Label("�ο�",Label.RIGHT);
	Label lblinwon=new Label("   ",Label.LEFT);
	List list=new List(20);
	
	BufferedReader in;
	OutputStream out;
	Socket soc;
	int count=0; //���� �ο���

	public Client(){
		setLayout(new BorderLayout());
		up1.setLayout(new BorderLayout(8,0));
		up1.add("West",lbl1);
		up1.add("Center",txtname);
		up1.add("North",new Label(" "));
		up1.add("South",new Label(" "));

		say.setLayout(new GridLayout(1,2));
		say.add(chksay1);
		say.add(chksay2);

		up2.setLayout(new BorderLayout(20,0));
		up2.add("Center",say);
		up2.add("West",btnconn);
		up2.add("East",new Label(" "));
		up2.add("North",new Label(" "));
		up2.add("South",new Label(" "));
		
		north.setLayout(new GridLayout(1,2));
		north.add(up1);
		north.add(up2);

		south.setLayout(new BorderLayout(8,0));
		south.add("Center", txtsend);
		south.add("East", btnok);
		south.add("North", new Label(" "));
		south.add("South", new Label(" "));

		center1.setLayout(new BorderLayout());
		center1.add("Center",txtarea);
		center1.add("North",north);
		center1.add("South",south);

		eastdown.setLayout(new GridLayout(2,3,10,0));
		eastdown.add(new Label(" "));
		eastdown.add(new Label(" "));
		eastdown.add(new Label(" "));
		eastdown.add(lbl2);
		lblinwon.setBackground(Color.pink);
		lblinwon.setForeground(Color.yellow);
		eastdown.add(lblinwon);
		//eastdown.add(btnrename);
		eastdown.add(btnclose);

		east.setLayout(new BorderLayout());
		for(int i=1;i<=20;i++) list.add("");
		east.add("Center",list);
		east.add("South",eastdown);
		east.add("North",lbltitle);

		east2.setLayout(new BorderLayout());
		east2.add("West",new Label(" "));
		east2.add("Center",east);
		east2.add("North",new Label(" "));
		east2.add("South",new Label(" "));

		panel.setLayout(new BorderLayout());
		panel.add("Center",center1);
		panel.add("East",east2);

		add("Center",panel);
		add("East",new Label(" "));
		add("West",new Label(" "));
		
		setTitle("ä�� ���α׷�");
		setBounds(100,100,850,450);
		setVisible(true);
		txtname.requestFocus();

		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});

		txtname.addActionListener(this);
		txtsend.addActionListener(this);
		btnok.addActionListener(this);
		btnconn.addActionListener(this);
		btnclose.addActionListener(this);
	}//end

	public void actionPerformed(ActionEvent e){
		if((e.getSource()==txtname) || (e.getSource()==btnconn))
			connProcess();
		else if((e.getSource()==txtsend) || (e.getSource()==btnok))
			sendProcess();
	//	else if( (e.getSource()==btnok))
	//		System.exit(0);
		else if( (e.getSource()==btnclose))
		 endProcess();
	}//end

	public void endProcess(){
		try{
			out.write(("/q" + txtname.getText()+"\n").getBytes());
			System.out.println("���� : /q" +txtname.getText());
			in.close();
			out.close();
			soc.close();
			
		}catch(Exception ex ) {
		 System.out.println("���� �� ���� " + ex.getMessage());
		}
	  System.exit(0);	
	} //end

	public void connProcess()	{
		try{
			soc=new Socket("192.168.0.62",5555);
			//soc=new Socket("203.236.209.131",5555);
			in=new BufferedReader(new InputStreamReader(soc.getInputStream()));
			//���� ��ü�� �����Ǹ� ����� ��Ʈ���� ����
			out=soc.getOutputStream();

			//���� ���� �� Ŭ���̾�Ʈ���� ������ �̵�
			//���ôٹ������� Ŭ���̾�Ʈ�� �����ϸ� ������ �����ϱ� ����
			out.write((txtname.getText()+"\n").getBytes()); //write�� ����Ʈ ó���ǹǷ�
			System.out.println("���� " + txtname.getText());
		  //txtname.setText("");
			new Thread(this).start(); //���ӵǸ� ������ ���� �ٸ� Ŭ���̾�Ʈ�� �޼��� ȹ�氡��
		}catch(Exception ex){txtarea.append(ex.getMessage());}
	}//end

	public void sendProcess() {
		try{
			String txt = txtsend.getText().trim();
			String  str = txt.substring(1,2);
					
			if(str.equals("q"))
				endProcess();
				
			if(chksay2.getState()==true){
				  out.write((txtsend.getText()+"\n").getBytes());
					System.out.println("����  : " + txtsend.getText());
				}	
			else{
				try{
					String name=list.getSelectedItem();
					out.write(("/s"+name+"-"+txtsend.getText()+"\n").getBytes());
						System.out.println("����  : /s"+name+"-"+txtsend.getText());
					txtarea.append(name+"�Բ� �ͼӸ��� ���޵Ǿ����ϴ�.\n");
				}catch(Exception ex){txtarea.append(ex.getMessage());}
			}
			txtsend.setText(null);
			txtsend.requestFocus();
		}catch(Exception ex){txtarea.append(ex.getMessage());}
	} //end

	public void run(){
		while(true){
			try{
				String msg=in.readLine();
				System.out.println("���� : " + msg);
				
				if(msg==null) return;  //�ƹ� �͵� ���� ���� ���� ���...

					if(msg.charAt(0)=='/'){
						if(msg.charAt(1)=='c'){  //���� ����
								list.replaceItem(msg.substring(2),count);
								count++;  //�����ο� ǥ��
								lblinwon.setText(String.valueOf(count));

								//txtarea�� �Ѹ� ����
								txtarea.append("***"+msg.substring(2)+"���� �����Ͽ����ϴ�***\n");
								txtname.setEnabled(false);
								btnconn.setEnabled(false);
						}	
						else if(msg.charAt(1)=='q'){
						
								String  str = msg.substring(2);
									txtarea.append("***"+msg.substring(2)+"���� �����Ͽ����ϴ�***\n");
									
									for(int i=0;i<list.getItemCount();i++){
									  if(str.equals(list.getItem(i)))
										{
											list.remove(i);
											count--;
											lblinwon.setText(String.valueOf(count));
											break;
										}
									}
									return;
						}
						else if(msg.charAt(1)=='n'){
							String oldname=msg.substring(2, msg.indexOf('-'));
							String newname=msg.substring(msg.indexOf('-')+1);
							txtarea.append("*"+oldname+"���� �̸��� "+newname+"���� ����Ǿ����ϴ�.*\n");

							for(int j=0;j<count;j++){
								if(oldname.equals(list.getItem(j))){
									list.replaceItem(newname, j);
									break;
								}
							}//for end
						}
					} //msg.charAt(0)=='/' end
					else
						txtarea.append(msg+"\n");  
			}catch(Exception ex){txtarea.append(ex.getMessage());}
		}//while��
	} //run end

	public static void main(String[] args){
		new Client();
	}//end
}//class END
