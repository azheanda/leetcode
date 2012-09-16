/*
    judge small: passed
    judge large: passed

    Improved version from AddBinary2.java

*/
public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int ap=a.length()-1;
        int bp=b.length()-1;
        int count = 0;
        String sum ="";
        
        while(ap>=0||bp>=0||count>0){
            if(ap>=0 && a.charAt(ap)=='1')
                count++;
            if(bp>=0 && b.charAt(bp)=='1')
                count++;
            sum = count%2+sum;
            count = count/2;
            ap--;bp--;
        }
        return sum;
        
    }
    
    
}