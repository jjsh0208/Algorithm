import java.io.*;
import java.util.*;

public class Main {

	private static BufferedReader br;
	private static StringTokenizer st;
	private static int T;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		int[] answer = new int[T];

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] ranks = new int[n];
			Map<Integer, Integer> cntMap = new HashMap<>();

			// 등수 리스트 읽기
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int team = Integer.parseInt(st.nextToken());
				ranks[j] = team;
				cntMap.put(team, cntMap.getOrDefault(team, 0) + 1); // 각 팀 인원 수 카운트
			}

			// 팀별 5번째 선수 점수 저장용 배열 (팀 번호 기준으로 인덱스 사용)
			Map<Integer, Integer> scoreMap = new HashMap<>(); // 팀별 점수 누적
			Map<Integer, Integer> teamMemberCount = new HashMap<>(); // 팀별 통과 선수 수
			Map<Integer, Integer> fifthRunnerScore = new HashMap<>(); // 팀별 5번째 선수 점수
			int score = 1; // 1등부터 시작

			for (int team : ranks) {
				// 6명 정확히 참가한 팀만 점수 계산
				if (cntMap.get(team) == 6) {
					int count = teamMemberCount.getOrDefault(team, 0) + 1;
					teamMemberCount.put(team, count);

					if (count <= 4) {
						scoreMap.put(team, scoreMap.getOrDefault(team, 0) + score);
					} else if (count == 5) {
						fifthRunnerScore.put(team, score);
					}
					score++;
				}
			}

			// 최소 점수 팀 선택
			int minScore = Integer.MAX_VALUE;
			int selectedTeam = -1;
			int minFifthScore = Integer.MAX_VALUE;

			for (int team : scoreMap.keySet()) {
				int teamScore = scoreMap.get(team);
				int teamFifth = fifthRunnerScore.get(team);

				if (teamScore < minScore || (teamScore == minScore && teamFifth < minFifthScore)) {
					minScore = teamScore;
					minFifthScore = teamFifth;
					selectedTeam = team;
				}
			}

			answer[i] = selectedTeam;
		}

		// 출력
		for (int res : answer) {
			System.out.println(res);
		}

		br.close();
	}
}