import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {    

    static int n;
    static long sum;
    static long max;
    static int[] scores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 정렬할 숫자 개수 입력
        n = Integer.parseInt(br.readLine());
        scores = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            scores[i] = Integer.parseInt(st.nextToken());
        }
        sum = 0;
        max = 0;
        for(int i = 0; i < n; i++){
            if(scores[i] > max){
                max = scores[i];
            }
            sum += scores[i];
        }
        System.out.println(sum *100.0/ max / n);

    }
}
