import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] board;
	static int n, d = 0;
	static Map<Integer,String> moveInfo;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 보드의 크기 (보드는 정사각형)
		n = Integer.parseInt(br.readLine());

		// 사과의 개수
		int k = Integer.parseInt(br.readLine());

		// 게임보드 초기화
		board = new int[n][n];

		// 시간-방향 저장할 맵
		moveInfo = new HashMap<>();

		// 사과의 위치 저장
		for(int i = 0; i < k; i++){
			st = new StringTokenizer(br.readLine());

			int low = Integer.parseInt(st.nextToken()) - 1;
			int col = Integer.parseInt(st.nextToken()) - 1;

			// 사과 위치
			board[low][col] = 1;

		}

		// 방향 전환 횟수
		int l = Integer.parseInt(br.readLine());

		// 방향 전환 정보 입력 ( 시간, 방향 )
		for(int i = 0; i<l; i++){
			st = new StringTokenizer(br.readLine());

			int time = Integer.parseInt(st.nextToken());
			String direction = st.nextToken();
			moveInfo.put(time,direction);
		}


		solve();
	}


	static void solve(){
		Queue<Integer> q = new LinkedList<>(); // 뱀의 몸 좌표를 일렬 번호 저장할 큐
		q.add(0); // 초기 위치 저장

		int time = 0; // 경과 시간
		int px = 0; // 현재 머리 위치
		int py = 0;

		while(true){
			// 이동해야할 x 경로
			int nx = px + dx[d];
			// 이동해야할 y 경로
			int ny = py + dy[d];
			time++;

			// 벽에 머리가 닿았는지 검사
			if(nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1){
				break;
			}

			// 머리가 몸통에 부딫혔는지 검사
			if (q.contains(ny * n + nx)){
				break;
			}

			// 사과가 있는 경우 사과를 제거하고 꼬리 유지 (몸길이 증가)
			if(board[ny][nx] == 1){
				board[ny][nx] = 0;
				q.add(ny * n + nx);
			// 사과가 없는 경우 : 꼬리 제거 (몸 길이 유지)
			} else{
				q.add(ny * n + nx);
				q.poll();
			}

			// 시간에 따른 방향 전환 처리
			if (moveInfo.containsKey(time)){
				String data = moveInfo.get(time);
				if (data.equals("D")){
					d += 1;
					if (d==4) d = 0; 
				}else{
					d -= 1;
					if (d== -1) d = 3;
				}
			}

			// 모든 과정이 정상적으로 처리되면 머리의 현재 위치르 갱신한다.
			px = nx;
			py = ny;

		}

		System.out.println(time);
	}
}