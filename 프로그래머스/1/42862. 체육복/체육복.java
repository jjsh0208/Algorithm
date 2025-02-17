import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // n - lost?
        int answer = 0;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        answer = n - lost.length;
        
        
        // 여벌이 있지만 도난 당한 학생
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] == reserve[j]){
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                    
                }
            }
        }
        
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] + 1 == reserve[j] || lost[i] - 1 == reserve[j]){
                    answer++;
                    reserve[j] = -1;
                    break;
                }        
            }
        }
    
        return answer;
    }
}