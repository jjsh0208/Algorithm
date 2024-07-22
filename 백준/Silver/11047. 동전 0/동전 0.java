import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int cnt = 0;
        Integer[] k = new Integer[n];

        for (int i = 0; i < k.length; i++) {
            k[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(k, Collections.reverseOrder());
        for (Integer integer : k) {
            if (t == 0) {
                break;
            }
            if (integer > t) {
                continue;
            }
            cnt += t / integer;
            t %= integer;
        }
        bw.write(String.valueOf(cnt));

        bw.flush();
        bw.close();
        br.close();
        
    }
}