package net.tis.day13;

import java.util.Scanner;

public class Practice07_03 {
	static int seqSearch(int[] a, int n, int key, int[] idx) {
		int i = 0;
		int cnt = 0;
		
		for(i=0; i<a.length;i++) {
			if(a[i]==key) {
				idx[cnt]=i;
				cnt++;
			}							
		}		
		return cnt;
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
		int index[]=new int[num];
		int idx = seqSearch(x, num, ky, index);
		
		if(idx==0)
			System.out.println("�� ���� ��Ұ� �����ϴ�.");
		else {
			System.out.println(ky+"��(��) x["+idx+"]�� �ֽ��ϴ�.");
			for(int i =0;i<idx;i++) {
				System.out.print(index[i] + " ");
			}
		}					
	}
}

