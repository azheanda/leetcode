public class Solution {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i=0, j=A.length-1;
        
        while(i<=j){
            if(A[i]==elem)
                swap(A,i,j--);
            else 
                i++;
        }
        return j+1;
    }
    
    public void swap(int[] A,int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}