import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) -> {
			int absO1 = Math.abs(o1);
			int absO2 = Math.abs(o2);

			if (absO1 == absO2){
				return o1 - o2; //절대값이 같으면 원래값이 더 작은 것 부터
			}else{
				return absO1 - absO2; // 절대값 기준 정렬
			}
		}));

		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());

			if (x == 0){
				if (!priorityQueue.isEmpty()){
					System.out.println(priorityQueue.poll());
				}else{
					System.out.println(0);
				}
			}else{
				priorityQueue.offer(x);
			}
		}

		br.close();
	}
}