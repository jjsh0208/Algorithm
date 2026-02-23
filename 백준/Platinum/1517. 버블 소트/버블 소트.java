import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr , temp;
    static int n;
    static long cnt;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 배열 크기

        arr = new int[n + 1];
        temp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        cnt = 0;
        mergeSort(1, n );

        System.out.println(cnt);

        br.close();
    }

    private static void mergeSort(int s, int e) {
        if(s < e){
            int m = (s + e) / 2;
            mergeSort(s,m);
            mergeSort(m + 1, e);
            merge(s,e,m);
        }

    }

    private static void merge(int s, int e, int m) {
        int i = s; // 왼쪽 포인터
        int j =  m + 1; //오른쪽 포인터
        int t_index = 1; // temp의 인덱스

        while(i <= m && j <= e){
            if(arr[i] <= arr[j]){
                temp[t_index++] = arr[i];
                i++;
            }else{ // 뒤 쪽 데이터값이 더 적은 경우
                // 현재 j의 값이 왼쪽 값보다 더 작다는건
                // 왼쪽 배열은 이미 오름차순이라는 의미이다.
                // 그래서 그 뒤에 있는 수들 보다도 j가 무조건 작다
                // 현재 시점에서 남은 왼쪽 배열의 수를 카운트 해준다.

                cnt += (m - i + 1); // 왼쪽의 남아있는 수들을 더 해준다
                temp[t_index++] = arr[j];
                j++;
            }
        }

        //남은 데이터 정리
        while(i <= m){
            temp[t_index++] = arr[i++];
        }

        while(j <= e){
            temp[t_index++] = arr[j++];
        }

        i = s;
        t_index = 1;

        while(i <= e){
            arr[i++] = temp[t_index++];
        }

    }
}