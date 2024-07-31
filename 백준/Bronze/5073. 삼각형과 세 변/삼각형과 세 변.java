import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
       
        
        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            int[] ary = {Integer.parseInt(st.nextToken()) ,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()) };
            
            if (ary[0] == 0 && ary[1] == 0 && ary[2] ==0) break;
            
            Arrays.sort(ary);

            if (ary[2] >= (ary[0] + ary[1])) {
                System.out.println("Invalid");
            }else if(ary[0] == ary[1] && ary[0] == ary[2]){
               System.out.println("Equilateral");
            }else if(ary[0] == ary[1] || ary[0] == ary[2] || ary[1] == ary[2]){
              System.out.println("Isosceles");
            }else{
              System.out.println("Scalene");
            }
        }
        br.close();
    }
}