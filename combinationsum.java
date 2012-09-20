/*
    Dynamic programming.
    It is extended from the climbing stairs problem.

    judge small:476ms
    judge large:940ms

*/


import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(candidates.length==0)
            return result;
        
        Arrays.sort(candidates);
        
        int size = target>candidates[candidates.length-1]? target+1:candidates[candidates.length-1]+1;
        
        Vector<ArrayList<ArrayList<Integer>>> dp = new Vector<ArrayList<ArrayList<Integer>>>(size);
        for(int i=0;i<size;i++)
            dp.add(new ArrayList<ArrayList<Integer>>());
        for(int i=0;i<candidates.length;i++){
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(candidates[i]);
            dp.get(candidates[i]).add(list);
        }

        
        for(int j=candidates[0];j<dp.size();j++)
            for(int i=candidates.length-1;i>=0;i--)
                if(j-candidates[i]>=0 && dp.get(j-candidates[i])!=null)
                    for(ArrayList<Integer> list : dp.get(j-candidates[i]))
                        if(list.get(list.size()-1)<=candidates[i]){
                            ArrayList<Integer> combo = new ArrayList<Integer>(list);
                            combo.add(candidates[i]);
                            dp.get(j).add(combo);
                        }                     
        return dp.get(target);   
    }
}