package practice02;

public class MoveZeros {

	public static void main(String args[]) {
		
		int[] nums = { 0, 3, 2, 0, 8, 5,0 };
		int currentIndex = 0;
		int a = nums.length-1;
		
		//첫번�?!!
		
//		for(int i=nums.length-1;i>=0;i--) {
//			if(nums[i]==0) {
//				currentIndex=i;
//				for(int j=currentIndex;j<nums.length-1;j++) {
//					nums[j]=nums[j+1];
//				}
//				nums[a]=0;
//				a--;
//			}
//		}
		
		//?��번째!!
		for(int i=0;i<nums.length;i++) {
			if(nums[i] != 0) {
				nums[currentIndex]=nums[i];
				currentIndex++;
			}
		}
		
		for(int i = currentIndex;i<nums.length;i++) {
			nums[i]=0;
		}

		for(int i:nums)
			System.out.println(i);
	}
}
