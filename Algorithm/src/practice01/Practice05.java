package practice01;

import java.util.Scanner;

public class Practice05 {

	static int[][] mdays= {
			{31,28,31,30,31,30,31,31,30,31,30,31},
			{31,28,31,30,31,30,31,31,30,31,30,31}
	};
	
	static int isLeap(int year) {
		return(year % 4==0 && year % 100 != 0 || year % 400 == 0)?1:0;
	}
	
	static int dayOfYear(int y, int m, int d) {
//		int days=d;
//		for(int i=1;i<m;i++)
//			days += mdays[isLeap(y)][i-1];
//		return days;
		while(m>1) {			
			d += mdays[isLeap(y)][m-2];
			m--;
		}
		return d;
	}
	
	static int leftDayOfYear(int y, int m, int d) {
		int days=0;
		while(m<=12) {			
			days += mdays[isLeap(y)][m-1];
			m++;
		}
		return (days-d);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int retry;
		
		System.out.println("�� �� ��� �ϼ��� ���մϴ�.");
		do {
			System.out.print("�� : "); int year = sc.nextInt();
			System.out.print("�� : "); int month = sc.nextInt();
			System.out.print("�� : "); int day = sc.nextInt();
			
			System.out.printf("�� �ش� %d�� ���ҽ��ϴ�.\n", leftDayOfYear(year, month, day));
			System.out.print("�� �� �� �ұ��? (1.��/2.�ƴϿ�) : ");
			retry = sc.nextInt();
		}while(retry==1);
	}
	
}
