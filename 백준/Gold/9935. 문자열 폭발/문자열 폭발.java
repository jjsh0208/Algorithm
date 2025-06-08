import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		String bomb = br.readLine();

		int bombSize = bomb.length();

		Stack<Character> stack = new Stack<>();

		// 문자열 전체를 한 글자 씩 순회
		for(int i = 0; i < str.length(); i++){

			//현재 문자를 스택에 push
			stack.push(str.charAt(i));

			// 스택에 폭발 문자열 기이만큼 문자가 쌓였을 때만 검사
			if (stack.size() >= bombSize){
				boolean flag = true;

				// 스택의 끝부분이 폭발 문자열과 일치하는지 확인
				for(int j = 0; j < bombSize; j++){
					// 스택의 (끝 - bombSize + j) 번째 문자와 bomb의 j번쨰 문자가 다르면 false
					if (stack.get(stack.size() - bombSize + j) != bomb.charAt(j)){
						flag = false;
						break;
					}
				}

				// 폭발 문자열과 일치한다면 스택에서 해당 문자들을 pop 하여 제거
				if (flag){
					for (int j = 0; j < bombSize; j++){
						stack.pop();
					}
				}
			}
		}

		if (stack.isEmpty())
			System.out.println("FRULA");
		else{
			StringBuilder sb = new StringBuilder();
			for(Character c : stack){
				sb.append(c);
			}

			System.out.println(sb);
		}

		br.close();
	}
}