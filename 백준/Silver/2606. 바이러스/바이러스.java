import java.util.Scanner;

public class Main {

    static int N , M; // 노드와 간선
    static int[][] A;// 인접 리스트 그래프 (각 노드와 연결된 노드 목록)
    static boolean[] visited; // 방문 확인용 변수
    static int result;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 노드 입력
        M = sc.nextInt(); // 간선 입력

        // 변수 초기화
        A = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < M; i++){
            int S = sc.nextInt();
            int E = sc.nextInt();

            A[S][E] = A[E][S] = 1;
        }

        DFS(1);

        System.out.println(result - 1);
    }


    private static void DFS(int x){
        visited[x] = true;
        result++;

        for(int i = 1; i <= N; i++){
            if(A[x][i] == 1 && !visited[i]){
                DFS(i);
            }
        }
    }
}
