package practice01;

public class Practice04_02 {

	public static void main(String[] args) {
		
		int counter = 0;
		int[]prime = new int[500];
		int mcount=0;
		prime[mcount++]=2;
		prime[mcount++]=3;
		
		for (int n=5;n<=1000;n=n+2) {
			boolean flag=false;
			for(int i=1;prime[i]*prime[i]<=n;i++) {
				counter+=2;
				if(n%prime[i]==0) {
					flag=true;
					break;
				}				
			}
			if(flag==false) {
//				System.out.println(n);
				prime[mcount++]=n;
				counter++;
			}				
		}
//		for(int i:prime)
//			System.out.println(i);
		System.out.println("°ö¼À°ú ³ª´°¼ÀÀ» ¼öÇàÇÑ È½¼ö : " +counter);
	}
	
}
