import java.util.*;
import java.io.*;

public class Main {

    static int INF = 10000000; // 오버플로우 방지를 위한 무한대 값
    static int n, m;
    static int[][] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // 1부터 인덱스를 다루기 위해 + 1
        list = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    list[i][j] = 0;
                } else {
                    list[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            // 양방향 그래프이므로 양쪽 모두 1단계(거리 1)로 설정
            list[u][v] = 1;
            list[v][u] = 1;
        }

        for (int m = 1; m <= n; m++) { //가운데 노드
            for (int s = 1; s <= n; s++) { //시작 노드
                for (int e = 1; e <= n; e++) { //마지막 노드
                    if (list[s][e] > list[s][m] + list[m][e])
                        list[s][e] = list[s][m] + list[m][e]; //가운데를 거쳐가는 것이 더 빠르면 그걸로 업데이트한다.
                }
            }
        }


        int answer = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                sum += list[i][j];
            }

            if(sum < answer){
                answer = sum;
                result = i;
            }

        }

        System.out.println(result);

    }


}