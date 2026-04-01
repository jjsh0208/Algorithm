import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    static int testCase, mapSize;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        testCase = sc.nextInt();

        StringTokenizer st;
        while(testCase-- > 0){
            mapSize = sc.nextInt();

            map = new int[mapSize][mapSize];

            int startY = sc.nextInt();
            int startX = sc.nextInt();

            int endY = sc.nextInt();
            int endX = sc.nextInt();

            bfs(startY,startX,endY,endX);
        }


    }

    private static void bfs(int startY, int startX, int endY, int endX) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(startY,startX,0));
        map[startY][startX] = 1; // visited 대신 1로 방문여부 검사

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.y == endY && node.x == endX){
                System.out.println(node.cnt);
                return;
            }

            for(int i = 0; i < 8; i++){

                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if(isValid(ny,nx) && map[ny][nx] == 0){
                    map[ny][nx] = 1;
                    queue.add(new Node(ny,nx, node.cnt + 1));
                }
            }

        }

    }

    private static boolean isValid(int ny, int nx){
        return ny >= 0 && ny < mapSize && nx >= 0 && nx < mapSize;
    }

    static class Node{
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