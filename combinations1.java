/*
    judge small: passed 470ms
    judge large: passed 620ms

*/

public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
            
        return find_combine(n,k);        
    }
    
    public ArrayList<ArrayList<Integer>> find_combine(int n,int k){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(k==0 || k>n)
            res.add(new ArrayList<Integer>());
        else if (k==n){
            ArrayList<Integer> combo = new ArrayList<Integer>();
            for(int i=1;i<=n;i++)
                combo.add(i);
            res.add(combo);
        }else{
            for(ArrayList<Integer> list : find_combine(n-1,k))
                res.add(list);
            for(ArrayList<Integer> list : find_combine(n-1,k-1)){
                ArrayList<Integer> combo = new ArrayList<Integer> ();
                for(Integer i : list)
                    combo.add(i);
                combo.add(n);
                res.add(combo);
            }
        }
        return res;
    }
}