public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = new ArrayList<String>();
        
        for(int i=1;i<s.length();i++){
             if(!isValid(s,0,i))
                    break;
            
            for(int j=i+1;j<s.length();j++){
                if(!isValid(s,i,j))
                    break;
                
                for(int k=j+1;k<s.length();k++){
                    if(!isValid(s,j,k))
                        break;
                    
                    if(isValid(s,k,s.length()))
                        res.add(s.substring(0,i)+"."+s.substring(i,j)+"."+s.substring(j,k)+"."+s.substring(k,s.length()));
                }  
            }
        }
        return res;
        
        
    }
    
    public boolean isValid(String s, int b, int e){
        if( e-b>3 ||(e-b>=2 && s.charAt(b)=='0') )    return false;
        int num = Integer.parseInt(s.substring(b,e));
	    return num>=0 && num <=255;
    }
}