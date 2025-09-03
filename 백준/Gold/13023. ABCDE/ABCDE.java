import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int N , M; // 노드(사람의 수) 와 간선(친구 관계의 수)
    static ArrayList<Integer>[] A;// 인접 리스트 그래프 (각 노드와 연결된 노드 목록)
    static boolean[] visited; // 방문 확인용 변수
    static boolean check; // 깊이 5(친구 관계 5명 연속) 발견 여부

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 노드 입력
        M = sc.nextInt(); // 간선 입력

        // 변수 초기화
        A = new ArrayList[N];
        visited = new boolean[N];
        check = false;

        // ArrayList 초기화
        for(int i = 0; i < N; i++){
            A[i] = new ArrayList<Integer>();
        }

        //각 노드 연결
        for(int i = 0; i < M; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();

            A[s].add(e);
            A[e].add(s);
        }

        // 모든 노드를 시작점으로 DFS 시작
        for(int i = 0; i < N; i++){
            // 0부터 N까지의 수 중에서
            DFS(i, 1);

            // 길이가 5인 경로(친구 5명 연속 연결) 발견 시 종료
            if(check) break;
        }

        // 결과 유무에 따른 1과 0 출력
        System.out.println(check ? 1 : 0);
    }

    private static void DFS(int num, int depth){
        // 현재 깊이가 5이거나 도착 확인 변수가 true이면 종료
        if (depth == 5) {  
            check = true;  
            return;  
        }  

        if (check) return;  

        // 현재 위치 방문
        visited[num] = true;

        // 인접 노드 중 방문하지 않은 노드로 DFS (깊이 +1)
        for(int i : A[num]){
            if(!visited[i]){
                DFS(i, depth + 1);
            }
        }

        // 순회가 끝나면 다시 방문 초기화
        visited[num] = false;
    }
}
