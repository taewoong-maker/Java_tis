package practice01;

import java.util.Scanner;

public class Practice02 {

	static int cardConvR(int x, int r, char[] d) {//숫자 x 를 r진수로 변환하는 메소드
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
			System.out.println( cd + "진수로는 ");
			for(int i=0; i<cno.length;i++) {
				System.out.print(cno[i]);
			}
			System.out.println("입니다");
			
			System.out.println("한 번 더 할까요? (1.예 / 0.아니오) : ");
			retry = sc.nextInt();			
		} while (retry==1);
		
	}
	
}
