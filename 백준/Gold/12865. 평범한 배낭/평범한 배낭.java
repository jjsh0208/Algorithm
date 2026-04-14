import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 물건 수
        int k = sc.nextInt(); // 버틸 수 있는 무게

        // w 무게
        // v 가치
        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        int[] dp = new int[k + 1];

        for(int i = 1; i <= n; i++){
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        for(int i = 1; i <= n; i++){
            // 최대 무게부터 현재 무게까지 반복
            for(int j = k; j >= w[i]; j--){
                dp[j] = Math.max(dp[j] , dp[j - w[i]]+ v[i]);
            }
        }

        System.out.println(dp[k]);
    }


}
