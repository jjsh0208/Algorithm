import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++){
            queue.add(new int[]{i,priorities[i]});
        }
        
        int cnt = 0;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            boolean check = false;
            
            for(int[] i : queue){
                if(i[1] > current[1]){
                    check = true;
                    break;
                }
            }

                   
            if(check){
                queue.add(current);
            }else{
                cnt++;
                if(current[0] == location){
                    return cnt;
                }
            }
            
           
        }
     
         
        return 1;
    }
}