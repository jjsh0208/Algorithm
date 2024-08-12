import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int[] ary = new int[6];

        for (int i = 0; i < ary.length; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = -999; i <= 999; i++) {
            for (int j = -999; j <= 999; j++) {
                if ((ary[0] * i) + (ary[1] * j) == ary[2]) {
                    if ((ary[3] * i) + (ary[4] * j) == ary[5]) {
                        System.out.println(i +" "+j);
                        break;
                    }
                }
            }
        }
        br.close();
    }
}