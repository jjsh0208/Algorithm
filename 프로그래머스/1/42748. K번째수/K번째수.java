import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
       
        // Arrays.copyOfRange(원본배열,시작,끝)
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < commands.length; i++){
            int start = commands[i][0];
            int end = commands[i][1];
            int target = commands[i][2];
            
            int[] rangeArray = Arrays.copyOfRange(array,start -1 ,end);
            
            Arrays.sort(rangeArray); 
     
            answer.add(rangeArray[target - 1]);
            
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}