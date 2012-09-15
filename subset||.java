/*
    Another line of code added to subset yeilds this solution to subset2.
    However, if this time I don't sort the input set, it would be wrong.
*/

import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cset = new ArrayList<Integer>();
        subsets(num,0,res,cset);
        return res;
        
    }
    
    public void subsets(int[] S, int off, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> cset){
        if(off==S.length){
            res.add(new ArrayList<Integer>(cset));    
            return;                                   
        }                                             
        if(cset.size()==0 || (cset.size()!=0 && cset.get(cset.size()-1)!=S[off])) // When the value we are looking at is the same with
            subsets(S,off+1,res,cset);                                            // the last value in the cset, we skip
        cset.add(S[off]);                                                         // the call in if clause to avoid redundecy.
        subsets(S,off+1,res,cset);
        cset.remove(cset.size()-1);      
    }
}