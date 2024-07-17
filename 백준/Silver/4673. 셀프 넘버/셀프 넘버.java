import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] ary = new int[10000];

        for (int i = 0; i < ary.length; i++) {
            int num = d(i + 1);

            if (num <= 10000) {
                ary[num - 1] = 1;
            }
        }


        for (int i = 0; i < ary.length; i++) {
            if (ary[i] == 0) {
                bw.write(String.valueOf(i + 1));
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }

    private static int d(int i) {
        int sum = i;
        while(i != 0 ){
            sum +=  i % 10;
            i /= 10;
        }
        return sum;
    }
}