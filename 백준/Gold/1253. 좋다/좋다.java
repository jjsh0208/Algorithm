import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];
        int answer = 0;

        StringTokenizer st=  new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        for(int a = 0; a < n; a++){
            int find = A[a]; // 비교할 수

            int i = 0; // 인덱스 시작점
            int j = n - 1; // 인덱스 마지막

            while(i < j){
                if(A[i] + A[j] == find){ // 두수의 합이 찾을 수와 같은 경우
                    if(i != a && j != a){ // 인덱스가 찾을 수 의 인덱스인지 검사 후 다르면 카운트 증가
                        answer++;
                        break;
                    } else if(i == a){ // 앞포인터의 인덱스가 찾을 수와 같으면 앞포인트 증가
                        i++;
                    } else if(j == a){ // 뒤포인터의 인덱스가 찾을 수와 같으면 뒤 포인트 감소
                        j--;
                    }
                }else if(A[i] + A[j] < find){
                    i++;
                }else{
                    j--;
                }
            }
        }

        System.out.println(answer);
        br.close();
    }
}
