package array;
import java.util.*;

public class maxSubArray {
	public int maxSubArray(int[] nums) {
		//基础动态规划题，dp[i]为以i为偏移量的最大子数组
		//dp[i]的两个选择就是dp[i-1]+nums[i],或者重新开一个子数组nums[i]
        int[] dp= new int[nums.length+1];
        dp[0]=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++) {
        	dp[i]=Math.max(dp[i-1]+nums[i], nums[i]);
        	max=Math.max(dp[i],max);
        }
        return max;
    }
}
