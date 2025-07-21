import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {	
 	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

		// 지방의 수
		int n = Integer.parseInt(br.readLine());

		int left = 0;
		int right = 0;

		st = new StringTokenizer(br.readLine());
		
		int[] city = new int[n];

		for(int i = 0; i < n; i++){
			city[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, city[i]);
		}

		int m = Integer.parseInt(br.readLine());

		while(left <= right){
			int mid = (left + right) / 2;

			long budget =0;
			for(int i=0; i<n; i++) {
				if(city[i]>mid) budget += mid;
				else budget+= city[i];
			}
			if(budget<=m) {
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		
		System.out.print(right);


	}
}