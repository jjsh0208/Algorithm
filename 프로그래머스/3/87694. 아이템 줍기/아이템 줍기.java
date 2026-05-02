import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    boolean[][] visited;
    int[][] map;
    int[] dy = {-1,1,0,0};
    int[] dx = {0,0,-1,1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {


        visited = new boolean[102][102];
        map = new int[102][102];
        
        // 1. 겹치는 모든 사각형 그리기
        for(int i = 0 ; i < rectangle.length; i++){
            int x1 = rectangle[i][0] * 2; // 좌측 하단 x
            int y1 = rectangle[i][1] * 2; // 좌측 하단 y
            int x2 = rectangle[i][2] * 2; // 우측 상단 x
            int y2 = rectangle[i][3] * 2; // 우측 하단 y
            
            for(int x = x1; x <= x2; x++){
                for(int y = y1; y <= y2; y++){
                    map[y][x] = 1;
                }
            }
        }
        
        // 2. 겹치는 사각형의 테두리를 제외하고 모두 비워줌
         for(int i = 0 ; i < rectangle.length; i++){
            int x1 = rectangle[i][0] * 2; // 좌측 하단 x
            int y1 = rectangle[i][1] * 2; // 좌측 하단 y
            int x2 = rectangle[i][2] * 2; // 우측 상단 x
            int y2 = rectangle[i][3] * 2; // 우측 하단 y
            
               for(int x = x1 + 1; x < x2; x++){
                for(int y = y1 + 1; y < y2; y++){
                    map[y][x] = 0;
                }
            }
         }
    
        return bfs(characterX,characterY,itemX,itemY);
    }
    
    
    private int bfs(int x, int y, int targetX, int targetY){
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(new Node(y * 2,x * 2,0));
        visited[y * 2][x * 2] = true;
        
        while(!queue.isEmpty()){
            Node crrent = queue.poll();
            
            int nowY = crrent.y;
            int nowX = crrent.x;
            int nowCnt = crrent.cnt;
            
            if(nowY == targetY * 2 && nowX == targetX * 2){
                return crrent.cnt / 2;
            }
            
            for(int i = 0; i < 4; i++){
                int newY = nowY + dy[i];
                int newX = nowX + dx[i];
                
                if(isValid(newY,newX) && !visited[newY][newX] && map[newY][newX] == 1){
                    visited[newY][newX] = true;
                    queue.add(new Node(newY,newX, crrent.cnt + 1));
                }
            }
        
        }
        return 0;
    }
    
    private boolean isValid(int y, int x){
        return y >= 0 && y < 102 && x >= 0 && x < 102;
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