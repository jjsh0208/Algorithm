import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int sum = 0;
        int prev  = 0;
        int[] ary = new int[n];

        st = new StringTokenizer(br.readLine()," ");
        
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ary);

        for (int i = 0; i < n; i++) {
            sum += prev + ary[i];

            prev += ary[i];

        }
        bw.write(String.valueOf(sum));

        bw.flush();
        bw.close();
        br.close();
        
    }
}