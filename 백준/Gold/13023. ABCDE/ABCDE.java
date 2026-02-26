import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static ArrayList<Integer>[] arr;
    static boolean check;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n];
        visited = new boolean[n];
        check = false;

        for(int i = 0; i < n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }


        for(int i = 0; i < n; i++){
            DFS(i,1);

            if(check) break;
        }

        if(check) System.out.println(1);
        else System.out.println(0);
    }

    private static void DFS(int v, int depth) {
        if(depth == 5 || check){
            check = true;
            return;
        }
        visited[v] = true;

        for(int i : arr[v]){
            if(!visited[i]){
                DFS(i, depth + 1);
            }
        }
        visited[v] = false;
    }
}