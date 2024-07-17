import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        br.close();

        if (a + b+ c != 180) {
            bw.write("Error");
            bw.flush();
            bw.close();
            return;
        }

        if (a == 60 && b == 60 && c == 60) {
            bw.write("Equilateral");
            bw.flush();
            bw.close();
            return;
        }

        if (a + b + c == 180) {
            if (a == b || a == c || c ==  b) {
                bw.write("Isosceles");
            }
            else if(a != b && a != c && c != b){
                bw.write("Scalene");
            }
        }


        bw.flush();
        bw.close();
    }
}