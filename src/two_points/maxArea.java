package two_points;
import java.util.*;

public class maxArea {
	
	public int maxArea(int[] height) {
		int ans=0,x=0,y=height.length-1;
		while(x<y) {
			int res=(y-x)*Math.min(height[x], height[y]);
			ans=Math.max(ans,res);
			if(height[x]<height[y]) {
				x++;
			}else {
				y--;
			}
		}
		return ans;
    }
}
