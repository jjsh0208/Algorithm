import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
       
        
        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            int[] ary = {Integer.parseInt(st.nextToken()) ,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()) };
            
            if (ary[0] == 0 && ary[1] == 0 && ary[2] ==0) break;
            
            Arrays.sort(ary);

            if (ary[2] >= (ary[0] + ary[1])) {
                bw.write("Invalid");
                bw.newLine();
            }else if(ary[0] == ary[1] && ary[0] == ary[2]){
                bw.write("Equilateral");
                bw.newLine();
            }else if(ary[0] == ary[1] || ary[0] == ary[2] || ary[1] == ary[2]){
                bw.write("Isosceles");
                bw.newLine();
            }else{
                bw.write("Scalene");
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}