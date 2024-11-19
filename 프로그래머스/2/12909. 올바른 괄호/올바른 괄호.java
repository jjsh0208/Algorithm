import java.util.Stack;

class Solution {
    boolean solution(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        char[] chars = s.toCharArray();
        
        for(char c : chars){
            if(c == '('){
                stack.push(c);
            }else{
                if(stack.isEmpty() || stack.pop() == c){
                    return false;
                }
            }
        }
        
    
        return stack.isEmpty();
    }
}