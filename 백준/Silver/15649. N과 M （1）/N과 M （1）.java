import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static boolean[] v; // 숫자 사용 여부 저장
    static int[] s; // 수열 정보 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 자연수
        m = Integer.parseInt(st.nextToken()); // 수열의 길이

        s = new int[n];
        v = new boolean[n];

        backtracking(0);

    }

    private static void backtracking(int length) {
        if(length == m){
            printArray();
            return;
        }

        for(int i = 0; i < n; i++){
            if(!v[i]){
                v[i] = true;
                s[length] = i;
                backtracking(length + 1);
                v[i] = false;
            }
        }
    }

    private static void printArray() {
        for(int i = 0; i < m; i++){
            System.out.print(s[i] + 1 + " ");
        }
        System.out.println();
    }
}