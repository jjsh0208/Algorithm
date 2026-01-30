import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        // 구간합 s[j] - s[i -1]이 m으로 맞아 떨어지는 경우의 수를 찾는 문제
        // 수학에서 두 수의 나머지가 같다면 두 수의 차이는 m으로 나누어 떨어진다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long answer = 0;

        long[] s = new long[n]; // 구간합배열
        long[] c = new long[m]; // 나머지가 같은 인덱스 배열

        // 구간 합 구하기
        st = new StringTokenizer(br.readLine());
        s[0] = Integer.parseInt(st.nextToken());
        for(int i = 1; i < n; i++){
            s[i] = s[i - 1] + Integer.parseInt(st.nextToken());
        }

        // 1. 구간 합이 m으로 나눠서 0으로 떨어지는 경우 수 구하기
        for(int i = 0; i < n; i++){
            int remainder = (int) (s[i] % m); // 합을 m으로 나눈 수 구하기
            // 나머지가 0인 경우 
            if(remainder == 0) answer++; // 0인 경우 나누어 떨어진 것
            c[remainder]++; 
        }

        for(int i = 0; i < m; i++){
            if(c[i] > 1){
                // 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수를 더하기
                // 두 수를 계산하는 경우의 수를 직접 구하기 보다
                // (n * n -1 )/ 2로 계산하면 된다.
                answer += (c[i] * (c[i] - 1)) / 2;
            }
        }

        System.out.println(answer);
        
    }

}