import java.util.HashMap;
import java.util.ArrayDeque;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        s += s;
        
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        
    
        A:for(int i = 0 ; i < n; i++){
            ArrayDeque<Character> stack = new ArrayDeque<>();
            
            // i(시작위치) 부터 원본 문자열의 길이인 n개까지 올바른 괄호 문자열인지 확인
            for(int j = i ; j < i + n; j++){
                char c = s.charAt(j);
                 if(!map.containsKey(c)){
                        stack.push(c);
                }else{
                    if(stack.isEmpty() || !stack.pop().equals(map.get(c)))
                        continue A;
                }
            }
           
            if(stack.isEmpty()) answer++;
            
            
        }
        
        return answer;
    }
}