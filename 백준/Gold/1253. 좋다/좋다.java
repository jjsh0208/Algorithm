import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {    

    static int n , i, j , answer;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int k = 0; k < n; k++){
            long target = arr[k];
            int i = 0;
            int j = n - 1;

            while(i < j){
                if(arr[i] + arr[j] == target){

                    if(i != k && j != k){
                        answer++;
                        break;
                    }
                    else if(i == k){
                        i++;
                    }
                    else if(j == k){
                        j--;
                    }
                }
                else if(arr[i] + arr[j] < target){
                    i++;
                }else{
                    j--;
                }
            }
        }

        System.out.println(answer);



    }
}