import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n]; // 입력받을 수열

        for(int i = 0; i < n; i++){
             arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int num = 1; // 시작할 자연수
        boolean result = true;


        for(int i = 0; i < n; i++){

            int su = arr[i];

            if(su >= num){ // 현재 수열값이 자연수보다 크거나 같은지 확인
                // 수열값이 더크면 자연수와 같아질때 까지 자연수를 증가 시키고 스택에 추가
                while(su >= num){
                    stack.push(num++);
                    sb.append("+\n");
                }
                // 같아지면 바로 제거
                stack.pop();
                sb.append("-\n");
            }
            else{ // 현재 수열값 < 오른차순 pop() 수행
                int item = stack.pop();
                if(item > su){
                    // 스택의 가장 위의 수가 만들어야하는 수열보다 크면 수열을 출력할 수 없음
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else{
                    sb.append("-\n");
                }
            }

        }

        if(result) System.out.println(sb.toString());
        br.close();
    }
}