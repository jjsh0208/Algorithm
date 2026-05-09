import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> ascQueue = new PriorityQueue<>();
        PriorityQueue<Integer> decQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String s : operations){
            String[] current = s.split(" ");
            
            String command = current[0];
            int num = Integer.parseInt(current[1]);
            
            if(command.equals("I")){
                ascQueue.add(num);
                decQueue.add(num);
            } else{ // 명령어 D
                if(num == 1){ // 최대값 제거
                    ascQueue.remove(decQueue.poll());
                }else{ // -1 인경우 
                    decQueue.remove(ascQueue.poll());
                }
            }
        }
        
        if(!decQueue.isEmpty()){ // 최대값 남은 거 추출
            answer[0] = decQueue.poll();
        }     
            
        if(!ascQueue.isEmpty()){
            answer[1] = ascQueue.poll();
        }
    
        return answer;
  

    }
}