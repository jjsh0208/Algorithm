import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        int cnt = 0;
        int result = 0;

        char prev = ' ';

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '(') {
                cnt++;
            } else {
                cnt--;
                if (prev == '(') {
                    result += cnt;
                } else{
                    result += 1;
                }
            }

            prev = c;
        }
        System.out.println(result);

    }


}
