import java.util.ArrayList;
import java.util.Collections;

class Solution {
    
    int[][] pattern = {
        {1, 2, 3, 4, 5, 1, 2, 3, 4, 5}, // 5
        {2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5}, // 8
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5} // 10
    };
    
    
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] grades = new int[3];
        
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == pattern[0][i % 5]) grades[0]++;
            if(answers[i] == pattern[1][i % 8]) grades[1]++;
            if(answers[i] == pattern[2][i % 10]) grades[2]++;
        }
        
        int maxScore = Math.max(grades[0], Math.max(grades[1], grades[2]));

        for(int i = 0; i < grades.length; i++){
            if(maxScore == grades[i]) answer.add(i + 1);
        }  
        
        Collections.sort(answer); 
    
        return answer.stream().mapToInt(i -> i).toArray();
    }
}