import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] c  = br.readLine().toCharArray();

		int result = 0;
		int value = 1;

		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		for(int i = 0; i < c.length; i++){
			if (c[i] == '(') {
				stack.push(c[i]);
				value *= 2;
			} else if(c[i] == '['){
				stack.push(c[i]);
				value *= 3;
			} else if(c[i] == ')'){
				if (stack.isEmpty() || stack.peek() != '('){
					result = 0;
					break;
				} else if(c[i - 1] == '('){
					result += value;
				}
				stack.pop();
				value /= 2;
			} else if (c[i] == ']'){
				if (stack.isEmpty() || stack.peek() != '['){
					result = 0;
					break;
				} else if(c[i - 1] == '['){
					result += value;
				}
				stack.pop();
				value /= 3;
			}

		}

		if(!stack.isEmpty()) sb.append(0).append("\n");
		else sb.append(result).append("\n");
		System.out.println(sb);

	}
}