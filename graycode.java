/*
	judge small : passed 516ms
	judge larget : passed 596ms
*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> res = new ArrayList<Integer>();
        ArrayList<Integer> preres = new ArrayList<Integer>();

        res.add(0);
        if(n==0)
            return res;
        
       	res.add(1);
        if(n==1)
        	return res;

        for(int i=2;i<=n;i++){
        	for(Integer j:res)
        		preres.add(j);
        	Collections.reverse(res);
        	for(Integer j:res)
        		preres.add((int)(j+Math.pow(2,i-1)));

        	res = preres;
        	preres= new ArrayList<Integer>();
		}
		return res;
    }
}