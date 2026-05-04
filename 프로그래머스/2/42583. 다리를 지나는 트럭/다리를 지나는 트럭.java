import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    // 다리에 올라갈 수 있는 수
    // 버틸 수 있는 최대 무게
    // 트럭 별 무게
    public int solution(int bridge_length, int weight, int[] truck_weights) {
    
        Queue<Integer> queue = new LinkedList<>();
    
        int sum = 0; // 트럭의 현재 무게
        int time = 0;
        
        for(int i = 0 ; i < truck_weights.length; i++){
            
            int truck = truck_weights[i];
            
            while(true){
                if(queue.isEmpty()){ //다리가 비었을 때는 진입
                    queue.add(truck);
                    sum += truck;
                    time++;
                    break;
                }
                else if(queue.size() == bridge_length){ // 다리가 꽉찼을 때는 한칸 지나감
                    sum -= queue.poll();
                }
                else{
                    // 다리에 공간이있고 진입이 가능한 무게이면 진입
                    if(sum + truck <= weight){
                        queue.add(truck);
                        sum += truck;
                        time++;
                        break;
                    }else{ // 공간이 있지만 무게가 못버틸 경우 0을 넣어 한칸 앞으로 밀어줌 
                        queue.add(0);
                        time++;
                    } 
                }  
            }
        }
        
        // 마지막 하나가 큐에 들어간채로 끝나기때문에 다리 길이만큼을 더했다 나갔다고 가정한다.
        return time + bridge_length;
    }
}