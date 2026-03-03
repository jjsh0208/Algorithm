import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] distance;
    static ArrayList<Edge>[] arr;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++){
            arr[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());

            while(true) {
                int e = Integer.parseInt(st.nextToken());

                if (e == -1) break;

                int v = Integer.parseInt(st.nextToken());
                arr[s].add(new Edge(e, v));
            }
        }

        visited = new boolean[n + 1];
        distance = new int[n + 1];
        BFS(1);

        int max = 1;

        for(int i = 2; i <= n; i++){
            if(distance[max] < distance[i]){
                max = i;
            }
        }

        visited = new boolean[n + 1];
        distance = new int[n + 1];
        BFS(max);

        Arrays.sort(distance);
        System.out.println(distance[n]);

    }

    private static void BFS(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        visited[index] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(Edge i : arr[node]){
                int e = i.e;
                int v = i.value;

                if(!visited[e]){
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[node] + v;
                }
            }

        }
    }

    static class Edge{
        int e;
        int value;

        public Edge(int e, int value) {
            this.e = e;
            this.value = value;
        }
    }
}



