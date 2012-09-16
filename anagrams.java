/*
    The idea is to use a hashmap to collect groups of anagrams.
    The way to determine whether two strings are anagrams is to sort them and see if sorted strings are identical.
*/

import java.util.*;
public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function        
        ArrayList<String> result = new ArrayList<String>();
        
        HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        
        for(String str : strs){
            char[] tempstr= str.toCharArray();
            Arrays.sort(tempstr);
            String sortedstr = new String(tempstr);
            if(map.containsKey(sortedstr)){    
                map.get(sortedstr).add(str);
            }else{
                ArrayList<String> list = new ArrayList<String>();
                list.add(str);
                map.put(sortedstr,list);          
            }        
        }
        
        for(ArrayList<String> list:map.values())
            if(list.size()>1)
                for(String str : list)
                    result.add(str);
                    
        return result;
    }
}