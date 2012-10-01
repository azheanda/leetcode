public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
            String[] words = s.split(" ");
            return words.length==0?0:words[words.length-1].length();
    }
}