import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {    

    public static int[] A, temp;
    public static long result;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 배열의 크기
        int N = Integer.parseInt(br.readLine());

        A = new int[N + 1];
        temp = new int[N + 1];

        for(int i = 1; i <= N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        // 처음부터 배열의 마지막 까지 정렬 
        mergetSort(1,N);

        for(int i = 1; i <= N; i++){
            bw.write(String.valueOf (A[i] + "\n"));
        }

        bw.flush();
        bw.close();
        br.close();
    }


    private static void mergetSort(int start , int end){
        // start == end 이거나 잘못된 범위로 넘어가면 종료
        if(end - start < 1){
            return; 
        }

        // 중간값 계산 
        int m = start +  (end - start) / 2;

        mergetSort(start, m); // 왼쪽 분할 
        mergetSort(m + 1, end); // 오른쪽 분할

        for(int i = start; i <= end; i++){
            temp[i] = A[i];
        }

        int k = start;
        int index1 = start; // 분할 기준 왼쪽의 첫번 째 인덱스
        int index2 = m + 1; // 분할 기준 오른쪽의 첫번 째 인덱스

        // 첫번 쨰 인덱스가 중간값보다 작거나 같고
        // 두번 째 인덱스가 마지막 값보다 작거나 같은동안 반복
        // 두 그룹을 병합하는 로직
        // 양쪽 그룹의 index가 가리키는 값을 비교해 더 작은 수를 선택해 배열에 저장하고
        // 선택된 데이터의 index 값을 오른쪽으로 한 칸 이동한다.
        while(index1 <= m && index2 <= end){
            
            if(temp[index1] > temp[index2]){
                A[k] = temp[index2];
                k++;
                index2++;
            } else{
                A[k] = temp[index1];
                k++;
                index1++;
            }
        }

        // 한족 그룹이 모두 선택된 후 남아있는 값 정리
        while(index1 <= m){
            A[k] = temp[index1];
            k++;
            index1++;
        }
        while(index2 <= end){
            A[k] = temp[index2];
            k++;
            index2++;
        }
    }
}