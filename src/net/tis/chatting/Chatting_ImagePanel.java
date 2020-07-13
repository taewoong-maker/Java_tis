package net.tis.chatting;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

class Chatting_ImagePanel extends JPanel {
	   
	   private Image img;
	   
	   public Chatting_ImagePanel( Image img ) {
	      this.img = img;
	      setSize( new Dimension(img.getWidth(null), img.getHeight(null)));
	      setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
	      setLayout(null);
	   }
	   // �̹����� ���� ���̸� ���Ѵ�.
	   public int getWidth() {
	      return img.getWidth(null);
	   }
	   // �̹����� ���� ���̸� ���Ѵ�.
	   public int getHeight() {
	      return img.getHeight(null);
	   }
	   
	   public void paintComponent( Graphics g ) {
	      g.drawImage( img, 0, 0, null);
	   }
	}
