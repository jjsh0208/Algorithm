import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr , temp;
    static int n,x, cnt;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 배열 크기
        x = Integer.parseInt(st.nextToken()); // 저장 횟수

        arr = new int[n + 1];
        temp = new int[n + 1];
        cnt = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(1, n);

        if(cnt < x) System.out.println(-1);

        br.close();
    }

    private static void mergeSort(int s, int e){
        if(s < e){
            int mid = (s + e) / 2; //중간 지점
            mergeSort(s, mid); // 전반부 정렬
            mergeSort(mid + 1, e); // 후반부 정렬
            merge(s,mid,e);
        }
    }

    private static void merge(int s, int mid, int e) {
        int i = s; // 왼쪽 포인터
        int j = mid + 1; // 오른쪽 포인터
        int t = 1; // 임시 배열의 인덱스

        while (i <= mid && j <= e) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        while(i <= mid){
            temp[t++] = arr[i++];
        }
        while(j <= e){
            temp[t++] = arr[j++];
        }


        i = s;
        t = 1;

        while( i <= e){
            cnt++;
            arr[i++] = temp[t++];
            if(cnt == x){
                for(int idx = 1; idx <= n; idx++){
                    System.out.print(arr[idx] +" ");
                }
                return;
            }
        }
    }
}