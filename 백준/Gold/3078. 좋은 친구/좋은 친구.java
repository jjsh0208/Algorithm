import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받기 (빠른 입력)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 학생 수, K: 등수 차이 제한
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 이름 길이별로 큐를 관리하기 위한 Map (key: 이름 길이, value: 해당 길이의 등수들)
        Map<Integer, Queue<Integer>> map = new HashMap<>();

        // 결과: 좋은 친구 쌍의 수
        long result = 0;

        // 순차적으로 학생 이름을 입력받음 (성적순)
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            int len = name.length(); // 이름 길이

            // 이름 길이에 해당하는 큐가 없으면 생성
            map.putIfAbsent(len, new LinkedList<>());

            Queue<Integer> queue = map.get(len);

            // 현재 학생과의 등수 차이가 K 초과인 학생은 큐에서 제거
            while (!queue.isEmpty() && i - queue.peek() > K) {
                queue.poll();
            }

            // 현재 큐에 남아 있는 학생 수만큼 좋은 친구 쌍이 생김
            result += queue.size();

            // 현재 학생의 인덱스를 큐에 추가
            queue.offer(i);
        }

        // 정답 출력
        System.out.println(result);
    }
}