import java.io.*;
import java.util.*;

public class Main {

    static int n,m,v;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[s].add(e);
            arr[e].add(s);
        }

        for(int i = 1; i <= n; i++){
            Collections.sort(arr[i]);
        }

        visited = new boolean[n + 1];
        DFS(v);
        System.out.println();
        visited = new boolean[n + 1];
        BFS(v);
    }

    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);

        visited[node] = true;

        while(!queue.isEmpty()){
            int n = queue.poll();
            System.out.print(n + " ");

            for(int i : arr[n]){
                if(!visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }

        }
    }


    private static void DFS(int node) {
        System.out.print(node+ " ");
        visited[node] = true;

        for(int i : arr[node]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }

}
