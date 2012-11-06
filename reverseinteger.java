public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sign = x>=0?1:-1;
        x = x>=0? x:-x;
        
        int res = 0;
        
        while(x!=0){
            res *= 10;
            res +=x%10;
            x = x/10;            
        }
            
        res = res*sign;
        
        return res;
    }
}