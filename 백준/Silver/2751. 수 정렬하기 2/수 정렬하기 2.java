import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());

        int[] ary = new int[n];
        for (int i = 0; i < ary.length; i++) {
            ary[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ary);
     for (int i = 0; i < ary.length; i++) {
            bw.write(String.valueOf(ary[i]));
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
    }
}