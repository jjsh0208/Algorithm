import java.util.*;
import java.io.*;

public class Main {

    static int[] horseDy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] horseDx = {-2, -1, 1, 2, -2, -1, 1, 2};

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int k, w, h;

    static int[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        visited = new boolean[h][w][k + 1];

        visited[0][0][k] = true;

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        int result = bfs();
        System.out.println(result);
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0, k));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int y = node.y;
            int x = node.x;
            int cnt = node.cnt;
            int horseMoveCnt = node.horseMoveCnt;

            if (y == h - 1 && x == w - 1) {
                return cnt;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (isValid(ny, nx) && !visited[ny][nx][horseMoveCnt] && map[ny][nx] == 0) {
                    visited[ny][nx][horseMoveCnt] = true;
                    queue.add(new Node(ny, nx, cnt + 1, horseMoveCnt));
                }
            }

            if (horseMoveCnt > 0) {

                for (int i = 0; i < 8; i++) {
                    int ny = y + horseDy[i];
                    int nx = x + horseDx[i];

                    if (isValid(ny, nx) && !visited[ny][nx][horseMoveCnt - 1] && map[ny][nx] == 0) {
                        visited[ny][nx][horseMoveCnt - 1] = true;
                        queue.add(new Node(ny, nx, cnt + 1, horseMoveCnt - 1));
                    }
                }
            }
        }

        return -1;
    }


    private static boolean isValid(int ny, int nx) {
        return ny >= 0 && ny < h && nx >= 0 && nx < w;
    }

    static class Node {
        int y;
        int x;
        int cnt;
        int horseMoveCnt;

        public Node(int y, int x, int cnt, int horseMoveCnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.horseMoveCnt = horseMoveCnt;
        }


    }


}
