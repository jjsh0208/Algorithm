import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n,k,cnt;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 배열의 크기
        k = Integer.parseInt(st.nextToken()); // 교환 횟수

        int[] arr = new int[n];
        cnt = 0;


        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr,0, n - 1);

        if(cnt < k){
            System.out.println(-1);
        }


    }

    private static void quickSort(int[] arr, int s, int e) {
        if(s < e){
            int pivot = partition(arr,s,e); // 분할 시작
            quickSort(arr, s, pivot - 1);
            quickSort(arr, pivot + 1, e);
        }
    }

    
    private static int partition(int[] arr, int s, int e) {
        int x = arr[e];
        int index = s - 1;

        for(int i = s; i < e; i++){
             if(arr[i] < x){
                 swap(arr, ++index, i);
             }
        }

        if(index + 1 != e){
            swap(arr, index + 1, e);
        }

        return index + 1;

    }

    private static void swap(int[] arr, int s, int e) {
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;

        cnt++;

        if(cnt == k){
            System.out.println(arr[s]+ " " + arr[e]);
        }
    }
}