import java.util.*;
import java.io.*;

public class Main {

    static int n, start, target, m, result;
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        start = sc.nextInt();
        target = sc.nextInt();
        m = sc.nextInt();

        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for(int i = 0; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            int parent  = sc.nextInt();
            int child = sc.nextInt();

            list[parent].add(child);
            list[child].add(parent);
        }

        DFS(start,0);

        if (result != 0) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }

    }

    private static void DFS(int current,int depth) {
        if(current == target){
            result = depth;
            return;
        }

        visited[current] = true;

        for(int i : list[current]){
            if(!visited[i]){
                DFS(i,depth + 1);
            }
        }
    }
}