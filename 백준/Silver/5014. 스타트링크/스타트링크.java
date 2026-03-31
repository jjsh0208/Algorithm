import java.util.*;
import java.io.*;

public class Main {

    static int f, s, g, u, d;
    static boolean check;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken()); // 총층
        s = Integer.parseInt(st.nextToken()); // 시작 층
        g = Integer.parseInt(st.nextToken()); // 도착 층
        u = Integer.parseInt(st.nextToken()); // up 버튼
        d = Integer.parseInt(st.nextToken()); // down 버튼

        visited = new boolean[f + 1];

        int result = bfs(s);

        if (result != -1) {
            System.out.println(result);
        } else {
            System.out.println("use the stairs");
        }
        br.close();
    }

    private static int bfs(int floor) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(floor, 0));
        visited[floor] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.floor == g) {
                return node.cnt;
            }

            int nextUp = node.floor + u;
            int nextDown = node.floor - d;

            if (isValid(nextUp) && !visited[nextUp]) {
                visited[nextUp] = true;
                queue.add(new Node(nextUp, node.cnt + 1));
            }

            if (isValid(nextDown) && !visited[nextDown]) {
                visited[nextDown] = true;
                queue.add(new Node(nextDown, node.cnt + 1));
            }
        }

        return -1;
    }

    private static boolean isValid(int floor) {
        return floor >= 1 && floor <= f;
    }

    static class Node {
        int floor;
        int cnt;

        Node(int floor, int cnt) {
            this.floor = floor;
            this.cnt = cnt;
        }
    }


}