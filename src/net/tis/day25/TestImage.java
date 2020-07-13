package net.tis.day25;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

//PPT�Ҽ����� 429ó�� ����
//class TestImage extends JFrame{
// this.addKeyListener(new ~~(){  })
// 
//}

class TestImage extends JFrame implements KeyListener {
	private static final long serialVersionUID = 1L; //����üũ �����ϸ� ���,��������
	
	
	Image img; //�ʵ�=�������
	int img_x=200, img_y=200; //�ʵ�=�������
	
	public TestImage() {//������
//		Toolkit tk=Toolkit.getDefaultToolkit();
//		img=tk.getImage("C:/Mtest/fish.gif");
		img=Toolkit.getDefaultToolkit().getImage("C:/Mtest/kuma.gif");
		
		Container ct=this.getContentPane();
		ct.setBackground(Color.lightGray);
		setBounds(200,200,650,550);
		setVisible(true);
		addKeyListener(this);; //Ű���ȴ���üũ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//������end
			
	public void paint(Graphics g) {
		super.paint(g);//�ڵ����� ȭ�� Ŭ����. �ּ�ó���ϸ� ȭ���� ��� ���� ����
		g.setColor(Color.red);
		g.setFont(new Font("Comic San MS",Font.BOLD,15));
		g.drawString("("+img_x+","+img_y+")",img_x,img_y);
		g.drawImage(img, img_x, img_y, this);
	}//end
	
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		switch (keycode) {
			case KeyEvent.VK_UP:	
				img_y -= 10; if(img_y<=50){img_y=550;} 
				break;
			case KeyEvent.VK_DOWN:	
				img_y += 10; if(img_y>=550){img_y=50;}  
				break;
			case KeyEvent.VK_LEFT:	
				img_x -= 10; if(img_x<=-30){img_x=650;}
				break;
			case KeyEvent.VK_RIGHT:	
				img_x += 10; if(img_x>=650){img_x=10;} 
				break;
			case KeyEvent.VK_ESCAPE:
				System.out.println("�׸��̵�ȭ�������մϴ� �����մϴ�");
				System.exit(1); 
		    break;
		 }
		repaint(); //repaint( )�޼ҵ�����ص� ���ΰ�ħ��
	}//end
		
	public void keyReleased(KeyEvent arg0) {		}
	public void keyTyped(KeyEvent arg0) {			}
		
	public static void main(String[] args) {
	  new TestImage();
	}//main end
}//TestImage class END=======================
