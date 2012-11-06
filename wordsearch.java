public class Solution {
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int N = board.length;
        int M = board[0].length;
        for(int i=0;i<N;i++)
            for(int j=0;j<M;j++)
                if(board[i][j]==word.charAt(0)){
        			if(bfs(i,j,board,word,0))
        				return true;
            	}
        return false;
    }

    public boolean bfs(int i, int j, char[][] board, String word, int p){
    	if(p==word.length())	return true;
      
        int N = board.length;
        int M = board[0].length;

        if(i>=0 && i<N && j>=0 && j<M  && board[i][j]==word.charAt(p)){
            char temp = board[i][j];
            board[i][j] =  '#';
            p++;
          	if(bfs(i,j+1,board,word,p) || bfs(i+1,j,board,word,p) ||
        		bfs(i,j-1,board,word,p) || bfs(i-1,j,board,word,p)) 
    	    	return true;
            board[i][j] = temp;
    	}
      
    
    	return false;
    }
}





/*
	This solution doesn't work because even though I try to use a HashSet to keep track of those 
	elements that are previouly visited, the "!set.contains(new Pair(i,j))" doesn't really work.
	This contains method use equals method to check if the input object is equal to any of the object
	in the set.Since equals method check both the identifier and state of objects, it doesn't work 
	for this case.  

	There are online posts that suggest using vector<vector<Integer>>. That will do I suppose.
*/


import java.util.*;
public class Solution {
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int N = board.length;
        int M = board[0].length;
        HashSet<Pair> set = new HashSet<Pair>();
        for(int i=0;i<N;i++)
            for(int j=0;j<M;j++)
                if(board[i][j]==word.charAt(0)){
            		set.add(new Pair(i,j));
        			if(dfs(i,j,board,word,1,set))
        				return true;
        			set.clear();
            	}
        return false;
    }

    public boolean dfs(int i, int j, char[][] board, String word, int p, HashSet<Pair> set){
    	if(p==word.length())	return true;
      
    	if(solve(i,j+1,board,word,p,set)) return true;
    	if(solve(i+1,j,board,word,p,set)) return true;
    	if(solve(i,j-1,board,word,p,set)) return true;
    	if(solve(i-1,j,board,word,p,set)) return true;

    	return false;
    }

    public boolean solve(int i, int j, char[][] board,String word, int p, HashSet<Pair> set){
    	Pair temp = null;
    	int N = board.length;
        int M = board[0].length;

    	if(i>=0 && i<N && j>=0 && j<M && !set.contains(new Pair(i,j)) && board[i][j]==word.charAt(p)){
            temp= new Pair(i,j);
        	set.add(temp);
            if(dfs(i,j,board,word,p+1,set)) 
            	return true;
    	}
        if(temp!=null) 
        	set.remove(temp);
        return false;
    }

    class Pair{
    	int i;
    	int j;
    	Pair(int i,int j){ this.i=i;this.j=j;}
    }
}