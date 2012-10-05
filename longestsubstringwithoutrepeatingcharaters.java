import java.util.*;
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int count=0;
        HashSet<Character> substring = new HashSet<Character>();
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(!substring.contains(s.charAt(j)))
                    substring.add(s.charAt(j));
                else{
                    count = Math.max(substring.size(),count);          
                    substring.clear();
                    break;
                }
                
                if(j==s.length()-1)
                    count = Math.max(substring.size(),count);          

            } 
        }
        return count;
        
    }
}