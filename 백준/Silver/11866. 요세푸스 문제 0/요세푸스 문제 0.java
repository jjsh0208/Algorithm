import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		ArrayDeque<Integer> queue = new ArrayDeque<>();

		for(int i = 1; i <= n; i++){
			queue.offer(i);
		}

		List<Integer> list = new ArrayList<>();

		while(!queue.isEmpty()){
			for(int i = 0; i < k -1; i++){
				queue.offer(queue.poll());
			}

			list.add(queue.poll());
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<");

		for(int i = 0; i < list.size(); i++){
			sb.append(list.get(i));
			if (i != list.size() - 1){
				sb.append(", ");
			}
		}

		sb.append(">");

		System.out.println(sb);
		
	}
}