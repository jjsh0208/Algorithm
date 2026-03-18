import java.util.*;
import java.io.*;

public class Main {

    static int n, result;
    static int[][] w;
    static boolean[] visited;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        w = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                w[i][j] = sc.nextInt();
            }
        }

        result = Integer.MAX_VALUE;

        visited[0] = true;
        DFS(0, 1, 0);

        System.out.println(result);
    }

    private static void DFS(int current, int cnt, int cost) {
        if (cnt == n) {
            if(w[current][0] != 0){
                result = Math.min(result,cost + w[current][0]);
            }
            return;
        }

        if(cost >= result) return;

        for (int i = 0; i < n; i++) {
            if (!visited[i] && w[current][i] != 0) {
                visited[i] = true;
                DFS(i, cnt + 1, cost + w[current][i]);
                visited[i] = false;
            }

        }


    }


}