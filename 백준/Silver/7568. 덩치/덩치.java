import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static StringTokenizer st;
	private static BufferedReader br;
	private static StringBuilder sb;
	private static int n;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());

		int[][] human = new int[n][2];

		for(int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine(), " ");
			int weight = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());

			human[i][0] = weight;
			human[i][1] = height;
		}


		for (int i = 0; i < n;i ++){
			int rank = 1;

			for(int j = 0; j < n; j++){
				if(i == j) continue;
				if (human[i][0] < human[j][0] && human[i][1] < human[j][1]){
					rank++;
				}
			}
			sb.append(rank).append(' ');
		}
		System.out.println(sb);
		br.close();

	}

}