public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function    
        boolean isNines = true;
        for(int i=0;i<digits.length;i++)
            if(digits[i]!=9){
                isNines = false;
                break;
            }
            
        if(isNines){
            int[] result = new int[digits.length+1];
            result[0] = 1;
            return result;
        }
        
        int[] result = digits;
                  
        int p = result.length-1;
        int increment=1;
        
        while(p>=0 && increment>0){
            int sum = digits[p]+increment;
            result[p] = sum%10;
            increment = sum/10;
            p--;
        }
        return result;
    }
}