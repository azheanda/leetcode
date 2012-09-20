/*
    The idea is to iterate each value in num, swap it with the first value, and add it to the permutations of the rest of the collection.
    for example, say input is a,b,c.  First, add a to (b,c) and (c,b), then add b to (a,c) and (c,a), at last, add c to (a,b) and (b,a).
*/


public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return permute(num,0);
    }
    
    public ArrayList<ArrayList<Integer>> permute(int[] num,int level){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(level==num.length-1){
           ArrayList<Integer> combo = new ArrayList<Integer>();
           combo.add(num[level]);
           result.add(combo);
           return result;
        }
        
        for(int i=level;i<num.length;i++){
            swap(num,i,level);
            for(ArrayList<Integer> combo:permute(num,level+1)){
                combo.add(num[level]);
                result.add(combo);
            }        
            swap(num,i,level);
        }
        return result;
        
    }
    public void swap(int[] num,int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}