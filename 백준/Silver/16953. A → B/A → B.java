import java.util.*;
import java.io.*;

public class Main {

    static int a, b, answer;
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        BFS(a);

        if(check){
            System.out.println(answer);
        }else{
            System.out.println(-1);
        }

        br.close();
    }

    private static void BFS(int a) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(1,a));

        while(!queue.isEmpty()){
            Node node = queue.poll();

            long num = node.num;

            if(num == b){
                check = true;
                answer = node.cnt;
                return;
            } else if(num > b) continue;

            queue.add(new Node(node.cnt + 1,num * 2));
            queue.add(new Node(node.cnt + 1,num * 10 + 1));
        }
    }

     static class Node{
        int cnt;
        long num;

        Node(int cnt, long num){
            this.cnt = cnt;
            this.num = num;
        }
        
    }

}