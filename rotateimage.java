public class Solution {
    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        rotate(matrix,0);
    }   
    
    public void rotate(int[][] matrix, int layer){
        int n = matrix.length;
    	if(layer<=n/2){
    		for(int j=layer;j<n-layer-1;j++){
    			swap(matrix,layer,j,j,n-layer-1);
    			swap(matrix,layer,j,n-layer-1,n-j-1);
    			swap(matrix,layer,j,n-j-1,layer);
    		}
    		rotate(matrix,layer+1);
    	}
    }

    public void swap(int[][] matrix,int i,int j,int x,int y){
    	int temp = matrix[i][j];
    	matrix[i][j] = matrix[x][y];
    	matrix[x][y] = temp;
    }
}