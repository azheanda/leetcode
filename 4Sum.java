/* judge samll:passed
   judge large: passed mostly，around 1000-1100 ms
   time complexity: O(n^3)

   Based on 3Sum4.java
*/

import java.util.*;

public class Solution {
    public int increment(int[] num, int index) {
        int newindex = index + 1;
        while(newindex < num.length && num[newindex] == num[index])
            newindex ++;
        return newindex;
    }

    public int decrement(int[] num, int index) {
        int newindex = index - 1;
        while(newindex >= 0  && num[newindex] == num[index])
            newindex --;
        return newindex;
    }
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (num.length<4)
            return ret;

        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i = increment(num, i)) 
            for(int j=i+1;j<num.length -2;j = increment(num,j)) {
                int p = j + 1, q = num.length - 1;
                while (p < q) {
                    if (num[p] + num[q] +num[i]+num[j]==target) {
                        ArrayList<Integer> quadruplet = new ArrayList<Integer>(3);
                        quadruplet.add(num[i]);
                        quadruplet.add(num[j]);
                        quadruplet.add(num[p]);
                        quadruplet.add(num[q]);                   
                        ret.add(quadruplet);
                        p = increment(num, p);
                        q = decrement(num, q);
                    } else if (num[p] + num[q] +num[i] +num[j]>target)
                        q = decrement(num, q);
                    else
                        p = increment(num, p);
            }
        }

        return ret;

    }



}
