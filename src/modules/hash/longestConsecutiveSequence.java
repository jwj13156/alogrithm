package modules.hash;
import java.util.*;

public class longestConsecutiveSequence {
	
	
	public int longestConsecutive(int[] nums) {
		if(nums==null||nums.length==0) return 0;
		Set<Integer> set= new HashSet<>();
		for(int num:nums) {
			set.add(num);
		}
		
		int ans=0;
		
		for(int num:set) {
			//核心：只从「连续序列的起点」开始遍历(num-1不存在，就是起点)
			if(!set.contains(num-1)) {
				int curNum=num;
				int len=1;
				
				//向后找连续数字
				while(set.contains(curNum+1)) {
					len++;
					curNum++;
				}
				ans=Math.max(ans,len);
			}
		}
		return ans;
	}
}
