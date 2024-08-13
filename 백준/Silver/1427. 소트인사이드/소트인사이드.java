import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String t = br.readLine();

        Integer[] ary = new Integer[t.length()];

        for (int i = 0; i < ary.length; i++) {
            ary[i] = t.charAt(i) - '0';
        }
        
        Arrays.sort(ary, Collections.reverseOrder());

        
        for (int i : ary) {
            sb.append(i);
        }
        System.out.println(sb);
    
        br.close();

    }
}