public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] res = new int[2];
        for(int i=0;i<numbers.length;i++)
            for(int j=i+1;j<numbers.length;j++)
        		if(numbers[i]+numbers[j]==target){
        			res[0]=i+1;
        			res[1]=j+1;
        			break;
        		}

        return res;
    }
}