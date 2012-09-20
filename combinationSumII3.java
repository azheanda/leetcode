/*
    judge small: passed 500ms
    judge large: passed 700ms

*/

import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // Initialization
        Arrays.sort(num);
        int size = num[num.length-1]>target?num[num.length-1]+1:target+1;
        Vector<ArrayList<ArrayList<Integer>>> dp = new Vector<ArrayList<ArrayList<Integer>>>(size);
        for(int i=0;i<size;i++)
            dp.add(new ArrayList<ArrayList<Integer>>());
        
        HashMap<Integer,Integer> count = new HashMap<Integer,Integer>();
        for(int i=0;i<num.length;i++){
            if(count.containsKey(num[i]))
    			count.put(num[i],count.get(num[i])+ 1);
            else
                count.put(num[i],1);
        }
        
            
        //dynamic programming
        for(int i=0;i<target+1;i++)
            for(int j=num.length-1;j>=0;j--)
                if(j+1<num.length && num[j] == num[j+1])
                    continue;
                else if(i-num[j]==0 ){
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[j]);
                    dp.get(i).add(list);                  
                }else if(i-num[j]>0)
                    for(ArrayList<Integer> list:dp.get(i-num[j]))
                        if(list.get(list.size()-1)<=num[j]){
                            int numOfNum=1;
                            for(Integer in:list)
                                if(in==num[j])
                                    numOfNum++;
                            if(numOfNum<=count.get(num[j])){
                                ArrayList<Integer> combo = new ArrayList<Integer>(list);
                                combo.add(num[j]);
                                dp.get(i).add(combo);
                            }
                        }
                    
                
        return dp.get(target);
        
        
    }
}