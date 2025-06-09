import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String s = br.readLine();

		Stack<Character> stack = new Stack<>();


		for(int i = 0; i < s.length(); i++){
			char now = s.charAt(i);
			
			switch(now){
				case '+':
				case '-':
				case '*':
				case '/':
					while(!stack.isEmpty() && priority(stack.peek()) >= priority(now)){
						sb.append(stack.pop());
					}
					stack.push(now);
					break;
				case '(':
					stack.push(now);
					break;
				case ')':
					while(!stack.isEmpty() && stack.peek() != '('){
						sb.append(stack.pop());
					}
					stack.pop();
					break;
				default:
					sb.append(now);
			}
		}

		while(!stack.isEmpty()){
			sb.append(stack.pop());
		}

		System.out.println(sb);
		br.close();
	}

	private static int priority(Character op) {

		if (op == '(' || op == ')'){
			return 0;
		} else if (op == '+' || op == '-'){
			return 1;
		} else if (op == '*' || op == '/'){
			return 2;
		}else {
			return -1;
		}
	}
}