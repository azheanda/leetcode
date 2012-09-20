/*
    Although this is a very easy problem, it takes a while before me figuring out the exact right algorithm.
*/


public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String current="1", next="";
        if(n==1)
            return current;
        
        for(int i=2;i<=n;i++){
            int count=1;
            for(int j=0;j<current.length();j++){
                if(j>0) 
                    if(current.charAt(j)==current.charAt(j-1))
                        count++;
                    else{
                        next=next+count+current.charAt(j-1);
                        count=1;
                    }          
                if(j == current.length()-1)
                    next=next+count+current.charAt(j);
                
                                    
            }
            current = next;
            next = "";
        }
        
        return current;
        
    }
}