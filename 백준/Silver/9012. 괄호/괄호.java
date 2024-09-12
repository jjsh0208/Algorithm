import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
      

        for (int i = 0; i < n; i++) {
            char[]  text = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            for (char c : text) {//())(()
                if (c == '(') {
                    stack.push(c);
                }else if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }

            if (stack.isEmpty()) {
                bw.write("YES\n");
            }else{
                bw.write("NO\n");
            }

        }
        bw.flush();
        bw.close();
    }
}