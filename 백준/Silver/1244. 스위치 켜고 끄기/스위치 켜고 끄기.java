import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br;
	private static StringTokenizer st;
	private static int SWITCH_CNT, STUDENT_CNT;
	private static int[] SWITCH;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		SWITCH_CNT = Integer.parseInt(br.readLine());
		SWITCH = new int[SWITCH_CNT];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < SWITCH_CNT; i++){
			SWITCH[i] = Integer.parseInt(st.nextToken());
		}

		STUDENT_CNT = Integer.parseInt(br.readLine());

		while(STUDENT_CNT-- > 0){
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());

			if (gender == 1){

				for(int i = 0; i < SWITCH_CNT; i++){
					if ((i + 1) % number == 0){
						SWITCH[i] = SWITCH[i] == 0 ? 1 : 0;
					}

				}
			}else{
				int idx = number - 1; // 배열 인덱스로 변환 (1-based → 0-based)

				// 1. 중심 스위치 토글
				SWITCH[idx] = SWITCH[idx] == 0 ? 1 : 0;

				int offset = 1;
				while ((idx - offset) >= 0 && (idx + offset) < SWITCH_CNT) {
					if (SWITCH[idx - offset] == SWITCH[idx + offset]) {
						// 좌우 스위치 상태가 같다면 둘 다 토글
						SWITCH[idx - offset] = SWITCH[idx - offset] == 0 ? 1 : 0;
						SWITCH[idx + offset] = SWITCH[idx + offset] == 0 ? 1 : 0;
						offset++;
					} else {
						// 대칭이 깨졌다면 더 이상 검사하지 않음
						break;
					}
				}
			}
		}


		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < SWITCH_CNT; i++){
			sb.append(SWITCH[i]).append(' ');
			if ((i + 1) % 20 == 0) sb.append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}