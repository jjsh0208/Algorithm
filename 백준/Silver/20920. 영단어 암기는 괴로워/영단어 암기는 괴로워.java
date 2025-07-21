import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
 
public class Main {	
 	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<String,Integer> map = new HashMap<>();


		// 단어 개수
		int n = Integer.parseInt(st.nextToken());

		// 길이 검사용
		int m = Integer.parseInt(st.nextToken());
		
		// 1. 빈도 우선
		// 2. 길이 우선
		// 3. 사전순
		
		for(int i = 0; i < n; i++){

			String s = br.readLine();

			if(s.length() < m) continue;

			map.put(s, map.getOrDefault(s,0) + 1);
		}

		List<String> list = new ArrayList<>(map.keySet());

		Collections.sort(list , new Comparator<String>() {
			public int compare(String o1, String o2) {
                // 1. 빈도수 내림차순
                int freqCompare = Integer.compare(map.get(o2), map.get(o1));
                if (freqCompare != 0) return freqCompare;

                // 2. 길이 내림차순
                int lenCompare = Integer.compare(o2.length(), o1.length());
                if (lenCompare != 0) return lenCompare;

                // 3. 사전 순 오름차순
                return o1.compareTo(o2);
            }
		});

		StringBuilder sb = new StringBuilder();
		for(String s : list){
			sb.append(s).append('\n');
		}

		System.out.print(sb);


	}
}