import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int x = 2;


        while(true){
            if (n == 1) {
                break;
            }
            
            if (n % x == 0 ) {
                n = n / x;
                System.out.println(x);
            }else{
                x++;
            }      
               
        }
        
     
        bw.flush();
        br.close();
        bw.close();
    }
}