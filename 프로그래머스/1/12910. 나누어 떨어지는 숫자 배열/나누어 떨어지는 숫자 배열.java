import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, int divisor) {
      
        
        List<Integer> list = new ArrayList<>();
        for(int item : arr){
            if(item % divisor == 0){
                list.add(item);
            }
        }
        
        int[] answer;
        if(list.isEmpty()){
            answer = new int[1];
            answer[0] = -1;
        }else{
            answer = list.stream().mapToInt(Integer :: intValue).sorted().toArray();
        }
          
        return answer;
    }
}