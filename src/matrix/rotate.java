package matrix;

public class rotate {
	public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        //将坐标转换为（i，j）->(j,n-1-i)即可
        //第一步现将（i，j）->(j,i)
        for(int i=0;i<n;i++) {
        	for(int j=i+1;j<n;j++) {
        		int tem=matrix[i][j];
        		matrix[i][j]=matrix[j][i];
        		matrix[j][i]=tem;
        	}
        }
        //第二步，（j,i）->(j,n-1-i)
        //行标已确定，逐行翻转列标即可
        for(int i=0;i<n;i++) {
        	int left=0,right=n-1;
        	while(left<right) {
        		int tem=matrix[i][left];
        		matrix[i][left]=matrix[i][right];
        		matrix[i][right]=tem;
        		left++;
        		right--;
        	}
        }
        
    }
}
