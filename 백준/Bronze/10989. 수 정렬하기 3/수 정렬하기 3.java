import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] ary = new int[Integer.parseInt(br.readLine())];

        for (int i = 0; i < ary.length; i++) {
            ary[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ary);

        for (int i : ary) {
            bw.write(String.valueOf(i) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}