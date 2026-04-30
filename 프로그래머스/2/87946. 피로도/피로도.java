class Solution {
    
    boolean[] visited;
    int answer;
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length]; // 던전의 수
        
        dfs(k,dungeons,0);
        
        return  answer;
    }
    
    
    // k 피로도
    // 던전
    // 현재 던전의 위치
    private void dfs(int k, int[][] dungeons, int stage){
        
        if(stage > answer){
            answer = stage;
        }
        
        for(int i = 0 ; i < dungeons.length; i++){
        
            if(!visited[i] && k >= dungeons[i][0]){
                visited[i] = true;
                // 피로도 소모
                dfs(k - dungeons[i][1],dungeons,stage + 1);
                visited[i] = false;
            }
            
        }
        
    }
}