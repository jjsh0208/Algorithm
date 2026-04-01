import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int n, m;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    bfs(i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{y, x});
        map[y][x] = 1;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            int nowY = node[0];
            int nowX = node[1];

            for (int i = 0; i < 4; i++) {
                int ny = (nowY + dy[i] + n) % n;
                int nx = (nowX + dx[i] + m) % m;

                if(map[ny][nx] == 0){
                    map[ny][nx] = 1;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
    }
}