import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] ary = new int[5];
        

        for (int i = 0; i < ary.length; i++) {
            ary[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ary);

        System.out.println(Arrays.stream(ary).sum() / ary.length);
        System.out.println(ary[2]);

    }
}