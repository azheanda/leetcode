/* judge samll:passed
   judge large:Time limit exceeded
   time complexity: O(n^2logn)
*/
import java.util.Arrays;
import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if(num.length<3)
            return result;
        
        Arrays.sort(num);        
        for(int i=0;i<num.length-2;i++)                  
            for(int j=i+1;j<num.length-1;j++)
                if(binarySearch(num,j+1,num.length-1,-num[i]-num[j])>=0){
                    ArrayList<Integer> triplet = new ArrayList<Integer>(3);
                         triplet.add(num[i]);
                         triplet.add(num[j]);
                         triplet.add(-num[i]-num[j]);
                         if(!result.contains(triplet))
                            result.add(triplet);
                }          
        return result;
    }
    
    public static int binarySearch(int[] num,int p,int r, int val){
        if(num==null || num.length==0 || val <num[p] || val>num[r] || p>r)
            return -1;
        int m = (p+r)/2;
        if( val ==num[m])
            return m;
        else if (val>num[m])
            return binarySearch(num,m+1,r,val);
        else
            return binarySearch(num,p,m-1,val);
    }
        
}

