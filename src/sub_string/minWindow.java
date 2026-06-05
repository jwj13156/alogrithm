package sub_string;
import java.util.*;

public class minWindow {
	public String minWindow(String s, String t) {
		if(s.length()<t.length()) {
			return "";
		}
        int[] windows=new int[128];
        int[] need = new int[128];
        for(char c :t.toCharArray()) {
        	need[c]++;
        }
        
        int left =0,right=0;
        int count=0,start=0,minLen=Integer.MAX_VALUE;
        //计算有多少个不同的字符，当count等于unique时表示全部子串符合
        int unique = 0;
        for(int i=0; i<128; i++){
            if(need[i] > 0) unique++;
        }
        //开始滑动窗口
        while(right < s.length()) {
        	char c= s.charAt(right);
        	right++;
        	
        	if(need[c]>0) {
        		windows[c]++;
        		if(windows[c]==need[c]) {
        			count++;
        		}
        	}
        	//关键，开始缩小左边界，寻找最小子串
        	while(count==unique) {
        		if(right-left<minLen) {
        			minLen=right-left;
        			start=left;
        		}
        		
        		char d=s.charAt(left);
        		left++;
        		
        		if(need[d]>0) {
        			if(windows[d]==need[d]) {
            			count--;
            		}
        			windows[d]--;
        		}
        	}
        }
        return minLen==Integer.MAX_VALUE ? "" : s.substring(start,start+minLen);
    }
}
