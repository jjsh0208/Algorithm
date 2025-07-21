import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {	
 	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];


		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < n; i++){
			arr[i] = Integer.parseInt(st.nextToken()); 
		}

		int max = 0;
        int count = 0;
        int sum = 0;

        for (int i = 0; i < x; i++){
            sum += arr[i];
        }

        max = sum;
        count = 1;

        // 슬라이딩 윈도우
        for (int i = x; i < n; i++) {
            sum = sum - arr[i - x] + arr[i];

            if (sum > max) {
                max = sum; 
                count = 1;
            } else if (sum == max) {
                count++;
            }
        }

        if (max == 0){
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }
	}
}