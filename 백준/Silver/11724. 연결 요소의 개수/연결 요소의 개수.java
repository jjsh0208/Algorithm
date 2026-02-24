import java.io.*;
import java.util.*;

public class Main {

    static int n,m; // 노드와 에지 수
    static ArrayList<Integer>[] arr;
    static boolean[] visited;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for(int i = 1; i < n + 1; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e); // 양방향 그래프이므로 양쪽 다 연결
            arr[e].add(s);
        }
        br.close();

        int cnt = 0;
        for(int i = 1; i < n + 1; i++){
            if(!visited[i]){
                cnt++;
                DFS(i);
            }
        }
        System.out.println(cnt);

    }

    private static void DFS(int v) {
        if(visited[v]){
            return;
        }
        visited[v] = true;
        for(int i : arr[v]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }
}
