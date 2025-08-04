import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {    

    static int n , m , i, j , answer;
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        answer = 0;
        i = 0;
        j = n - 1;


        while(i < j){
            if(m > arr[i] + arr[j]){
                i++;
            }
            else if(m < arr[i] + arr[j]){
                j--;
            }else{
                answer++;
                i++;
                j--;
            }
        }

        System.out.println(answer);
    }
}