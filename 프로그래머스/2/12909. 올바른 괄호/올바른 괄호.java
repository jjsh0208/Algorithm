import java.util.Stack;

class Solution {
    boolean solution(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char item = s.charAt(i);
            
            if(item == '('){
                stack.push(item);
            }else{
                if(stack.isEmpty() || stack.pop() == item){
                    return false;  
                } 
            } 
              
        }
        
        return stack.isEmpty();
    }
}