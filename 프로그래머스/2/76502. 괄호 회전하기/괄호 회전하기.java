import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int solution(String s) {
        
        // 괄호를 확인할 HashMap;
        HashMap<Character,Character> map = new HashMap<>();
        
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        
        int n = s.length(); // 원본 문자열의 길이 저장
        s += s; // 원본 문자열을 이어 붙여서 2번 나오도록한다.
        int answer = 0; // 결과값
        
        // 확인할 문자열의 시작 인덱스를 0부터 n(문자열 길이) 까지 이동
        A:for(int i = 0; i < n; i++){
            Stack<Character> stack = new Stack<>();
            
            for(int j = i; j < i + n; j++){
                char c = s.charAt(j);
                
                // 해시맵 안에 해당 키가 없다면 여는 괄호다
                // push 해준다.
                if(!map.containsKey(c)){
                    stack.push(c);
                }else{
                    // 해시맵 안에 존재하면 닫는 괄호다
                    // 스택이 비었거나 짝지 맞지않으면 내부 for문 종료하고 for문 A로 이동한다.
                    if(stack.isEmpty() || !stack.pop().equals(map.get(c)))
                        continue A;
                }
            }
            
            if(stack.isEmpty()){
                answer++;
            }
        }
        
        
        return answer;
    }
}