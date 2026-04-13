import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        int[] numbers = new int[n]; // 원본 배열
        int[] freq = new int[1000001]; // 빈도 배열
        int[] answer = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            numbers[i] = num;
            freq[num] += 1;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i = 1; i < numbers.length; i++){

            while(!stack.isEmpty() && freq[numbers[stack.peek()]] < freq[numbers[i]]){
                answer[stack.pop()] = numbers[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb.toString());


    }


}
