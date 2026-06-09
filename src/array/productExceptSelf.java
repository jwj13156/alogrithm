package array;

public class productExceptSelf {
	public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res= new int[n];
        res[0]=1;int right=1;//两个边界值，因为是乘积所以为1
        //得到左边的乘积
        for(int i=1;i<n;i++) {
        	res[i]=res[i-1]*nums[i-1];
        }
        
        
        //从后往前得到除了自身以外的数组乘积
        for(int i=n-1;i>=0;i--) {
        	res[i]*=right;
        	right*=nums[i];
        }
        return res;
	}
}
