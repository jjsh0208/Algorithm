class Solution {
    

    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, computers);    
                answer++;
            }
        }
        return answer;
    }
    
    
    private int dfs(int idx , int[][]computers){
         
       visited[idx] = true;
        
        for(int i = 0; i < computers.length; i++){
           if(idx != i && !visited[i] && computers[i][idx] == 1){
               dfs(i,computers);
           }
            
        }
        return 0;
    }
    
}
