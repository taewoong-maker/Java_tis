package practice01;

import java.util.Scanner;

public class Practice02 {

	static int cardConvR(int x, int r, char[] d) {//���� x �� r������ ��ȯ�ϴ� �޼ҵ�
		int digits = 0;
		char tmp;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
		do {
			d[digits++]=dchar.charAt(x%r);
			x /= r;
		}while(x!=0);
		
		for(int i =0; i<d.length/2;i++) {
			tmp=d[i];
			d[i]=d[d.length-1-i];
			d[d.length-1-i]=tmp;
		}
		
		return digits;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int no;
		int cd;
		int dno;
		int retry;
		char[] cno = new char[32];
		
		System.out.println("10������ �����ȯ�մϴ�.");
		
		do {
			do {
				System.out.println("��ȯ�ϴ� ���̾ƴ� ���� : ");
				no = sc.nextInt();
			} while (no < 0);
			
			do {
				System.out.println("� ������ ��ȯ�ұ��? (2~36) : ");
				cd = sc.nextInt();
			} while (cd<2 || cd > 36);
			
			dno= cardConvR(no, cd, cno);
//			System.out.println(dno);
			System.out.println( cd + "�����δ� ");
			for(int i=0; i<cno.length;i++) {
				System.out.print(cno[i]);
			}
			System.out.println("�Դϴ�");
			
			System.out.println("�� �� �� �ұ��? (1.�� / 0.�ƴϿ�) : ");
			retry = sc.nextInt();			
		} while (retry==1);
		
	}
	
}
