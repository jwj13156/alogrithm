package sub_string;
import java.util.*;

public class maxSlidingWindow {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums==null ||nums.length==0 || k==0) {
			return new int[0];
		}
		//记得区分deque和res
		
		// 初始化双端队列，存储【数组下标】
		Deque<Integer> deque = new LinkedList<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int index=0;
        for(int i=0;i<n;i++) {
        	// 1. 维护单调递减：删除队尾 比当前数小的元素
            // 这些元素永远不可能成为最大值，直接删掉
        	while(!deque.isEmpty()&&nums[i]>=nums[deque.peekLast()]) {
        		deque.pollLast();
        	}
        	
        	// 2. 把当前元素的下标 加入队尾
        	deque.offerLast(i);
        	
        	// 3. 清除窗口外的元素：队头下标 超出窗口左边界，直接删除
        	while(deque.peekFirst()<=i-k) {
        		deque.pollFirst();
        	}
        	
        	 // 4. 窗口形成后，队头就是当前窗口最大值，加入结果
        	if(i>=k-1) {
        		res[index++]=nums[deque.peekFirst()];
        	}
        }
        
        
        return res;
    }
}
