import java.util.*;
import java.io.*;

public class Main {

    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};

    static int m, n, result;
    static int[][] map;
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    queue.add(new Node(i, j));
                }
            }
        }

        BFS();

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }else if(map[i][j] > result){
                    result = map[i][j];
                }
            }
        }

        System.out.println(result - 1);
    }

    private static void BFS() {

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newY = node.getY() + dy[i];
                int newX = node.getX() + dx[i];

                if (mapCheck(newY, newX) && map[newY][newX] == 0) {
                    map[newY][newX] = map[node.getY()][node.getX()] + 1;
                    queue.add(new Node(newY, newX));
                }
            }


        }
    }


    private static boolean mapCheck(int newY, int newX) {
        return newY >= 0 && newY < n && newX >= 0 && newX < m;
    }

    static class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return this.y;
        }

        public int getX() {
            return this.x;
        }

    }

}