package matrix;
import java.util.*;

public class spiralOrder {
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix == null||matrix.length==0) return list;
        
        int top=0;int bottom=matrix.length-1;
        int left=0;int right=matrix[0].length-1;
        
        //模拟题，知道四个边界递减
        while(true) {
        	//从左到右查找
        	for(int i=left;i<=right;i++) {
        		list.add(matrix[top][i]);
        	}
        	if(++top>bottom) break;
        	//从上到下查找
        	for(int i=top;i<=bottom;i++) {
        		list.add(matrix[i][right]);
        	}
        	if(--right<left) break;
        	//从右到左查找
        	for(int i=right;i>=left;i--) {
        		list.add(matrix[bottom][i]);
        	}
        	if(--bottom<top) break;
        	//从下到上查找
        	for(int i=bottom;i>=top;i--) {
        		list.add(matrix[i][left]);
        	}
        	if(++left>right) break;
        }
        return list;
        
    }
}
