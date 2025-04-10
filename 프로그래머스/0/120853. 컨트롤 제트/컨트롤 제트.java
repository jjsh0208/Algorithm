import java.util.Stack;


class Solution {
    public int solution(String s) {
        
        Stack<Integer> stack = new Stack<>();
        
        String[] n = s.split(" ");
        
        for(int i = 0; i < n.length; i++){
            if(n[i].equals("Z")){
                stack.pop();
            }else{
                stack.push(Integer.parseInt(n[i]));
            }
        }
        
        return stack.stream().mapToInt(Integer::intValue).sum();
    }
}