import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;
import java.io.*;

public class Main {

    static int t, n, cnt;
    static boolean[] visited; // 탐색 여부 저장 배열
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());

        while (t-- != 0) {
            n = Integer.parseInt(br.readLine());
            cnt = 0;

            arr = new int[n + 1][1];
            visited = new boolean[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i][0] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                DFS(i);
            }

            System.out.println(cnt);

        }

    }

    private static void DFS(int i) {
        if (visited[i]) {
            return;
        }

        visited[i] = true;
        if (!visited[arr[i][0]]) {
            DFS(arr[i][0]);
        } else{
            cnt++;
        }
    }
}