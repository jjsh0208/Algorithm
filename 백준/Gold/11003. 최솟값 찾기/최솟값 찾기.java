import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Deque<Node> queue = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){

            int now = Integer.parseInt(st.nextToken());

            while(!queue.isEmpty() && queue.getLast().number > now){
                queue.removeLast();
            }
            queue.addLast(new Node(i,now));


            //범위에서 벗어난 값은 제거
            if(queue.getFirst().index <= i - l){ //  제일 작은 수의 인덱스가 현재 인덱스 - 범위값 보다 작으면 첫번째 값 제거
                queue.removeFirst();
            }

            sb.append(queue.getFirst().number + " ");
        }

        System.out.println(sb);
        br.close();
    }


    static class Node{
        int index;
        int number;

        Node(int index,int number){
            this.index = index;
            this.number= number;
        }
    }
}