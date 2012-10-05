/*
    Applied some syntax sugar in creating the hashmap.
    It's called double curly brace initialization.

    It means you're creating an anonymous subclass and the code within 
    the double braces is basically a constructor. It's often used to add 
    contents to collections because Java's syntax for creating what are 
    essentially collection constants is somewhat awkward.

*/

import java.util.HashMap;
public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<String> preres = new ArrayList<String>();
        res.add("");

        for(int i=0;i<digits.length();i++){
            for(String str: res)
                String letters = map.get(digits.charAt(i));
                for(int j=0;j<letters.length();j++)
                    preres.add(str+letters.charAt(j));
            
            res = preres;
            preres = new ArrayList<String>();
        }      
        return res;
    }
    
    static final HashMap<Character,String> map = new HashMap<Character,String>(){{
        put('2',"abc");
        put('3',"def");
        put('4',"ghi");
        put('5',"jkl");
        put('6',"mno");
        put('7',"pqrs");
        put('8',"tuv");
        put('9',"wxyz");
    
    }} ;
}