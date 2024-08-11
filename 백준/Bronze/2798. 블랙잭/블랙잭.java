import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
     
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int max = 0;
        int[] ary = new int[n];

        st = new StringTokenizer(br.readLine()," ");

        for(int i = 0; i < ary.length; i++){
            ary[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < ary.length; i++){
            for (int j = i + 1; j < ary.length; j++) {
                for (int k = j + 1; k< ary.length; k++) {
                    int a = ary[i] + ary[j] + ary[k];
                    if (a == m) {
                        max = a;
                    }else if (a >= max && a <= m) {
                        max = a;
              
                    }
                }
            }
        }

        System.out.println(max);

        br.close();
    }
}