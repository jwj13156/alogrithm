package modules.hash;

import java.util.*;

public class addInTwoNumber {
	
	public static void main(String[] args) {
	}
	
    public int[] twoSum(int[] nums, int target) {
        Map<Integer , Integer> map =new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++) {
        	//将需要的值作为key，对应下标索引作为value
        	if(map.containsKey(target-nums[i])) {
        		return new int[] {
        			map.get(target-nums[i]),i	
        		};
        	}
        	map.put(nums[i], i);
        }
        return new int[]{};	
    }
}


