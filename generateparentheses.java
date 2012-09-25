public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<String> preres = new ArrayList<String>();

        if(n==0)
            return res;
        
        res.add("(");
        for(int i=1;i<2*n;i++){
            for(String str:res)
                if(str.length()==i){
                    if(countChar(str,"(")<n)
                        preres.add(str+"(");
                    if(countChar(str,")")<countChar(str,"("))
                        preres.add(str+")");
                }
            res = preres;
            preres = new ArrayList<String>();
                    
            
        }
        return res;
    }
    
    public int countChar(String str,String chr){
        return str.length()-str.replace(chr,"").length();
    }
}