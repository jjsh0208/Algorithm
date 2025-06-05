import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		for(int i = 0; i < n; i++){
			int x = Integer.parseInt(br.readLine());

			priorityQueue.offer(x);
		}

		int sum = 0;
		while(priorityQueue.size() > 1){
			int a = priorityQueue.poll();
			int b = priorityQueue.poll();

			sum += (a + b);
			priorityQueue.offer(a+b);
		}

		System.out.println(sum);
		br.close();
	}
}