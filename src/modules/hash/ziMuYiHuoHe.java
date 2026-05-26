package modules.hash;

import java.util.*;

public class ziMuYiHuoHe {
	public static void main(String[] args) {
		
	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
		//key 用相同模式，value用对应的字符串列表，最后将value转为对应的集合即可
		Map<String, List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++) {
        	int[] counter=new int[26];
        	String s=strs[i];
        	for(int j=0;j<s.length();j++) {
        		counter[s.charAt(j)-'a']++;
        	}
        	StringBuilder sb= new StringBuilder();
        	//将每个字符串拆分为相同的模式a3b1等
        	for(int j=0;j<26;j++) {
        		if(counter[j]!=0) {
        			sb.append((char)('a'+j));
        			sb.append(counter[j]);
        		}
        	}
        	
        	String key=sb.toString();
        	if(!map.containsKey(key)) {
        		map.put(key, new ArrayList<>());
        	}
        	map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
