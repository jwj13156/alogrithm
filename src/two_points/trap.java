package two_points;
import java.util.*;
public class trap {
	public int trap(int[] height) {
        int len = height.length,res=0;
        int left=0,right=len-1;
        int leftMax=height[left],rightMax=height[right];
        left++;right--;
        //从两端开始使用双指针
        //基础:当前位置水量是由比较矮的一边的最高点减去当前位置高度得到的
        //所以要决定两端开始那边的最高处最高，这样水就不可能溜出去
        //水量是由矮处决定的
        while(left<right) {
        	leftMax=Math.max(leftMax, height[left]);
        	rightMax=Math.max(height[right], rightMax);
        	
        	if(leftMax<rightMax) {
        		res+=leftMax-height[left];
        		left++;
        	}else {
        		res+=rightMax-height[right];
        		right--;
        	}
        }
        
        return res;
    }
}
