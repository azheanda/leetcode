import java.util.*;
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(strs.length==0)
            return "";
        
        for(int i=strs[0].length();i>0;i--){
            boolean isSame= true;
            String prefix = strs[0].substring(0,i);
            for(int j=1;j<strs.length;j++){
        		if(!strs[j].startsWith(prefix)){
        			isSame = false;
                    break;
        		}
        	}
            if(isSame)
                return strs[0].substring(0,i);         
        }
        return "";

    }
}