import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {	
 	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());

		int[] road = new int[n - 1];
		int[] city = new int[n];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < road.length; i++){
			road[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < city.length; i++){
			city[i] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;
		int min = city[0];
		
		// 현재 기름값이 다음 기름 값보다 작은지 비교
		// 다음 기름값이 더 싸면 현재 기름값으로 다음 거리만큼 구매
		// 현재 기름값이 다음 기름값보다 더 싸면 다음다음 거리만큼 구매

		for(int i = 0; i < n - 1 ; i++){
			
			if(city[i] < min){
				min = city[i];
			}
		
			answer += (min * road[i] );
		}
	

		System.out.println(answer);


	}
}