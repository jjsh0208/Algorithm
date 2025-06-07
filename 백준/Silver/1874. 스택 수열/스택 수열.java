import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Stack<Integer> stack = new Stack<>();

		int n = Integer.parseInt(br.readLine());

		int start = 0;

		while(n-- > 0){

			int x = Integer.parseInt(br.readLine());

			if (x > start){
				for(int i = start + 1; i <= x; i++) {
					stack.push(i);
					sb.append('+').append('\n');
				}
				start = x;
			}else if (stack.peek() != x){
				System.out.println("NO");
				return;
			}

			stack.pop();
			sb.append('-').append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}