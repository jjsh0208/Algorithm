import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        String[] n = new String[Integer.parseInt(st.nextToken())];
        String[] m = new String[Integer.parseInt(st.nextToken())];

        for (int i = 0; i <n.length; i++) {
            n[i] = br.readLine();
        }
        for (int i = 0; i < m.length; i++) {
            m[i] = br.readLine();
        }

        for (String origin : n) {
            for (String s : m) {
                if (origin.equals(s)) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

        br.close();
    }
}