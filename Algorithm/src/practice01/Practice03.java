package practice01;

import java.util.Scanner;

public class Practice03 {

	static int cardConvR(int x, int r, char[] d) {//���� x �� r������ ��ȯ�ϴ� �޼ҵ�
		int digits = 0;
		int tmp;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		System.out.println(r+"|"+"\t"+x);
		
		do {
			System.out.println(" "+"+ ---------");
			d[digits++]=dchar.charAt(x%r);
			tmp=x%r;
			x /= r;
			if(x!=0) {
				System.out.println(r+"|"+"\t"+x+"  "+"--- "+tmp);
			}else {
				System.out.println(" "+"\t"+x+"  "+"--- "+tmp);
			}								
		}while(x!=0);
//		System.out.println(x + " --- "+x%r);
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
			System.out.print( cd + "�����δ� ");
			for(int i=dno-1; i>=0;i--) {
				System.out.print(cno[i]);
			}
			System.out.println("�Դϴ�");
			
			System.out.println("�� �� �� �ұ��? (1.�� / 0.�ƴϿ�) : ");
			retry = sc.nextInt();			
		} while (retry==1);
		
	}
	
}