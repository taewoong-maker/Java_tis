package net.tis.day13;

import java.util.Scanner;

public class Practice08 {
	
	static int binSearch(int[]a, int n, int key) {
		int pl = 0;
		int pr = n-1;
		do {
			int pc=(pl+pr)/2;
			if(a[pc]==key)
				return pc;
			else if(a[pc]<key) {
				pl=pc+1;
			}else
				pr=pc-1;
		}while(pl<=pr);
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("요솟수 : ");
		int num = sc.nextInt();
		int[]x = new int[num];
		System.out.print("x[0] : ");
		x[0]=sc.nextInt();
		
		for(int i=1;i<x.length;i++) {
			do {
				System.out.print("숫자를 입력하세요 : ");
				x[i]=sc.nextInt();
			}while(x[i]<x[i-1]);
		}
		System.out.print("검색할 값 : ");
		int ky = sc.nextInt();
		
		int idx = binSearch(x, num, ky);
		if(idx==-1) {
			System.out.println("검색 할 값이 존재하지 않습니다.");
		}else {
			System.out.println("찾는 값은 x[" + idx +"]입니다.");
		}
	}
}

