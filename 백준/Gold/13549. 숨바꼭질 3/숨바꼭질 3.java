import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        bfs(n,m);
    }

    private static void bfs(int n, int m) {
        Deque<Node> queue = new LinkedList<>();
        queue.add(new Node(0,n));

        boolean[] visited = new boolean[100001];

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.num < 0 || node.num > 100000 || visited[node.num]) {
                continue;
            }

            visited[node.num] = true;

            if(node.num == m){
                System.out.println(node.time);
                return;
            }

            queue.addFirst(new Node(node.time,node.num * 2));

            queue.addLast(new Node(node.time + 1,node.num - 1));
            queue.addLast(new Node(node.time + 1,node.num + 1));
        }
    }

    static class Node{
        int time;
        int num;

        Node(int time, int num){
            this.time = time;
            this.num = num;
        }
    }
}