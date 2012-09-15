/*
    judge small: passed
    judge large: wrong. In some test cases, the binary number is incredibly big so that
    java primitive data types can not handle.

    Convert binary strings to numbers, add numbers and convert the sum back to binary string
*/

public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return decimalToBinary(binaryToDecimal(a)+binaryToDecimal(b));
    }
    
    public long binaryToDecimal(String binary){
        long deci =0;
        for(int i=binary.length()-1;i>=0;i--)
            if(binary.charAt(i)=='1')
                deci += Math.pow(2,binary.length()-1-i);
        return deci;
    }
    
    public String decimalToBinary(long deci){
        long leftover = deci;
        String binary = "";
        if(leftover==0)
            return "0";
        while(leftover>0){
            long currentbit = leftover%2;
            binary = currentbit+binary;
            leftover = leftover/2;
        }
        return binary;
    }
}