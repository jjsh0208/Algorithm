import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {    

    static int n;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        queue = new LinkedList<>();
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n ; i++){
            queue.add(i);
        }

        while(queue.size() != 1){
            queue.poll();
            queue.add(queue.poll());
        }

        System.out.println(queue.poll() + 1);

        br.close();

    }

} 