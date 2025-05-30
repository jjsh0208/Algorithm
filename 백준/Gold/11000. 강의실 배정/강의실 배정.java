import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	// n개의 수업이 주어지고 각 수업마다 시작 시간과 종료 시간이 있다.
	// 한 강의실에서는 동시에 하나으 수업만 진행 가능
	// 모든 수업을 진행할 때 필요한 최소 강의실 수를 구한다.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;

		// 수업들을 시작 시간 기준으로 정렬하되, 시작 시간이 같으면 종료 시간 오름차순 정렬
		PriorityQueue<int[]> queue = new PriorityQueue<>(((o1,o2)->{
			if(o1[0] == o2[0]){
				return o1[1] - o2[1];
			}else{
				return o1[0] - o2[0];
			}
		}));

		// 수업 시작, 끝시나을 입력받아 우선순위 큐에 저장
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());


			queue.offer(new int[]{start,end});
		}

		// 강의실 종료시간 기준으로 관리할 우선순위 큐 생성
		PriorityQueue<Integer> room = new PriorityQueue<>();
		room.offer(0); // 첫 강의실 초기화 ( 0이라는 의미는 아무 강의도 아직 없다는 의미)

		// 수업을 하나씩 꺼내어 강의실 배정
		while(!queue.isEmpty()){
			int[] cur = queue.poll(); // 현재 수업의 [시작,종료] 시간
			
			// 현재 수업시작 시간 >= 가장 빨리 끝나는 수업의 종료시간
			if(room.peek() <= cur[0]){
				room.poll(); // 해당 강의실 재사용 가능하므로 제거
			}
			
			//현재 수업 종료시간을 강의실에 넣음 ( 새 강의실 or 재사용 )
			room.offer(cur[1]);
		}

		/// 필요한 강의실 수 = room 에 남아있는 종료시간 개수
		System.out.println(room.size());
		br.close();
	}
}