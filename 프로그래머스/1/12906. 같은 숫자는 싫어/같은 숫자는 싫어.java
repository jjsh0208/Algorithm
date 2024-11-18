import java.util.Stack;


public class Solution {
    public Stack<Integer> solution(int []arr) {
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i : arr){
            if(stack.isEmpty()  || stack.peek() != i){
                stack.push(i);
            }
        }
    
        
        return stack;
    }
}