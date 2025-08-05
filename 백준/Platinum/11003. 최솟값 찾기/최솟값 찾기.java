import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {    

    static int N , L;
    static Deque<Node> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        deque = new LinkedList<>();
    
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< N; i++){
            
            int num = Integer.parseInt(st.nextToken());
        
            while(!deque.isEmpty() && deque.getLast().value > num){
                deque.removeLast();
            }
            deque.addLast(new Node(num , i));

            if(deque.getFirst().index <= i - L){
                deque.removeFirst();
            }
            bw.write(deque.getFirst().value + " ");
        }

        bw.flush();
        bw.close();
        br.close();

    }



    static class Node{
        public int value;
        public int index;

        Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
}