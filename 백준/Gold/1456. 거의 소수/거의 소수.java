import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        br.close();
        
        long[] arr = new long[10000001];

        for(int i = 2; i < arr.length; i++){
            arr[i] = i;
        }

        for(int i = 2; i <= Math.sqrt(arr.length); i++){
            if(arr[i] == 0) continue;

            for(int j = i + i; j < arr.length; j = j + i){
                arr[j] = 0;
            }
        }

        // 소수의 거듭제곱이 범위안에 들어가는지 확인
        // 최소 수 보다 크거나 같으면 카운트
        int answer = 0;
        for(int i = 2; i < arr.length; i++){
            if(arr[i] != 0){
                long temp = arr[i];

                // 곱셈이 long의 범위를 넘을 수 있어서 이항 처리 필수
                while((double)arr[i] <= (double)max/(double)temp){
                    if((double)arr[i] >= (double)min/(double)temp) answer++;

                    temp *= arr[i];
                }

            }
        }

        System.out.println(answer);

    }
}