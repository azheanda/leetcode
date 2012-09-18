/*
    judge small :passed 560ms
    judge large :time limit exceeded sometimes 950ms

    This is a bad solution in terms of performance.

*/

import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        combinationSum2(num,target,0,new ArrayList<Integer>(),result);
        return result;
    }
    
    public void combinationSum2(int[] num, int target, int pointer, ArrayList<Integer> currentCombo,ArrayList<ArrayList<Integer>> result) {
        if(target==0){
            if(!result.contains(currentCombo))
                result.add(new ArrayList<Integer>(currentCombo));
            return;
        }else if(target<0 || pointer<0)
            return;
        
        for(int i=pointer;i<num.length;i++){
            currentCombo.add(num[i]);
            combinationSum2(num,target-num[i],i+1,currentCombo,result);
            currentCombo.remove(currentCombo.size()-1);
        }
    
    }
}