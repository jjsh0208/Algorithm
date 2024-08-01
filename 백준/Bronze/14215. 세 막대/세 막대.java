import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Integer[] ary = {Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken()) ,Integer.parseInt(st.nextToken())};

        Arrays.sort(ary,Collections.reverseOrder());

        
        if ((ary[1]+ary[2]) > ary[0]) {
            System.out.println(ary[0]+ary[1]+ary[2]);
        }else{
            System.out.println((ary[0]+ary[1]+ary[2] - ary[0]) * 2 - 1);
        }
    
    }
}