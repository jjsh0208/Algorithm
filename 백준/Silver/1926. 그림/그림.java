import java.util.*;
import java.io.*;

public class Main {

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int n, m, cnt, answer;
    static int[][] map; //1을 0으로 수정해 접근 검사


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cnt = 0;
        answer = 0;
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    BFS(i, j);
                }
            }
        }

        System.out.println(cnt);
        System.out.println(answer);
        br.close();
    }

    // 그림이 하나도 없는 경우도 존재
    private static void BFS(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        // index : row , index : col
        queue.add(new int[]{row, col});

        map[row][col] = 0;
        int mapCnt = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();


            int y = now[0];
            int x = now[1];

            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(isValid(ny,nx) && map[ny][nx] == 1){
                    mapCnt++;
                    map[ny][nx] = 0;
                    queue.add(new int[]{ny,nx});
                }
            }
        }
        cnt++;
        if(mapCnt> answer) answer = mapCnt;
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

}