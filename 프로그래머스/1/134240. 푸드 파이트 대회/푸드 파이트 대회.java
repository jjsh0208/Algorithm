class Solution {
    public String solution(int[] food) {
        
        // 홀수는 필요없음
        // 2를 연산한 값을 food[i] 수 만큼 반복해 추가
        
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i < food.length; i++){
            int cnt = food[i] / 2;
            
            sb.append(String.valueOf(i).repeat(cnt));
        }
        
        String answer = sb + "0";
        answer += sb.reverse();
    
        return answer;
    }
}