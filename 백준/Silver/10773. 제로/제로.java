import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x > 0) {
                stack.push(x);
            }else{
               stack.pop();
            }
        }
        int sum = 0;
        
        while(!stack.empty()) sum+= stack.pop();

        bw.write(String.valueOf(sum));

        bw.flush();
        bw.close();
        br.close();

    }

}