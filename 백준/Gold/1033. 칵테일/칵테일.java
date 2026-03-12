import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static long lcm; // 최소 공배수
    static long[] result; // 각 노드값 저장 배열
    static boolean[] visited; // 탐색 여부 저장 배열
    static ArrayList<Node>[] arr; // 인접 리스트

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        result = new long[n];
        visited = new boolean[n];
        arr = new ArrayList[n];
        lcm = 1;

        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();

            arr[a].add(new Node(b, p, q));
            arr[b].add(new Node(a, q, p));

            // 입력받는 모든 p, q의 최소공배수들을 곱해 무조건 나누어 떨어지는 수를 만든다
            lcm *= (p * q / gcd(p, q));
        }

        result[0] = lcm;
        DFS(0);

        long mgcd = result[0]; // 모든 노드의 질량들의 최대공약수를 담을 변수


        // 채워진 result 배열을 순회하며 전체 값들의 최대공약수를 구함
        for(int i = 1; i < n; i++){
            mgcd = gcd(mgcd, result[i]);
        }

        // 구한 전체 최대공약수(mgcd)로 모든 값을 나누어 가장 작은 정수 비율로 출력
        for(int i = 0; i < n; i++){
            System.out.print(result[i] / mgcd + " ");
        }

        sc.close();
    }

    private static void DFS(int node) {
        visited[node] = true;

        for(Node i : arr[node]){
            int next = i.getB();
            if(!visited[next]){
                result[next] = result[node] * i.getQ() / i.getP();
                DFS(next);
            }
        }
    }

    private static long gcd(long a, long b) { //작은 거
        if (b == 0) {
            return a;
        }
        // 작은 수 , (큰수 % 작은수)
        return gcd(b, (a % b));
    }


    static class Node {
        int b;
        int p;
        int q;

        Node(int b, int p, int q) {
            super();
            this.b = b;
            this.p = p;
            this.q = q;
        }

        public int getB(){ return b;}
        public int getP(){ return p;}
        public int getQ(){ return q;}

    }
}