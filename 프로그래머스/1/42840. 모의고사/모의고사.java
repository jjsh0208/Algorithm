import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] answers) {
        
        // 수포자들의 패턴
        int[][] pettern = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };
        
        // 수포자들의 점수를 저장할 배열포자들의 점수를 저장할 배열
        int[] scores = new int[3];
        
        for(int i = 0 ; i < answers.length; i++){
            for(int j = 0; j < pettern.length; j++){
                if(answers[i] == pettern[j][ i % pettern[j].length])
                    scores[j]++;
            }
        } 
        
        //가장 높은 점수 저장
        int maxScore = Arrays.stream(scores).max().getAsInt();
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < scores.length; i++){
            if(maxScore == scores[i]){
                answer.add(i + 1);
            }
        }
        
        
        return answer.stream().mapToInt(Integer :: intValue).toArray();
    }
}