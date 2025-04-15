import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        // 우선 순위 큐 ( 내림 차순 )
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        
        for (int i  : priorities) {
            queue.offer(i);
        }
        
        
        while(!queue.isEmpty()){   
            for(int i = 0; i < priorities.length; i++){
                if(priorities[i] == queue.peek()){
                    queue.poll();
                    answer++;
                    
                    if(location == i){
                        return answer;
                    }
                }
            }
        }
        

        return answer;
    }
}