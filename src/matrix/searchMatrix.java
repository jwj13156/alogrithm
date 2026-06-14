package matrix;

import java.util.*;

public class searchMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix==null||matrix.length==0||matrix[0].length==0) {
			return false;
		}
		//这道题要找到核心规律
		//每行的元素从左到右升序排列。
		//每列的元素从上到下升序排列
		//就可以知道右上角是该行最大值，该列最小值，拿目标值和他对比
		//比他小就减小列数，比他大就增加行数
		int n=matrix.length;
		int m=matrix[0].length;
        int  col= m-1;
        int row=0;
        while(row < n&&col>=0) {
        	if(target<matrix[row][col]) {
        		col--;
        	}else if(target>matrix[row][col]) {
        		row++;
        	}else {
        		return true;
        	}
        }
        return false;
    }
}
