import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int n, int[][] edge) {
        
        ArrayList<Integer>[] nodes = new ArrayList[n + 1];
        
        for(int i = 1; i <= n ; i++){
            nodes[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edge.length; i++){
            int start = edge[i][0];
            int end = edge[i][1];
            
            nodes[start].add(end);
            nodes[end].add(start);
        }

        return bfs(n, 1, nodes);
    }
    
    
    private int bfs(int n, int start, ArrayList<Integer>[] nodes){
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[n + 1];
        
        queue.add(start);
        distance[start] = 1; 

        int max = 0;
        
        while(!queue.isEmpty()){
            int current = queue.poll();
        	
            for(int next : nodes[current]){
                
                if(distance[next] == 0){
                    queue.add(next);
                    
                    distance[next] = distance[current] + 1;
                    
                    max = Math.max(max, distance[next]);
                }
            }
        }
        
       int count = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == max) {
                count++;
            }
        }

        return count;
    }
}