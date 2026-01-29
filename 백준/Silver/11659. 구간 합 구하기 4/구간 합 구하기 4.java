import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int n, m;
    static long[]  s;
    
    public static void main(String[] args) throws IOException {
      // 합 배열 구하기
      // s[i] = s[i - 1] + a[i];
        
      // 구간 합 구하기
      // s[j] - s[i - 1];   // i ~ j 까지의 구간합 구하기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        s = new long[n + 1];

        st = new StringTokenizer(br.readLine());
        //합 배열 생성
        for(int i = 1; i <= n; i++){
            s[i] = s[i - 1] + Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            System.out.println(s[end] - s[start - 1]);
        }

    }

}