package practice02;

public class PlusOne {
	
	public static void main(String[] args) {
		PlusOne po = new PlusOne();
		int [] a1= {1,2,3};
		int [] a2= {9,9,9};

		for(int i: po.solve(a2))
			System.out.print(i + "  ");
	}
	
	public int[] solve(int[] digits) {
		
		int index = digits.length-1;
		while(digits[index]==9) {
			digits[index]=0;
			index--;
			if(index<0)
				break;
		}
		if(index<0) {
			digits=new int[digits.length+1];
			digits[0]=1;
		}else {
			digits[index]=digits[index]+1;
		}
		
		return digits;
	}
}
