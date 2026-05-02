import java.util.Queue;
import java.util.LinkedList;

class Solution {

    char[][] map;
    boolean[][] visited;
    
    int[] dy = {-1,1,0,0};
    int[] dx = {0,0,-1,1};
    
    int boardY;
    int boardX;
    
    public int solution(String[] board) {
        int answer = 0;
        boardY = board.length;
        boardX = board[0].length();
        
        map = new char[boardY][boardX];
        visited = new boolean[boardY][boardX];
        
        int startY = 0;
        int startX = 0;
        
        for(int i = 0 ; i < board.length; i++){
            
            String line = board[i];
            for(int j = 0; j < line.length(); j++){
                char b = line.charAt(j);
                
                if(b == 'R'){
                    startY = i;
                    startX = j;
                }
                
                map[i][j] = b;
            }
            
        }
        
        return bfs(startY,startX);
    }
    
    private int bfs(int startY,int startX){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startY,startX,0));
        visited[startY][startX] = true;
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            
            int nowCnt = node.cnt;
            for(int i = 0; i < 4; i++){
                int nextY = node.y;
                int nextX = node.x;
                
                while(isValid(nextY + dy[i], nextX + dx[i]) && map[nextY + dy[i]][nextX + dx[i]] != 'D' ){
                    nextY += dy[i];
                    nextX += dx[i];
                }
                
                if(map[nextY][nextX] == 'G'){
                    return nowCnt + 1;
                }
                
                if(!visited[nextY][nextX]){
                    visited[nextY][nextX] = true;
                    queue.add(new Node(nextY,nextX,nowCnt + 1));
                }
                
            }
            
        }
        
        
        return -1;
    }
    
    private boolean isValid(int y, int x){
        return y >= 0 && y < boardY && x >= 0 && x < boardX;
    }
    
    
    
    class Node{
        int y;
        int x;
        int cnt;
        
        public Node(int y, int x, int cnt){
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
}