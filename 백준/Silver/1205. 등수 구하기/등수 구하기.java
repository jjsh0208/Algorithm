import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br;
	private static StringTokenizer st;
	private static int N , SCORE, P;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		SCORE = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		if (N <= 0){
			System.out.println("1");
			return;
		}

		int[] scores = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			scores[i] = Integer.parseInt(st.nextToken());
		}

		if (N == P && scores[N - 1] >= SCORE) {
			System.out.println("-1");
			return;
		}


		int rank = 1;

		for(int i = 0 ; i < N; i++){
			if (scores[i] > SCORE){
				rank++;
			}else{
				break;
			}
		}

		System.out.println(rank);
		br.close();
	}
}
