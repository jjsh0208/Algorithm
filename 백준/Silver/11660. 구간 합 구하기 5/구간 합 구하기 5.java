import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {    

    static int n;
    static int m;
    static int[][] arrA;
    static int[][] arrB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // n x n 의 크기
        n = Integer.parseInt(st.nextToken());

        // 연산을 구해야하는 횟수
        m = Integer.parseInt(st.nextToken());
        
        arrA = new int[n+1][n+1];

        for(int i = 1; i < arrA.length; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < arrA[i].length; j++){
                arrA[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        arrB = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                arrB[i][j] = arrB[i][j - 1] + arrB[i - 1][j] - arrB[i - 1][j - 1] + arrA[i][j];
            }
        }

        for(int i = 0; i < m; i++){

            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(arrB[x2][y2] - arrB[x1 -1][y2] - arrB[x2][y1 - 1] + arrB[x1 - 1][y1 - 1]);
        }
        
    }
}
