import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {    

    static int n;
    static String s;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 정렬할 숫자 개수 입력
        n = Integer.parseInt(br.readLine());

        s = br.readLine();

        char[] arr = s.toCharArray();

        for(char c : arr){
            sum += c - '0';
        }

        System.out.println(sum);


    }
}
