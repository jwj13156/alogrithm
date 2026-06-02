package sliding_window;
import java.util.*;

public class findAnagrams {
	public List<Integer> findAnagrams(String s, String p) {
        int sLen=s.length(),pLen=p.length();
        
        if(sLen<pLen) {
        	return new ArrayList<Integer>();
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        //这道题的关键就是怎么比较异或，这里只有使用字母数组来存储
        //然后滑动窗口保证长度一致，依次比较即可
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        
        for(int i=0;i<pLen;i++) {
        	sCount[s.charAt(i)-'a']++;
        	pCount[p.charAt(i)-'a']++;
        }
        if(Arrays.equals(sCount, pCount)) {
        	ans.add(0);
        }
        
        for(int i=0;i<sLen-pLen;i++) {
        	sCount[s.charAt(i)-'a']--;
        	sCount[s.charAt(i+pLen)-'a']++;
        	
        	if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }

        }
        
        return ans;
    }
}
