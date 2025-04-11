import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();
        
        int n = progresses.length;
        
        int[] days = new int[n];
        
        for(int i = 0; i < n; i++) {
            days[i] = (int) Math.ceil((100.0 - (progresses[i])) / speeds[i]);
        }
        
        int cnt = 0;
        int maxDay = days[0];
        
        for(int i = 0; i < n; i++) {
            if(days[i] <= maxDay){
                cnt++;
            } else {
                queue.add(cnt);
                cnt = 1;
                maxDay = days[i];
            }
        }
        
        
        queue.add(cnt);
        return queue.stream().mapToInt(Integer::intValue).toArray();
    }
}