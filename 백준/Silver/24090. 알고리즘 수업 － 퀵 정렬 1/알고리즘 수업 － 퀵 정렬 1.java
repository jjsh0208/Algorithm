import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {    

    static int n , k , cnt;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st= new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0 , n - 1);

        if (cnt < k) {
            System.out.print("-1");
        }

        br.close(); 
    }


    private static void quickSort(int[] A , int start, int end){
        if(start < end){
            int pivot = partition(A,start,end);
            quickSort(A, start , pivot - 1); // 왼쪽 분리 집합 정렬 
            quickSort(A, pivot + 1, end); // 오른쪽 분리 집합 정렬

        }
    }

    private static int partition(int[] A , int start , int end){
        int pivot = A[end];
        int idx = start - 1;

        for(int i = start;  i < end; i++){
            if(A[i] <= pivot){
                swap(A, ++idx, i);
            }

        }

        if(idx + 1 != end){
            swap(A, idx + 1, end);
        }

        return idx + 1;

    }

    private static void swap(int[] A , int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;

        cnt++;

        if(cnt == k){
            System.out.println(A[i] + " " + A[j]);
        }
    }


} 