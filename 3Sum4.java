/* judge samll:passed
   judge large: passed mostly，around 700-800 ms
   time complexity: O(n^2)

   Based on 3Sum3.java, applied the avoid-redundency method by Chi Su.
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
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (num.length < 3)
            return ret;

        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i = increment(num, i)) {
            int p = i + 1, q = num.length - 1;
            while (p < q) {
                if (num[p] + num[q] == -num[i]) {
                    ArrayList<Integer> triplet = new ArrayList<Integer>(3);
                    triplet.add(num[i]);
                    triplet.add(num[p]);
                    triplet.add(num[q]);
                    
                    ret.add(triplet);
                    p = increment(num, p);
                    q = decrement(num, q);
                } else if (num[p] + num[q] > -num[i])
                    q = decrement(num, q);
                else
                    p = increment(num, p);
            }
        }

        return ret;

    }



}
