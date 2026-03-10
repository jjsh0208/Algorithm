import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];

        for(int i = 2; i <= n; i++){
            arr[i] = i;
        }

        for(int i = 2; i <= Math.sqrt(n); i++) { // 2부터 n의 제곱근 까지
            if (arr[i] == 0) {
                continue;
            }

            // i 자신을 제외한 i의 배수를 모두 0으로 변경
            for (int j = i + i; j <= n; j = j + i) {
                arr[j] = 0;
            }
        }

        for(int i = m; i <= n; i++){
            if(arr[i] != 0){
                System.out.println(arr[i]);
            }
        }
    }
}