import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {    

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st= new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < n; i++){

            int temp = arr[i];

            int j = i - 1;

            while(j >= 0 && arr[j] > temp){
                arr[j + 1] = arr[j];
                j--;
            }
            
            arr[j + 1] = temp;
        }
        
        int[] answer = new int[n];
        answer[0] = arr[0];

        for(int i = 1; i < n; i++){
            answer[i] = answer[i - 1] + arr[i];
        }
        
        int result = 0;
        for(int i : answer){
            result += i;
        }

        System.out.println(result);

        br.close(); 

    }

} 