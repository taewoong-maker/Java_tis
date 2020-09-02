package practice02;

public class MaximumSubArryay {
	public static void main(String[] args) {
		int[]nums = {-2,1,-3,4,-1,2,0,-5,4};
		MaximumSubArryay ms = new MaximumSubArryay();
		System.out.println(ms.solve(nums));
		System.out.println(maxSubArray(nums));
	}
	
	public int solve(int[] nums) {
		int maxnum=0;
		
		for(int i=1; i<=nums.length;i++) {			
			maxnum = Math.max(sum(nums,i),maxnum);
			System.out.println("i : " + i + "  maximum : " + maxnum);
		}				
		return maxnum;
	}
	
	public int sum(int[] nums, int a) {	
		
		int max=0;
		
		for(int i=0;i<nums.length-a+1;i++) {
			int cnt=0;
			int sum=0;
			
			while(cnt<a) {
				sum+=nums[i];
				i++;
				cnt++;
			}			
			
			max=Math.max(max, sum);
			i=i-a;
		}
		return max;
	}
	
	public static int maxSubArray(int[] nums) {
		int newSum = nums[0];
		int max = nums[0];
		
		for(int i=1; i<nums.length;i++) {
			newSum=Math.max(nums[i], newSum+nums[i]);
			max=Math.max(newSum, max);
		}
		return max;
	}
}
