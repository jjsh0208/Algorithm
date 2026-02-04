import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        //PriorityQueue
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) ->{
            int first = Math.abs(o1);
            int second = Math.abs(o2);

            if(first == second){
                return o1 > o2 ? 1 : -1; //절대값이 같으면 음수 우선으로 정렬
            }else{
                return first - second; // 절대값이 다르면 절대값 기준으로 정렬
            }
        });


        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(queue.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(queue.poll());
                }
            }else{
                queue.offer(num);
            }
        }
        br.close();
    }
}