import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            queue.offer(Integer.parseInt(br.readLine()));
        }
        
        int sum = 0;
        while(queue.size() != 1){
            int num1 = queue.poll();
            int num2 = queue.poll();

            sum += num1 + num2;
            queue.offer(num1 + num2);
        }

        System.out.println(sum);
        //(10 +20 ) + (30 + 40)


    }


}



