package net.tis.chatting;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Color;

public class Chatting_LogIn extends JFrame implements ActionListener {

	private JTextField text_id;
	JButton btn_login;
	private JPasswordField text_password;
	boolean a = true;
	
	public Chatting_LogIn() {
		String[][] arr = Chatting_Customer.getcustomers();
		
		JFrame frame = new JFrame("Log-In");
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		Chatting_ImagePanel panel = new Chatting_ImagePanel(
				new ImageIcon("C:/Users/user/Desktop/image/coffee.jpg").getImage());
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		btn_login = new JButton("Log-In");
		btn_login.setFont(new Font("HY견고딕", Font.BOLD, 17));
		btn_login.setBounds(536, 152, 184, 45);
		panel.add(btn_login);		
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i<arr.length;i++) {
				if (text_id.getText().equals(arr[i][0])
						&&Arrays.equals(text_password.getPassword(),
						arr[i][1].toCharArray()))
					a=false;				
				}//for end
				if(a==false) {
					frame.setVisible(false);
					new Chatting_GUIChatClient();
				}else {
					JOptionPane.showMessageDialog(null,
							"아이디 혹은 비밀번호가 틀렸습니다.");
				}
			}
		});
		
		JLabel label_id = new JLabel("ID");
		label_id.setForeground(new Color(139, 69, 19));
		label_id.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		label_id.setBounds(508, 60, 24, 33);
		panel.add(label_id);

		JLabel label_password = new JLabel("PassWord");
		label_password.setForeground(new Color(139, 69, 19));
		label_password.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		label_password.setBounds(457, 103, 76, 33);
		panel.add(label_password);

		text_id = new JTextField();
		text_id.setBounds(536, 61, 184, 33);
		panel.add(text_id);
		text_id.setColumns(10);
		
		text_password = new JPasswordField();
		text_password.setBounds(536, 102, 184, 38);
		panel.add(text_password);
		text_password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i<arr.length;i++) {
				if (text_id.getText().equals(arr[i][0])&&Arrays.equals(text_password.getPassword(), arr[i][1].toCharArray()))
					a=false;				
				}//for end
				if(a==false) {
					frame.setVisible(false);
					new Chatting_GUIChatClient();
				}else {
					JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호가 틀렸습니다.");
				}
			}
		});
		
		JButton btn_login_1 = new JButton("Sign-Up");
		btn_login_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Chatting_SignUp();
			}
		});
		btn_login_1.setFont(new Font("HY견고딕", Font.BOLD, 17));
		btn_login_1.setBounds(536, 207, 184, 45);
		panel.add(btn_login_1);

		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Chatting_LogIn();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
