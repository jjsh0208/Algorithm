import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            // 현재 스택이 비어있지 않고, 현재 문자와 스택의 맨 위 문자가 같으면 
            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop(); //맨 위 문자 제거
            }
            else{
                stack.push(c); // 현재 문자 추가
            }
        }
        
    
        return stack.isEmpty() ? 1: 0; // 스택이 비었으면 1 아니면 2
    }
}