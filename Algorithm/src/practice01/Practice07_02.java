package net.tis.day13;

import java.util.Scanner;

public class Practice07_02 {
	static int seqSearchSen(int[] a, int n, int key) {
		int i = 0;
		a[n]=key;//보초를 추가
		System.out.print(" |");
		for(int j=0;j<a.length;j++)
			System.out.print(j + " ");
		
		System.out.println();
		System.out.println("--+-----------------------");
		for(i=0;i<a.length-1;i++) {			
			System.out.print(" |");
			for(int p=0;p<a.length;p++) {
				if(i==p)
					System.out.print("*");
				else
					System.out.print("  ");				
			}
			
			System.out.println();
			System.out.print(i + "|");
			for(int p=0;p<a.length-1;p++) {
				System.out.print(a[p] + " ");				
			}
			System.out.println();
			if(a[i]==key) 
				break;
		}
		return i==n?-1:i;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int num = sc.nextInt();
		int[]x = new int[num+1];
		
		for(int i = 0; i < num ; i++) {
			System.out.print("x["+i+"] : ");
			x[i] = sc.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		int ky = sc.nextInt();
		int idx = seqSearchSen(x, num, ky);
		
		if(idx==-1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println(ky+"은(는) x["+idx+"]에 있습니다.");
	}
}

