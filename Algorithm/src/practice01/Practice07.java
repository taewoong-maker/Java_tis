package net.tis.day13;

import java.util.Scanner;

public class Practice07 {
	static int seqSearch(int[] a, int n, int key) {
		int i = 0;
		
//		while(true) {
//			if(i==n)
//				return -1;
//			if(a[i]==key)
//				return 1;
//			i++;
//		}
		for(i=0; i<a.length;i++) {
			if(a[i]==key) {
				return 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("��ڼ� : ");
		int num = sc.nextInt();
		int[]x = new int[num];
		
		for(int i = 0; i < num ; i++) {
			System.out.print("x["+i+"] : ");
			x[i] = sc.nextInt();
		}
		
		System.out.print("�˻��� �� : ");
		int ky = sc.nextInt();
		int idx = seqSearch(x, num, ky);
		
		if(idx==-1)
			System.out.println("�� ���� ��Ұ� �����ϴ�.");
		else
			System.out.println(ky+"��(��) x["+idx+"]�� �ֽ��ϴ�.");
	}
}

