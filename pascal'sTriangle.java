public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
         ArrayList<ArrayList<Integer>> res = new  ArrayList<ArrayList<Integer>>();
         generate(numRows,0,res);
         return res;
         
    }
    
    public void generate(int numRows,int cur, ArrayList<ArrayList<Integer>> res) {
        if(numRows==0 || cur==numRows) return;
        if(cur==0){
            ArrayList<Integer> c = new ArrayList<Integer>();
            c.add(1);
            res.add(c);
        }if(cur==1){
            ArrayList<Integer> c = new ArrayList<Integer>();
            c.add(1);
            c.add(1);
            res.add(c);            
        }
        if(cur>1){
            ArrayList<Integer> p = res.get(res.size()-1);
            ArrayList<Integer> c = new ArrayList<Integer>();
            c.add(1);
            for(int i=0;i<p.size()-1;i++)
                c.add(p.get(i)+p.get(i+1));
            c.add(1);
            res.add(c); 
        }
        generate(numRows,cur+1,res);
            
    }
}