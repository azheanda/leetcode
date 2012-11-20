public class Solution {
    int total=0;
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        total=0;
        solveNQueens(0,new int[n]);
        return total;
    }
    
     
    public void solveNQueens(int cur, int[] row){
        int n = row.length;
        if(cur == n)
            total++;
        else        
            for(int i=0;i<n;i++){
                boolean ok = true;
                row[cur]=i;
                for(int j=0;j<cur;j++){
                    if(row[cur]==row[j] || cur-row[cur]==j-row[j] || cur+row[cur]==j+row[j])
                    {ok= false;break;}
              }
              if(ok)
                  solveNQueens(cur+1,row);
            }       
    }
    
}