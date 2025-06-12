import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	private static HashSet<Integer> s;

	public static void main(String[] args) throws IOException {

		//add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
		// remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
		// check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
		// toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
		// all: S를 {1, 2, ..., 20} 으로 바꾼다.
		// empty: S를 공집합으로 바꾼다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		s = new HashSet<>();

		int n = Integer.parseInt(br.readLine());

		while(n-- > 0){
			st = new StringTokenizer(br.readLine());
			String c = st.nextToken();

			switch (c){
				case "add":
					s.add(parseInt(st.nextToken()));
					break;
				case "remove":
					s.remove(parseInt(st.nextToken()));
					break;
				case "check":
					if (s.contains(parseInt(st.nextToken()))){
						sb.append(1).append('\n');
					}else{
						sb.append(0).append('\n');
					}
					break;
				case "toggle":
					int x = parseInt(st.nextToken());
					if (s.contains(x)){
						s.remove(x);
					}else{
						s.add(x);
					}
					break;
				case "all":
					s.clear();
					for (int i = 1; i <= 20; i++) {
						s.add(i);
					}
					break;
				case "empty":
					s.clear();
					break;
			}
		}

		System.out.println(sb);
		br.close();
	}

	private static int parseInt(String s){
		return Integer.parseInt(s);
	}
}