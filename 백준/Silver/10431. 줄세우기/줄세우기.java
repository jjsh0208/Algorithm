import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static StringTokenizer st;
	private static StringBuilder sb;
	private static BufferedReader br;
	private static int n;

	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		while(n-- > 0){
			st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			sb.append(st.nextToken());

			int[] arr = new int[20];
			int cnt = 0;
			for(int j = 0; j < arr.length; j++){
				arr[j] = Integer.parseInt(st.nextToken());
			}

			for(int j = 0; j < arr.length; j++){
				for(int k = 0; k < j; k++){
					if (arr[k] > arr[j]) cnt++;
				}
			}

			sb.append(' ').append(cnt);
			System.out.println(sb);
		}
		br.close();
	}

}