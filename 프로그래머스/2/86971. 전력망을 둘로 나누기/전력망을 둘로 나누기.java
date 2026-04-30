import java.util.ArrayList;

class Solution {
    
    boolean[] visited;
    ArrayList<Integer>[] list;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        list = new ArrayList[n + 1];
        
        for(int i = 0; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < wires.length; i++){
            int node1 = wires[i][0];
            int node2 = wires[i][1];
            
            list[node1].add(node2);
            list[node2].add(node1);
        }
        
        for(int i = 0; i< wires.length; i++){
            visited = new boolean[n + 1];
            int nodeA = wires[i][0];
            int nodeB = wires[i][1];
            
            visited[nodeB] = true;
            int cnt = dfs(nodeA);   
            
            // 이번 간선의 최소값
            int diff = Math.abs((n - cnt) - cnt);
            
            answer = Math.min(answer, diff);
        }
               
        return answer;
    }
    
    
    private int dfs(int crrent){
        
        visited[crrent] = true;
        int cnt = 1;
        for(int node : list[crrent]){
            if(!visited[node]){
                cnt += dfs(node);
            }
        }
        
        return cnt;
    
    }
    
    
}