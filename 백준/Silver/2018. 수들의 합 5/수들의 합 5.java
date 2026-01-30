import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int start = 1;
        int end = 1;
        int count = 1;
        int sum = 1;

        while(end != n){
            if(sum == n){ // 연속 합이 n과 같은 경우
                count++;
                end++;
                sum += end;
            } else if(sum > n){ // 현재 연속 합이 n보다 큰 경우
                sum -= start;
                start++;
            } else if(sum < n){ // 현재 연속 합이 n보다 작은 경우
                end++;
                sum += end;
            }
        }

        System.out.println(count);
    }

}