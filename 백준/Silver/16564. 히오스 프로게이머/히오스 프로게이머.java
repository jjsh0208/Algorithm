import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken()); //캐릭터의 수
        int k = Integer.parseInt(st.nextToken()); //레벨업 할 수 있는 수
        int[] ary = new int[n]; //캐릭터 수 만큼의 배열

        for (int i = 0; i < ary.length; i++) {
            ary[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ary); //이분탐색을 하기위한 오름차순 정렬

        int result = 0; //결과를 담을 변수
        int start = ary[0]; //탐색의 시작점
        int end = ary[n - 1] + k; //탐색의 종료지점


        while(start <= end){ //start가 end 보다 작거나 같을 때만 반복
            int mid = (start + end) / 2; //중간값 찾기
            
            long sum = 0;

            for (int i = 0; i < n; i++) {
                if (ary[i] < mid) { //배열의 값이 중간값보다 작으면 중간값 에서 중간값보다 작은 배열의 요소를 뺀 후 sum에 더한다.
                    sum += (mid - ary[i]);
                }
            }

            if (sum <= k) { // sum의 값이 레벨업 할 수 있는 수 보다 작거나 같으면 result에 중간값을 넣고 시작 위치를 중간값 다음으로 변경한다.
                result = mid;
                start = mid + 1;
            }else{
                end = mid - 1; // sum의 값이 레벨업 할 수 있는 수보다 크면 탐색 범위를 중간값보다 하나 밑으로 줄인다.
            }
        }

        System.out.println(result);
    }
}