package practice01;

import java.util.Scanner;

public class Practice03 {

	static int cardConvR(int x, int r, char[] d) {//숫자 x 를 r진수로 변환하는 메소드
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
		
		System.out.println("10진수를 기수변환합니다.");
		
		do {
			do {
				System.out.println("변환하는 음이아닌 정수 : ");
				no = sc.nextInt();
			} while (no < 0);
			
			do {
				System.out.println("어떤 진수로 변환할까요? (2~36) : ");
				cd = sc.nextInt();
			} while (cd<2 || cd > 36);
			
			dno= cardConvR(no, cd, cno);
//			System.out.println(dno);
			System.out.print( cd + "진수로는 ");
			for(int i=dno-1; i>=0;i--) {
				System.out.print(cno[i]);
			}
			System.out.println("입니다");
			
			System.out.println("한 번 더 할까요? (1.예 / 0.아니오) : ");
			retry = sc.nextInt();			
		} while (retry==1);
		
	}
	
}
