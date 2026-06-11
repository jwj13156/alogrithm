package matrix;
import java.util.*;

public class setZeroes {
	public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        List<Integer> rowList = new ArrayList<>();
        List<Integer> colList = new ArrayList<>();
        int start=0;
        //很简单的一道题，先找到对应值为零的数组下标，再将对应的行和列置为零
        for(int i=0;i<matrix.length;i++) {
        	for(int j=0;j<matrix[i].length;j++) {
        		if(matrix[i][j]==0) {
        			rowList.add(i);
                    colList.add(j);
        		}
        	}
        }
        
        for (int r : rowList) {
            for (int j = 0; j < n; j++) {
                matrix[r][j] = 0;
            }
        }
        for (int r : colList) {
            for (int j = 0; j < n; j++) {
                matrix[j][r] = 0;
            }
        }
    }
}
