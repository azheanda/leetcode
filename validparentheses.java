import java.util.Stack;
public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Character> stack = new Stack<Character>();
       
        for(int i=0;i<s.length();i++){
            char cchar = s.charAt(i);
        	if(cchar=='(' || cchar=='[' || cchar=='{')
        		stack.push(cchar);
        	else if(!stack.empty() && (stack.peek() == cchar-1 ||stack.peek()==cchar-2))
        		stack.pop();
        	else 
        		return false;
        }
        
        return stack.empty();
    }
}