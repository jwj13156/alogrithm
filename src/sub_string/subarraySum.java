package sub_string;
import java.util.*;


public class subarraySum {
	public int subarraySum(int[] nums, int k) {
        int res=0;
        //k=pre[i]-pre[j]  => pre[j]=pre[i]-k
        //所以只需要往前看看前面有多少个前缀和等于当前前缀和-k就有多少个
        //子数组的和等于k
        Map<Integer,Integer> map=new HashMap<>();
      //map表示前缀和0，出现1次
        map.put(0, 1);
        int preSum =0;
        for(int num:nums) {
        	preSum+=num;
        	if(map.containsKey(preSum-k)) {
        		res+=map.get(preSum-k);
        	}
        	//补充当前前缀和出现次数
        	map.put(preSum, map.getOrDefault(preSum, 0)+1);
        }
		
		
		return res;
    }
}
