package array;
import java.util.*;

public class merge {
	public int[][] merge(int[][] intervals) {
		//按左端点排序
        Arrays.sort(intervals,(o1,o2)->o1[0]-o2[0]);
        
        List<int[]> ans = new ArrayList<>();
        
        for(int[] p:intervals) {
        	int m = ans.size();
        	//查看ans里的右端点和原数组的左端点大小进行判断
        	if(m>0&&p[0]<=ans.get(m-1)[1]) {
        		ans.get(m-1)[1]=Math.max(ans.get(m-1)[1], p[1]);
        	}else {
        		ans.add(p);
        	}
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
