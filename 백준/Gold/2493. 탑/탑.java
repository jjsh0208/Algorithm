import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] result = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] top = new int[n];

		for(int i = 0; i < n; i++){
			top[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>(); // 인덱스를 저장하는 스택
		for (int i = 0; i < n; i++) {
			// 스택이 비지 않고 현재 탑이 이전 탑보다 크거나 같을 때까지 pop
			while (!stack.isEmpty() && top[stack.peek()] < top[i]) {
				stack.pop();
			}

			// 스택이 비어있으면 수신하는 탑이 없음 (0)
			if (stack.isEmpty()) {
				result[i] = 0;
			} else {
				result[i] = stack.peek() + 1; // 인덱스는 0부터 시작하므로 +1
			}

			stack.push(i); // 현재 탑 인덱스를 스택에 추가
		}

		StringBuilder sb = new StringBuilder();
		for (int i : result) {
			sb.append(i).append(" ");
		}
		System.out.println(sb.toString());

	}
}