import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();

		long result = 0;
		int n = Integer.parseInt(br.readLine());
		int[] top = new int[n];

		for (int i = 0; i < n; i++) {
			top[i] = Integer.parseInt(br.readLine());
		}

		for(int i = 0 ; i < n; i++){

			while(!stack.isEmpty() && stack.peek() <= top[i]){
				stack.pop();
			}
			stack.push(top[i]);
			result += stack.size() - 1;

		}

		System.out.println(result);
		br.close();
	}

}