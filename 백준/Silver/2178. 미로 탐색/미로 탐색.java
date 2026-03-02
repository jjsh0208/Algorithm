import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }

        BFS(0,0);
        System.out.println(map[n - 1][m - 1]);
    }

    private static void BFS(int nx, int ny) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {nx,ny});

        visited[nx][ny] = true;

        while(!queue.isEmpty()){
            int[] node = queue.poll();

            for(int i = 0; i < 4; i++){
                int x = node[0] + dx[i];
                int y = node[1] + dy[i];
                if(x >= 0 && y >= 0 && x < n && y < m){
                    if(map[x][y] != 0 && !visited[x][y]){
                        visited[x][y] = true;
                        map[x][y] = map[node[0]][node[1]] + 1;
                        queue.add(new int[] {x,y});
                    }
                }
            }
        }

    }


}
