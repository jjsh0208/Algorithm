import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	// 조건 1 A와 그 뒤에있는 B를 지운다.
	// 조건 2 B와 그뒤에 있는 C를지운다.
	// 각문자는 최대 한번만 지울 수 있다.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		Queue<Integer> a = new LinkedList<>();
		Queue<Integer> b = new LinkedList<>();

		int cnt = 0;

		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);

			if (c == 'A'){
				a.offer(i);
			} else if (c == 'B'){
				b.offer(i);
			} else {
				if (!b.isEmpty() && b.peek() < i){
					b.poll();
					cnt++;
				}
			}
		}

		while(!a.isEmpty() && !b.isEmpty()){
			if (a.peek() < b.peek()){
				a.poll();
				b.poll();
				cnt++;
			}else{
				b.poll();
			}
		}

		System.out.println(cnt);

	}
}