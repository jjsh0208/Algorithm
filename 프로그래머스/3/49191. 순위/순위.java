import java.util.ArrayList;

class Solution {

    
    
    public int solution(int n, int[][] results) {
        ArrayList<Integer>[] wins = new ArrayList[n + 1];
        ArrayList<Integer>[] loses = new ArrayList[n + 1];
        
        for(int i = 1; i <= n; i++){
            wins[i] = new ArrayList<>();
            loses[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < results.length; i++){
            int player1 = results[i][0];
            int player2 = results[i][1];
            
            wins[player1].add(player2);
            loses[player2].add(player1);
        }
        
        int answer = 0;
        for(int i = 1; i <= n; i++){
            boolean[] visitedWins = new boolean[n + 1];
            boolean[] visitedLoses = new boolean[n + 1];
            
            int win = dfs(i,wins,visitedWins) - 1; 
            int low = dfs(i,loses,visitedLoses) - 1; 
            
            if((win + low) == (n - 1)){
                answer++;
            }
        }
        
        return answer;
    }
    
    private int dfs(int node, ArrayList<Integer>[] graph, boolean[] visited){
        visited[node] = true;
        
        int cnt = 1;

        for(int nextNode : graph[node]){
            if(!visited[nextNode]){
                cnt += dfs(nextNode, graph, visited);                
            }
        }
        
        return cnt;
    }
}