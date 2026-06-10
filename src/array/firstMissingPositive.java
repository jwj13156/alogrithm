package array;

public class firstMissingPositive {
	public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 步骤1：把所有 <=0 或 >n 的数，改为 n+1（无效数不参与标记）
        for(int i=0;i<n;i++) {
        	if(nums[i]<=0||nums[i]>n) {
        		nums[i]=n+1;
        	}
        }
        
     // 步骤2：用负数标记 数字存在（原地哈希）
        for(int i=0;i<n;i++) {
        	
        	int x= Math.abs(nums[i]);
        	// x 在 1~n 范围内，说明是有效正整数
        	if(x<=n) {
        		// 这里不能随便写一个负数，会影响别的值
        		// 用「数字正负号」做存在标记，保留数值本身，只修改符号
        		nums[x-1]=-Math.abs(nums[x-1]);
        	}
        }
        
     // 步骤3：找第一个正数，下标+1就是缺失的最小正整数
        for(int i=0;i<n;i++) {
        	if(nums[i]>0) {
        		return i+1;
        	}
        }
        
        return n+1;
    }
}
