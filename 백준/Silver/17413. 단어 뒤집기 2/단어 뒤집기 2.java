import java.io.*;
import java.util.*;

public class Main {

    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        StringBuilder sb = new StringBuilder();

        boolean isTag = false;

        for(int i = 0; i < line.length(); i++){
            char c = line.charAt(i);

            if(c == '<'){
                isTag = true;
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append(c);
            }else if (c == '>'){
                sb.append(c);
                isTag = false;
            }else if (isTag){
                sb.append(c);
            }else{
                if(c == ' '){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(c);
                }else{
                    stack.push(c);
                }
            }



        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }

}
