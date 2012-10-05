import java.util.Stack;
public class Solution {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max=0;
        int start = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                stack.push(i);
            else{
                if(!stack.empty() && s.charAt(stack.peek())=='('){
                    stack.pop();
                    max = Math.max(max,stack.empty()?i+1:i-stack.peek());
                }else
                    stack.push(i);           
            }           
        }      
        return max;
    }
}