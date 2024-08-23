import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        System.out.println(a*b / gcd(b, a%b));


        br.close();
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }else{
            return gcd(b, a %b);
        }
    }

}