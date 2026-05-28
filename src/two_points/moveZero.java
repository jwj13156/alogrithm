package two_points;

public class moveZero {
	public void moveZeroes(int[] nums) {
		if(nums==null||nums.length==0) return ;
		int j=0;
		//将非零的往前移后面的全部值为零
        for(int i=0;i<nums.length;i++) {
        	if(nums[i]!=0)
        	nums[j++]=nums[i];
        }
        
        for(int i=j;i<nums.length;i++) {
        	nums[i]=0;
        }
    }
}
