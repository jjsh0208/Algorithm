import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br;
	private static StringTokenizer st;
	private static HashSet<String> map;
	private static int n;
	private static char game;

	// y 는 2명
	// f 는 3명
	// o 는 4명

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		map = new HashSet<>();

		n = Integer.parseInt(st.nextToken());
		game = st.nextToken().charAt(0);

		for(int i = 0; i < n; i++){
			map.add(br.readLine());
		}

		switch(game){
			case 'Y':
				System.out.println(map.size());
				break;
			case 'F':
				System.out.println(map.size()/2);
				break;
			case 'O':
				System.out.println(map.size()/3);
				break;

		}

		br.close();

	}

}