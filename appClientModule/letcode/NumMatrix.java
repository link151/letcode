package letcode;

public class NumMatrix {

	int[][] dp;
    /*public NumMatrix(int[][] matrix) {
    	if(matrix!=null && matrix.length!=0)
    		dp=new int[matrix.length+1][matrix[0].length+1];
    	
    	for(int i=0;i<matrix.length;i++){
    		int sum=0;
    		for(int j=0;j<matrix[0].length;j++){
    			sum+=matrix[i][j];
    			dp[i+1][j+1]=dp[i][j+1]+sum;
    		}
    	}
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
    	int ans=dp[row2+1][col2+1]-dp[row2+1][col1]-dp[row1][col2+1]+dp[row1][col1];
		return ans;
    }*/
    
/*    public NumMatrix(int[][] matrix){
    	if(matrix!=null && matrix.length!=0)
    		dp=new int[matrix.length+1][matrix[0].length+1];
    	
    	for(int i=1;i<=matrix.length;i++){
    		for(int j=1;j<=matrix[0].length;j++){
    			dp[i][j]=dp[i][j-1]+dp[i-1][j]-dp[i-1][j-1]+matrix[i-1][j-1];
    		}
    	}
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
		return dp[row2+1][col2+1]-dp[row2+1][col1]-dp[row1][col2+1]+dp[row1][col1];
    }*/
    
    int[][] rowSum;
    public NumMatrix(int[][] matrix){
    	if(matrix!=null && matrix.length!=0)
    		rowSum=new int[matrix.length][matrix[0].length+1];
    	
    	for(int i=0;i<matrix.length;i++){
    		for(int j=1;j<=matrix[0].length;j++)
    			rowSum[i][j]+=rowSum[i][j-1]+matrix[i][j-1];
    	}
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
    	int ans=0;
    	for(int i=row1;i<=row2;i++){
    		ans=ans+rowSum[i][col2+1]-rowSum[i][col1];
    	}
		return ans;
    }
    
}
