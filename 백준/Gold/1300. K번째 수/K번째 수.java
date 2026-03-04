import java.io.*;
import java.util.*;

public class Main {

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        long start = 1 , end = m;
        long sns = 0;

        while(start <= end){
            long mid = (start + end) / 2;
            long cnt = 0;

            for(int i = 1; i <= n; i++){
                cnt += Math.min(mid / i, n);
            }

            if(cnt < m){
                start = mid + 1;
            }else{
                sns = mid;
                end = mid - 1;
            }
        }

        System.out.print(sns);
    }
}



