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
    public int threeSumClosest(int[] num,int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int ret=num[0]+num[1]+num[2];
    
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i = increment(num, i)) {
            int p = i + 1, q = num.length - 1;
            while (p < q) {
                int sum = num[p] + num[q] + num[i];
                if (sum ==target) 
                   return target;
                else if(Math.abs(sum-target)<Math.abs(ret-target))
                   ret = sum;
                   
                if (sum>target)
                    q = decrement(num, q);
                else
                    p = increment(num, p);
            }
        }

        return ret;

    }



}
