package two_points;
import java.util.*;


public class threeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		//三数之和的解决方法是固定一个数，使用双指针从数组的两端计算这三个数之和
		List<List<Integer>> list= new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		int len=nums.length;
		for(int i=0;i<len;i++) {
			int x=nums[i];
			if(x>0) break;
			//去除冗余情况
			if(i>0&&nums[i]==nums[i-1]) continue;
			int L=i+1;
			int R=len-1;
			
			while(L<R) {
				int sum=x+nums[L]+nums[R];
				if(sum==0) {
					list.add(Arrays.asList(x,nums[L],nums[R]));
					while(L<R&&nums[L]==nums[L+1]) L++;
					while(L<R&&nums[R]==nums[R-1]) R--;
					L++;
					R--;
				}else if(sum<0) {
					L++;
				}else {
					R--;
				}
			}
		}
		
		
		
		return list;
    }
}
