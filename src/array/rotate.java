package array;
import java.util.*;

public class rotate {
	public void rotate(int[] nums, int k) {
		//很简单，直接使用索引偏移即可解决
        int n = nums.length;
        k=k%n;
        int[] newNums = new int[n];
        for(int i=0;i<n;i++) {
        	newNums[(i+k)%n]=nums[i];
        }
        System.arraycopy(newNums, 0, nums,0,n);
    }
}
