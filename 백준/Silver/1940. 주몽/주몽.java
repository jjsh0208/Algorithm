import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;
        int i = 0;
        int j = n - 1; // 인덱스는 0부터 시작해서 n보다 -1까지

        while(i < j){
            if((arr[i] + arr[j]) < m){ // 합이 작으면 앞 포인터 전진
                i++;
            }else if((arr[i] + arr[j]) > m){ // 합이 더 크면 뒤 포인트 후진
                j--;
            }else if((arr[i] + arr[j]) == m){ // 동일할 시 다음 경우를 위해 앞 포인터 전진, 뒤 포인터 후진하고 카운터증가
                i++;
                j--;
                answer++;
            }
        }

        System.out.println(answer);


    }
}
