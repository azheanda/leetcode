public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String lp=s.substring(0,1);
        for(int i=1;i<s.length();i++){
        	String lp1 = find_prolindrome(s,i-1,i);
            String lp2 = find_prolindrome(s,i-1,i+1);
            String longer = lp1.length()>lp2.length()?lp1:lp2;
            lp = longer.length()>lp.length()?longer:lp;
        }
        return lp;

    }
    public String find_prolindrome(String s, int p, int q){
        if( q<s.length() && s.charAt(p)==s.charAt(q)){
            while(p-1>=0 && q+1<s.length() && s.charAt(p-1)==s.charAt(q+1))
        		{p--;q++;}

            return s.substring(p,q+1);
        }
        return "";
    }
}
/*
unrefactored version.

public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String lp=s.substring(0,1);
        for(int i=1;i<s.length();i++){
            int p=i-1;
        	int q=i;

        	if(s.charAt(p)==s.charAt(q)){
        		while(p-1>=0 && q+1<s.length() && s.charAt(p-1)==s.charAt(q+1))
        		{	p--;q++;}

        	    if(q-p+1>lp.length())
        		    lp = s.substring(p,q+1);
        	}
            
            int j=i+1;
        	p=i-1;
        	if(j<s.length() && s.charAt(p)==s.charAt(j)){
				while(p-1>=0 && j+1<s.length() && s.charAt(p-1)==s.charAt(j+1))
        		{	p--;j++;}
			

        	    if(j-p+1>lp.length())
        		    lp = s.substring(p,j+1);
        	}
        }
        return lp;

    }
}

*/

