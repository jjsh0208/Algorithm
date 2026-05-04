import java.util.PriorityQueue;


class Solution {
    public int solution(int[] scoville, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int answer = 0;
        
        for(int i = 0; i < scoville.length; i++){
            queue.add(scoville[i]);
        }
        
        while(queue.size() >= 2 && queue.peek() < k){
            int food1 = queue.poll();
            int food2 = queue.poll();
            
            int newFood = food1 + (food2 * 2);

            queue.add(newFood);
            answer++;
            
        }
        
        if(queue.peek() < k){
            return -1;
        }
        
        return answer;
    }
}