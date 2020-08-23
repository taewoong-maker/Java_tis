package practice01;

import java.util.Scanner;

public class Practice06 {

	static final int VMAX = 21;
	
	static class PhyscData{
		String name;
		int height;
		double vision;
		
		public PhyscData(String name, int height, double vision) {
			this.name = name;
			this.height = height;
			this.vision = vision;
		}
	}
	
	static double aveHeight(PhyscData[] dat) {
		double sum = 0;
		
		for(int i = 0; i < dat.length; i++ ) {
			sum += dat[i].height;			
		}
		return sum/dat.length;
	}
	
	static void distVision(PhyscData[] dat, int[] dist) {
		int i=0;
		dist[i]=0;
		for(i=0;i<dat.length;i++) {
			if(dat[i].vision>=0.0 && dat[i].vision<=VMAX/10.0)
				dist[(int)(dat[i].vision*10)]++;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		PhyscData[] x = {
				new PhyscData("a", 162, 0.3),
				new PhyscData("b", 173, 0.7),
				new PhyscData("c", 175, 2.0),
				new PhyscData("d", 171, 1.5),
				new PhyscData("e", 168, 0.4),
				new PhyscData("f", 174, 1.2),
				new PhyscData("g", 169, 0.8),
		};
		
		int[] vdist = new int[VMAX];
		
		System.out.println("신체검사 리스트");
		System.out.println("이름     키     시력");
		System.out.println("--------------");
		for(int i = 0; i< x.length; i++) {
			System.out.println(x[i].name + "   " + x[i].height + "   " + x[i].vision + "   ");
		}
		System.out.println();
		System.out.printf("평균 키 : %5.1fcm\n", + aveHeight(x));
		
		distVision(x, vdist);
		
		for(int i=0;i<vdist.length;i++) {
//			System.out.println(i/10.0 + "~ : " + vdist[i] + "명");
			System.out.print(i/10.0 + "~ : ");
			for(int j=0;j<vdist[i];j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
}
