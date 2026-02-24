import java.io.*;
import java.util.*;

public class Main {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        RadixSort(arr,5); //배열과 최대 자릿수

        for(int i = 0 ; i < n; i++){
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();

    }

    private static void RadixSort(int[] arr, int maxSize) {
        int[] output = new int[arr.length];
        int jarisu = 1;
        int cnt = 0;

        while(cnt != maxSize){

            int[] bucket = new int[10]; // 1부터 10의 자리수를 카운터할 배열 , 자리수 분포를 합배열로 확인할 배열

            for(int i = 0; i < arr.length; i++){
                bucket[(arr[i] / jarisu) % 10]++;
            }

            for(int i = 1; i < 10; i++){ // 합배열을 사용해 인덱스 계산
                bucket[i] += bucket[i - 1];
            }

            for(int i = arr.length - 1; i >= 0; i--){
                output[bucket[(arr[i] / jarisu % 10)] - 1] = arr[i];
                bucket[(arr[i] / jarisu) % 10]--;
            }

            for(int i = 0; i < arr.length; i++){
                arr[i] = output[i];
            }

            jarisu *= 10; // 자리수 증가시키기
            cnt++;
        }

    }
}