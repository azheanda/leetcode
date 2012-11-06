/*
	Recursive back tracking.
	Q1: Why use boolean as the return type in solveSoduku()
	Q2: Restore value of the local invariant
*/

public class Solution {
    public void solveSudoku(char[][] board) {
		solveSudoku(board, 0, 0);
	}

	public boolean solveSudoku(char[][] board, int i, int j) {
		if (i == board.length - 1 && j == board[0].length) 
			return true;
		if (j == board[0].length) 
			return solveSudoku(board, i + 1, 0);
	
		if (board[i][j] == '.') {
			for (char k = '1'; k <= '9'; k++) {
				board[i][j] = k;
				if (validate(board, i, j)){
					if(solveSudoku(board, i, j + 1))
						return true;
				}
			}
		} else
			return solveSudoku(board, i, j + 1);
		board[i][j] = '.';
		return false;
	}

	public char[][] copyBoard(char[][] board) {
		char[][] res = new char[board.length][board[0].length];
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				res[i][j] = board[i][j];
		return res;
	}

	public boolean validate(char[][] board, int i, int j) {
		char val = board[i][j];
		for (int x = 0; x < board.length; x++)
			if (x != i && board[x][j] == val)
				return false;

		for (int y = 0; y < board[0].length; y++)
			if (y != j && board[i][y] == val)
				return false;
		
		int boxRowOffset = (i/3)*3;
		int boxColOffSet = (j/3)*3;
		for(int x=0;x<3;x++)
			for(int y=0;y<3;y++)
				if((boxRowOffset+x!=i && boxColOffSet+y!=j) && board[boxRowOffset+x][boxColOffSet+y]==val)
					return false;

		return val != '.';
	}
}