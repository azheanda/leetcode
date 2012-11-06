/* My cousin's idea. Not bad, isn't it?*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int N = board.length;
        int[] rows = new int[N];
        int[] cols = new int[N];
        int[] cubes = new int[N];

        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++){
    			if(board[i][j]!='.'){
    				int b = (i/3)*3+j/3;
    				int offset = board[i][j] - '1';

    				if(offset>8 || offset<0) return false;
    				if((rows[i] & (1<<offset))!=0) return false;
    				if((cols[j] & (1<<offset))!=0) return false;
    				if((cubes[b] & (1<<offset))!=0) return false;

	        		rows[i] |= 1 << offset;
 		       		cols[j] |= 1 << offset;
 		       		cubes[b] |= 1 << offset;

        		}
        	}
        return true;
    }
}