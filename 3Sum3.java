/* judge samll:passed
   judge large: passed mostly，around 1000-1100 ms, sometimes time limit exceeded
   time complexity: O(n^2)
*/

import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(num.length<3)
            return ret;
        
        Arrays.sort(num);        
        for(int i=0;i<num.length-2;i++){                  
            int p=i+1, q=num.length-1;
            while(p<q){
                if(num[p]+num[q]==-num[i]){
                         ArrayList<Integer> triplet = new ArrayList<Integer>(3);
                         triplet.add(num[i]);
                         triplet.add(num[p]);
                         triplet.add(num[q]);
                         if(!ret.contains(triplet))
                            ret.add(triplet);
                         p++;    q--;  // add "q--" here to avoid more duplicates
                }
                else if (num[p]+num[q]>-num[i])
                    q--;
                else
                    p++;
            }
        }
        return ret;
        
    }
}

