import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] ary = new int[n];

        for (int i = 0; i < ary.length; i++) {
            ary[i]= Integer.parseInt(br.readLine());
        }
        Arrays.sort(ary);

        for (int i : ary) {
            System.out.println(i);
        }

        
        br.close();
    }
}