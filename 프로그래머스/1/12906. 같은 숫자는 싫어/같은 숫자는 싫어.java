import java.util.Stack;

public class Solution {
    public Stack<Integer> solution(int []arr) {
     
        Stack<Integer> stack = new Stack<>();
        
        stack.push(arr[0]);
        for(int i : arr){
            if(i != stack.peek()){
                stack.push(i);
            }
        }
        return stack;
    }
}