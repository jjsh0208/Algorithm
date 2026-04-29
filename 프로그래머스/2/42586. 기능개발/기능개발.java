import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < progresses.length; i++){
            int day = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);
            
            queue.add(day);    
        }
        
        while(!queue.isEmpty()){
            int cnt = 1;
            int day = queue.poll();
            
            while(!queue.isEmpty() && queue.peek() <= day){
                queue.poll();
                cnt++;
            }
            
            answer.add(cnt);
        }
        

        return answer.stream().mapToInt(i -> i).toArray();
    
    }
}