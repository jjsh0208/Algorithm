import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    static int result = Integer.MIN_VALUE;
    static int N;
    static int[] ary,selected;
    static boolean[] visited;


    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ary = new int[N];
        selected = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(result);
    }


    private static void dfs(int cnt) {
        
        if (cnt == N) {
            result = Math.max(result, getResult());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[cnt] = ary[i];
                dfs(cnt + 1);
                visited[i] = false;
            }
        }


    }


    private static int getResult() {
        int sum = 0;
        for (int i = 0; i < ary.length - 1; i++) {
            sum += Math.abs(selected[i] - selected[i + 1]);
        }
        return sum;
        
    }
}