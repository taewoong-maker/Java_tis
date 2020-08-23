package practice01;

public class Practice04_01 {

	public static void main(String[] args) {
		
		int counter = 0;
		int[]prime = new int[500];
		int mcount=0;
		prime[mcount++]=2;
		
		for (int n=3;n<=1000;n=n+2) {
			int i;
			for(i=1;i<mcount;i++) {
				counter++;
				if(n%prime[i]==0) {
					break;
				}				
			}
			if(mcount==i) {
//				System.out.println(n);
				prime[mcount++]=n;
			}				
		}
//		for(int i:prime)
//			System.out.println(i);
		System.out.println("³ª´°¼ÀÀ» ¼öÇàÇÑ È½¼ö : " +counter);
	}
	
}
