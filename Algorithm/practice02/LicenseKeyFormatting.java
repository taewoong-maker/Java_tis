package practice02;

public class LicenseKeyFormatting {

	public static void main(String[] args) {
	
		String str1 = "8F3Z-2e-9-w";
		String str2 = "8-5g-3-J";
		
		int k = 4;
		LicenseKeyFormatting lk = new LicenseKeyFormatting();
		System.out.println(lk.solve2(str1, k));
		System.out.println(lk.solve2(str2, k));
	}
	
	public String solve(String a, int b) {
		String result=a;
		
		result=result.replace("-", "");
		result=result.toUpperCase();

		result=result.substring(0,result.length()-b) +"-"+ result.substring(result.length()-b);
		
		return result;
	}
	
	public StringBuilder solve2(String a, int b) {
		String result=a;
		
		result=result.replace("-", "");
		result=result.toUpperCase();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<result.length();i++) {
			sb.append(result.charAt(i));
		}
		sb.insert(result.length()-b, "-");
		
		return sb;
	}
}
