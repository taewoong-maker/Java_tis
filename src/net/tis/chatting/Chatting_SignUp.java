package net.tis.chatting;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;



public class Chatting_SignUp extends JFrame {

//	ImagePanel welcomePanel = new ImagePanel(new ImageIcon("¿ÃπÃ¡ˆ∆ƒ¿œ∞Ê∑Œ").getImage());
	
	private JPanel contentPane;
	
	private JTextField txtname, txtbirth, txtage, txtphone, txtid, txtpassword;
	private JLabel lblAge_2;

	public static void main(String[] args) {
		new Chatting_SignUp();
	}

	public Chatting_SignUp() {
		
		JFrame frame = new JFrame("Sign-Up");
		frame.setLocationRelativeTo(null);
		
		frame.setBounds(800, 200, 720, 480);
		frame.setVisible(true);
		
		
		Chatting_ImagePanel panel = new Chatting_ImagePanel(new ImageIcon("C:/Users/user/Desktop/image/coffee_signup.jpg").getImage());
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("µ∏øÚ", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(56, 158, 112, 34);
		panel.add(lblNewLabel);
		
		JLabel lblAge = new JLabel("PhoneNumber");
		lblAge.setFont(new Font("±º∏≤", Font.BOLD, 14));
		lblAge.setForeground(Color.WHITE);
		lblAge.setBounds(357, 160, 112, 32);
		panel.add(lblAge);
		
		JLabel lblAge_1 = new JLabel("Age");
		lblAge_1.setFont(new Font("±º∏≤", Font.BOLD, 14));
		lblAge_1.setForeground(Color.WHITE);
		lblAge_1.setBounds(357, 246, 112, 32);
		panel.add(lblAge_1);
		
		JLabel lblGender = new JLabel("BirthDay");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("±º∏≤", Font.BOLD, 14));
		lblGender.setBounds(56, 246, 112, 32);
		panel.add(lblGender);
		
		txtname = new JTextField();
		txtname.setBounds(145, 161, 136, 32);
		panel.add(txtname);
		txtname.setColumns(10);
		
		txtage = new JTextField();
		txtage.setColumns(10);
		txtage.setBounds(481, 248, 136, 32);
		panel.add(txtage);
		
		txtbirth = new JTextField();
		txtbirth.setColumns(10);
		txtbirth.setBounds(145, 248, 136, 32);
		panel.add(txtbirth);
		
		txtphone = new JTextField();
		txtphone.setColumns(10);
		txtphone.setBounds(481, 158, 136, 32);
		panel.add(txtphone);
		
		JComboBox gender = new JComboBox(new String[] {"Male", "Female"});
		gender.setBounds(145, 333, 136, 32);
		panel.add(gender);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idtxt = txtid.getText();
				String passwordtxt = txtpassword.getText();
				String nametxt = txtname.getText();
				String agetxt = txtage.getText();
				String phonetxt = txtphone.getText();
				String Birthtxt = txtbirth.getText();
				String gendertxt = gender.getSelectedItem().toString();
				Chatting_Customer.creatCustomer(idtxt, passwordtxt, nametxt, phonetxt, gendertxt, agetxt, Birthtxt);
				JOptionPane.showMessageDialog(null,"Your Data has been saved");
				setVisible(false);
			}
		});
		btnNewButton.setBounds(267, 411, 174, 32);
		panel.add(btnNewButton);
		
		lblAge_2 = new JLabel("Gender");
		lblAge_2.setFont(new Font("±º∏≤", Font.BOLD, 14));
		lblAge_2.setForeground(Color.WHITE);
		lblAge_2.setBounds(56, 333, 112, 32);
		panel.add(lblAge_2);
		
		txtpassword = new JTextField();
		txtpassword.setColumns(10);
		txtpassword.setBounds(481, 65, 136, 32);
		panel.add(txtpassword);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("±º∏≤", Font.BOLD, 14));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(357, 65, 112, 32);
		panel.add(lblPassword);
		
		txtid = new JTextField();
		txtid.setColumns(10);
		txtid.setBounds(145, 64, 136, 32);
		panel.add(txtid);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("±º∏≤", Font.BOLD, 14));
		lblId.setBounds(56, 61, 112, 34);
		panel.add(lblId);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
