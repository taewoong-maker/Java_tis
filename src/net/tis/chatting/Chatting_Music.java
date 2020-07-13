package net.tis.chatting;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Chatting_Music extends JFrame implements ActionListener {

	private JPanel contentPane;

	JPanel panel;
	JButton btnPlay;
	JButton btnStop;
	JButton btnExit;
	AudioClip clip;
	String url = null;
	private JLabel lblNewLabel_1;

	public Chatting_Music(String url) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Desktop\\image\\image_headphone.png"));

		try {
			this.url = url;
			this.clip = Applet.newAudioClip(new URL(url));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		setTitle("Music_Player");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 200, 323, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 307, 216);
		contentPane.add(panel);
		panel.setLayout(null);

		btnStop = new JButton("Stop");
		btnStop.setForeground(new Color(154, 205, 50));
		btnStop.setBounds(231, 84, 64, 31);
		panel.add(btnStop);

		btnPlay = new JButton("Play");
		btnPlay.setForeground(new Color(154, 205, 50));
		btnPlay.setBounds(231, 29, 64, 31);
		panel.add(btnPlay);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 229, 216);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\image\\images.jpg"));

		btnExit = new JButton("Exit");
		btnExit.setBounds(231, 142, 63, 31);
		panel.add(btnExit);
		btnExit.setForeground(SystemColor.activeCaption);
		btnExit.addActionListener(this);
		btnPlay.addActionListener(this);

		setVisible(true);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		btnStop.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == btnPlay) {
			clip.play();
		}
		if (ob == btnStop) {
			clip.stop();
		}

		if (ob == btnExit) {
			clip.stop();
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		new Chatting_Music("file:\\C:\\Users\\user\\Desktop\\wav\\music1.wav");
	}
}
