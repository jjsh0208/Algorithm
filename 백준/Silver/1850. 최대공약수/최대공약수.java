import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long a = sc.nextLong();
        long b = sc.nextLong();

        // 두 수의 곱셈 을 최대 공약수로 나누면 최소 공배수가 나온다
        long result = gcd(a, b);

        while(result > 0){
            bw.write("1");
            result--;
        }
        sc.close();
        bw.flush();
        bw.close();
    }

    private static long gcd(long a, long b) { //작은 거
        if (b == 0) {
            return a;
        }
        // 작은 수 , (큰수 % 작은수)
        return gcd(b, (a % b));
    }

}
