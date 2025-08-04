import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {    

    static int n , sum , answer , startIndex , endIndex;
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        // n은 이미 조회해서 하나를 만족하니까 1 부터 시작
        startIndex = 1;
        endIndex = 1;
        answer = 1;
        sum = 1;

        while(endIndex != n){

            if(sum == n){
                answer++;
                endIndex++;
                sum += endIndex;
            }
            else if(sum > n){
                sum -= startIndex;
                startIndex++;
            }
            else{
                endIndex++;
                sum += endIndex;
            }
        }

        System.out.println(answer);
    }
}