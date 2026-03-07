import java.io.*;
import java.util.*;

public class Main {

    static int n, one, zero;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        one = 0;
        zero= 0;

        PriorityQueue<Integer> posQueue = new PriorityQueue<>(Collections.reverseOrder()); // 양수
        PriorityQueue<Integer> negQueue = new PriorityQueue<>(); // 음수


        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > 1) {
                posQueue.offer(num);
            } else if (num == 1) {
                one++;
            } else if (num == 0) {
                zero++;
            } else {
                negQueue.offer(num);
            }
        }


        int sum = 0;
        while (posQueue.size() > 1) {
            int num1 = posQueue.poll();
            int num2 = posQueue.poll();

            sum += (num1 * num2);
        }

        if(!posQueue.isEmpty()){
            sum += posQueue.poll();
        }

        while(negQueue.size() > 1){
            int num1 = negQueue.poll();
            int num2 = negQueue.poll();

            sum += (num1 * num2);
        }

        // 음수가 홀수인 경우
        // 입력받은 0의 수가 하나도 없다면
        // 그냥 남은 수를 더해버리고
        // 0이 존재하면 곱해서 0으로 만들어버린다.
        // 어차피 0이기 때문에 zero가 존재하는 경우는 제외
        if(!negQueue.isEmpty()){
            if(zero == 0){
                sum += negQueue.poll();
            }
        }

        System.out.println(sum + one);
    }


}





