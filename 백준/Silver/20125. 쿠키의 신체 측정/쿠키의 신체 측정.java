import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static BufferedReader br;
	private static int N;
	private static int la , ra, wa, ll, rl;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		char[][] map = new char[N][N];

		// 전체 입력 저장
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int[] heart = new int[2];

		// 머리와 심장 찾기
		A: for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '*') {
					// 심장은 머리의 바로 아래
					heart[0] = i + 1; // 행
					heart[1] = j;     // 열
					break A;
				}
			}
		}

		// 왼팔 계산 (심장 행에서 좌측)
		for (int j = 0; j < heart[1]; j++) {
			if (map[heart[0]][j] == '*') {
				la++;
			}
		}

		// 오른팔 계산 (심장 행에서 우측)
		for (int j = heart[1] + 1; j < N; j++) {
			if (map[heart[0]][j] == '*') {
				ra++;
			}
		}

		// 허리 계산 (심장 아래로 같은 열 기준)
		int waistStartRow = heart[0] + 1;
		while (waistStartRow < N && map[waistStartRow][heart[1]] == '*') {
			wa++;
			waistStartRow++;
		}

		// 다리 계산 (허리 끝에서 시작)
		for (int i = waistStartRow; i < N; i++) {
			// 왼다리: 허리 열 기준 왼쪽
			if (heart[1] - 1 >= 0 && map[i][heart[1] - 1] == '*') {
				ll++;
			}
			// 오른다리: 허리 열 기준 오른쪽
			if (heart[1] + 1 < N && map[i][heart[1] + 1] == '*') {
				rl++;
			}
		}

		// 출력
		System.out.println((heart[0] + 1) + " " + (heart[1] + 1)); // 심장 좌표는 1-based
		System.out.println(la + " " + ra + " " + wa + " " + ll + " " + rl);

		br.close();
	}
}
