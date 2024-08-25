import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long n = Long.parseLong(br.readLine());

        System.out.println(String.valueOf(factorial(n)));
        br.close();
    }

    private static long factorial(Long n) {
        if(n <= 0) return  1;
        return  n * factorial(n - 1);
        
    }
}