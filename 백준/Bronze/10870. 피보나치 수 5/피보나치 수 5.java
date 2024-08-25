import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(String.valueOf(factorial(n)));
        br.close();
    }

    private static int factorial(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return  factorial(n - 1) + factorial(n - 2);
    }
}