/*
    judge small: passed
    judge large: passed

    This solution is correct but the code is messy.
*/
public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] aChars=a.toCharArray();
        char[] bChars=b.toCharArray();
        int ap=aChars.length-1;
        int bp=bChars.length-1;
        int step = 0;
        String sum ="";
        
        while(ap>=0||bp>=0||step>0){
            if(ap>=0||bp>=0){
                int temp =0;
                if(ap>=0 && bp>=0)
                    temp = step+Integer.parseInt(aChars[ap]+"")+Integer.parseInt(bChars[bp]+"");       
                else if(ap>=0)
                    temp = step+Integer.parseInt(aChars[ap]+"");
                else
                    temp = step+Integer.parseInt(bChars[bp]+"");
                switch(temp){
                    case 0: sum = "0"+sum;step=0;break;
                    case 1: sum = "1"+sum;step=0;break;
                    case 2: sum = "0"+sum;step=1;break;
                    case 3: sum = "1"+sum;step=1;break;

                }
            }
            else if(step==1){
                sum= "1"+sum;
                step=0;
            }
                
            ap--;bp--;
        }
        return sum;
        
    }
    
    
}