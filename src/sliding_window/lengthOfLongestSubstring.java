package sliding_window;
import java.util.*;

public class lengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int left =0;int res=0;
        for(int right=0;right<s.length();right++)
        {
        	char c=s.charAt(right);
        	//滑动窗口核心，只要窗口里还有重复的就循环删除，这里也是耗时的核心
        	//后续优化方向可以将这里的循环改为hashmap，去掉循环
        	while(set.contains(c)) {
        		set.remove(s.charAt(left));
        		left++;
        	}
        	
        	set.add(c);
        	res=Math.max(res, right-left+1);
        }
		return res;
    }
}
