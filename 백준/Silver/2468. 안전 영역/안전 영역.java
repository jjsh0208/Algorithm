import java.util.*;
import java.io.*;

public class Main {
    // 방향 배열 세팅 (상, 하, 좌, 우)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n, cnt, h;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        StringTokenizer st;

        h = 0; // 안전지대의 최대 높이 값
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num > h) h = num;
            }
        }

        cnt = 0;
        int rain = 0;
        int result = 0;

        while(rain <= h){
            visited = new boolean[n][n];
            for(int i = 0; i < n; i++){
                for (int j = 0; j < n; j++) {
                    if(!visited[i][j] && map[i][j] > rain){
                        DFS(i,j, rain);
                        cnt++;
                    }
                }
            }
            rain++;

            if(cnt > result) result = cnt;
            cnt = 0;
        }

        System.out.println(result);
    }

    private static void DFS(int row, int col, int rain) {

        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dy[i];
            int newCol = col + dx[i];

            if (check(newRow, newCol) && !visited[newRow][newCol] && map[newRow][newCol] > rain) {
                DFS(newRow, newCol,rain);
            }
        }

    }

    private static boolean check(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }
}