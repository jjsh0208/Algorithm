import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    // 작업의 소요시간이 짧은것
    // 작업의 요청시간이 빠른 것
    // 작업의 번호가 작은 것 순
    // 우선순위 큐 사용
    // 배열의 순서는 1. 작업의 번호, 2. 작업의 소요 시간
    public int solution(int[][] jobs) {
        
        Arrays.sort(jobs, (o1,o2) -> {
           return Integer.compare(o1[0],o2[0]);
        });
        
        PriorityQueue<Node> queue = new PriorityQueue<>((n1,n2) ->{
            if(n1.costTime != n2.costTime){
                return Integer.compare(n1.costTime,n2.costTime);
            }
            else if(n1.requestTime !=n2.requestTime){
                return Integer.compare(n1.requestTime,n2.requestTime);     
            }
            else{
                return Integer.compare(n1.number,n2.number);
            }  
        });
        
        int nowTime = 0;
        int endJob = 0;
        int index = 0;
        int answer = 0;
        
        while(endJob < jobs.length){
            
            while(index < jobs.length && jobs[index][0] <= nowTime){
                queue.add(new Node(index, jobs[index][0],jobs[index][1]));
                index++;
            }
            
            if(!queue.isEmpty()){
                Node node = queue.poll();
                nowTime += node.costTime;
                answer += nowTime - node.requestTime;
                endJob++;
            }else{
                nowTime = jobs[index][0];
            }
        }
        
        return answer / jobs.length;
        
    }
    
    
    class Node{
        int number;
        int requestTime;
        int costTime;
        
        
        public Node(int number, int requestTime, int costTime){
            this.number = number;
            this.requestTime = requestTime;
            this.costTime = costTime;
        }
    
    }
}