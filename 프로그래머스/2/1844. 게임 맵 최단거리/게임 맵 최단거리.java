import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    int[] dy ={-1,1,0,0};
    int[] dx = {0,0,-1,1};
    
    boolean[][] visited;

    public int solution(int[][] maps) {
        
  

        int y = maps.length;
        int x = maps[0].length;
        
        visited = new boolean[y][x];
        
        return bfs(maps,y,x);
    }
    
    private int bfs(int[][]map, int y, int x){
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(new Node(0,0,1));
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            Node crrent = queue.poll();
            
            int nowY = crrent.y;
            int nowX = crrent.x; 
            
            if(nowY == y - 1 && nowX == x- 1){
                return crrent.cnt;
            }
            
            for(int i = 0; i < 4; i++){
                int newY = nowY + dy[i];
                int newX = nowX + dx[i];
                
                if(isValid(newY,newX,y,x) && !visited[newY][newX] && map[newY][newX] == 1){
                    visited[newY][newX] = true;
                    queue.add(new Node(newY,newX,crrent.cnt + 1));
                }
                
            }
        
        }
        return -1;
        
    }
    
    private boolean isValid(int newY, int newX, int y, int x){
        return newY >= 0 && newY < y && newX >= 0 && newX < x;
    }
    
    
    class Node{
        int y;
        int x;
        int cnt;
        
        Node(int y, int x, int cnt){
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
    
    
}