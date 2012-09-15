/*
    The lame reasom why I sort the input set before calculating the subset is 
    because of those stupid online judge test cases.
    
    The idea is to look at each value in the input set one by one and 1)first recursive call--put it in the previously generated subsets 2)second--don't. 
    This is recursive back tracking problem. Very important:within one recursive call, restore the global invariant in between the recursive calls.

*/

import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cset = new ArrayList<Integer>();
        subsets(S,0,res,cset);
        return res;
        
    }
    
    public void subsets(int[] S, int off, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> cset){
        if(off==S.length){
            res.add(new ArrayList<Integer>(cset));    //When add one subset to the result set, we can't just say "res.add(cset)" because
            return;                                   //cset is just a pointer to the ArrayList object(the program would modify cset later on).
        }                                             //So we have to invode the copy constructor instead.
        cset.add(S[off]);
        subsets(S,off+1,res,cset);
        cset.remove(cset.size()-1);      // Very important--restore the global invariant for next recursive calls.
        subsets(S,off+1,res,cset);
    }
}