public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String[]> res = new ArrayList<String[]>();    
        solveNQueens(0,new int[n],res);
        return res;
    }
    
    public void solveNQueens(int cur, int[] row, ArrayList<String[]> res) {
        int n = row.length;
        if(cur == n)
            res.add(generateSol(row));
        else        
            for(int i=0;i<n;i++){
                boolean ok = true;
                row[cur]=i;
                for(int j=0;j<cur;j++){
                    if(row[cur]==row[j] || cur-row[cur]==j-row[j] || cur+row[cur]==j+row[j])
                    {ok= false;break;}
              }
              if(ok)
                  solveNQueens(cur+1,row,res);
            }       
    }
    
    public String[] generateSol(int[] row){
        int n = row.length;
        String[] sol = new String[n];
        for(int i=0;i<n;i++){
            String line ="";
            for(int j=0;j<n;j++)
                if(j==row[i]) line+="Q";
                else line+=".";
            sol[i] = line;                
        }
        return sol;
    }
}