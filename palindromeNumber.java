public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x<0) return false;
        if(x<10) return true;
        
        int divident = 10;
        while(x/divident>=10)
            divident*=10;
        
        int mod = 10;
        boolean yes = true;
        while(divident>=mod){
            yes&=x/divident==x%mod;
            x = x%divident/10;
            divident/=100;    
        }      
        return yes;
    }
}