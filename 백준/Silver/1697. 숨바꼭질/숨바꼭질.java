import java.util.*;
import java.io.*;

public class Main {

    static int n, k;
    static int[] time = new int[100001];
    static boolean[] visited = new boolean[100001];

    // 빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
    // 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

    // 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        //수빈이가 5-10-9-18-17 순으로 가면 4초만에 동생을 찾을 수 있다.

        // 1초를 한번의 재귀라고 칭함
        n = sc.nextInt();
        k = sc.nextInt();

        BFS(n);

    }

    private static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            if (current == k) {
                System.out.println(time[current]);
                break;
            }

            int[] nextTime = {current - 1, current + 1, current * 2};


            for(int next : nextTime){
                if(rangeCheck(next) && !visited[next]){
                    visited[next] = true;
                    time[next] = time[current] + 1;
                    queue.add(next);
                }
            }
        }

    }


    private static boolean rangeCheck(int num){
        return num >= 0 && num <= 100000;
    }

}