public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int a = m-1;
        int b = n-1;
        int c = m+n-1;
        
        while(c>=0){
            if(a>=0 && b>=0)
                A[c] = A[a]>=B[b]?A[a--]:B[b--];
                
            else if(a<0)
                A[c] = B[b--];
            
            else
                A[c] = A[a--];
                
            c--;
            
        }       
        
    }
}