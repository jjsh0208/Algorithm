import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = n - 1;

        int sum = 0;
        int min = 0;

        while(m > 0){
   
            int x = m;
            sum = m;
            while(x != 0){
                sum += x % 10;
                x /= 10;
            }
            if (sum == n) {
                min = m;
            }

            sum = 0;
            m--;
        }
        System.out.println(min);

        br.close();
    }
}