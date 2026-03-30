class Solution {
    
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n]; // 몇번 컴퓨터에 접근했는지 확인
        
        int answer = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                answer++;
                DFS(n,computers,i);
            }
        }
        
        return answer;
    }
    
    private void DFS(int n, int[][] comp, int index){
        visited[index] = true;
        
        for(int i = 0; i < n; i++){
            if(comp[index][i] == 1 && !visited[i]){
                DFS(n,comp,i);
            }
        }
    }
}
