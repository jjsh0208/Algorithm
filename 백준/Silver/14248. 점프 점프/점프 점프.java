import java.util.*;
import java.io.*;

public class Main {
    
    static int n, s, answer;
    static int[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list = new int[n + 1];
        visited = new boolean[n + 1];
        answer = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        s = Integer.parseInt(br.readLine()); // 출발점

        BFS(s); // 2->4->1

        System.out.println(answer);

        br.close();
    }

    private static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int index = queue.poll();

            int edge = list[index];

            if(bridgeCheck(index - edge) && !visited[index - edge]){
                queue.add(index - edge);
                visited[index - edge] = true;
                answer++;
            }
            if(bridgeCheck(index + edge) && !visited[index + edge]){
                queue.add(index + edge);
                visited[index + edge] = true;
                answer++;
            }
        }

    }

    private static boolean bridgeCheck(int edge){
        return edge >= 1 && edge <= n;
    }

}