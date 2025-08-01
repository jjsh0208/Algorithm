import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {    

    static int n;
    static int m;
    static long[] s;
    static long[] c;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열의 크기
        n = Integer.parseInt(st.nextToken());

        // 나누어 떨어져야하는 수
        m = Integer.parseInt(st.nextToken());
        
        s = new long[n];
        c = new long[m];

        st = new StringTokenizer(br.readLine());
        s[0] = Integer.parseInt(st.nextToken());
        for(int i = 1; i < n; i++){
            s[i] = s[i - 1] + Integer.parseInt(st.nextToken());
        }

        long answer = 0;

        for(int i = 0; i < n; i++){
            int remainder = (int) (s[i] % m);
            if(remainder == 0) answer++;
            c[remainder]++;            
        }

        for(int i = 0; i < m; i++){
            if(c[i] > 1){
                answer += (c[i] * (c[i] - 1) / 2);
            }
        }
        System.out.println(answer);
    }
}