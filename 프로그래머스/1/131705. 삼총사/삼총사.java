class Solution {
    public int solution(int[] number) {
        
        // 1. 요소 3개를 더해 0을 찾으면 멈춤
        // 2. 3개를 더한것이 0인것 카운트 샘
        // 3. while?
        int answer = 0;
        
        for(int i = 0; i < number.length; i++){
            for(int j = i + 1; j < number.length; j++){
                for(int k = j + 1; k < number.length; k++){
                    if(number[i] + number[j] + number[k] == 0)
                        answer++;
                }
            }
        }
        
    
        return answer;
    }
}