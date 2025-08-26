import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {    

    public static int[] A, temp;
    public static long result;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배열의 크기
        int N = Integer.parseInt(br.readLine());

        A = new int[N + 1];
        temp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 처음부터 배열의 마지막 까지 정렬 
        result = 0;
        mergetSort(1,N);

        System.out.println(result);
        br.close();
    }


   private static void mergetSort(int start, int end) {
        // start == end 이거나 (원소 1개) 
        // start > end (잘못된 범위)일 경우 재귀 종료
        if (end - start < 1) {
            return;
        }

        // 현재 구간의 중간 인덱스 계산
        // start + (end - start) / 2 형태를 쓰면 큰 수에서도 오버플로우 방지
        int m = start + (end - start) / 2;

        // 왼쪽 절반 정렬
        mergetSort(start, m); 
        // 오른쪽 절반 정렬
        mergetSort(m + 1, end);

        // 현재 구간의 값을 임시 배열 temp에 복사
        for (int i = start; i <= end; i++) {
            temp[i] = A[i];
        }

        int k = start;     // 병합된 값을 A에 채워 넣을 인덱스
        int index1 = start; // 왼쪽 그룹의 현재 인덱스
        int index2 = m + 1; // 오른쪽 그룹의 현재 인덱스

        // 두 그룹 모두 남아 있는 동안 반복
        // 각 그룹의 현재 원소를 비교해 더 작은 값을 A[k]에 저장
        while (index1 <= m && index2 <= end) {
            if (temp[index1] > temp[index2]) {
                A[k] = temp[index2];
                result = result + index2 - k;
                index2++;

            } else {
                A[k] = temp[index1];
                index1++;

            }
            k++;
        }

        // 왼쪽 그룹이 남아 있는 경우 모두 복사
        while (index1 <= m) {
            A[k] = temp[index1];
            index1++;
            k++;

        }

        // 오른쪽 그룹이 남아 있는 경우 모두 복사
        while (index2 <= end) {
            A[k] = temp[index2];
            index2++;
            k++;

        }
    }
}