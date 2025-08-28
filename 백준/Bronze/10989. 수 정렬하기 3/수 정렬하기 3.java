import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {    

    public static int[] A;
    public static long result;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        A = new int[N];

        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        // 5를 주는 이유는 최대 5자리 수 의 수 까지만 받기 때문
        RadixSort(A,5);

        for(int i = 0; i < N; i++){
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void RadixSort(int[] A, int maxSize){
        int[] output = new int[A.length]; // 임시 정렬 배열
        int jarisu = 1; // 현재 자리 수
        int cnt = 0;

        // 최대 자리 수 만큼 반복하기
        while(cnt != maxSize){
            int[] bucket = new int[10];

            for(int i = 0; i < A.length; i++){
                bucket[ (A[i] / jarisu )% 10]++;
            }

            for(int i = 1; i < 10; i++){
                bucket[i] += bucket[i - 1];
            }

            for(int i = A.length - 1; i >= 0; i--){
                output[bucket[A[i] / jarisu % 10] - 1] = A[i];
                bucket[(A[i] / jarisu) % 10]--;
            }

            for(int i = 0; i < A.length; i++){
                A[i] = output[i];
            }

            jarisu *= 10;
            cnt++;

        }
    }
}