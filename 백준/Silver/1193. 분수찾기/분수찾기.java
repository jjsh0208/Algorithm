import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        br.close();
        int squareCount  = 1; //대각 수는 최소 1부터 시작
        int squareSum = 0; //누적된 대각 값

        while(true){
            if (n <= squareCount  + squareSum) {
                if (squareCount % 2 == 1) {
                    System.out.println((squareCount  - (n - squareSum - 1)) + "/" + (n - squareSum));
                    break;
                }
                else{
                    System.out.println((n - squareSum)  + "/" + (squareCount  - (n - squareSum - 1)));
                    break;
                }
            }
            else{
                squareSum += squareCount;
                squareCount ++;
            }

        }
        
    }
}
