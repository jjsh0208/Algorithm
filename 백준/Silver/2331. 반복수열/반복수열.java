import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;
import java.io.*;

public class Main {

    static int a, p; // 탐색 여부 저장 배열
    static ArrayList<Integer> visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        visited = new ArrayList<>();
        DFS(a);

    }

    private static void DFS(int i) {
        if(visited.contains(i)) {

            System.out.println(visited.indexOf(i));
            return;
        }

        visited.add(i);

        int sum = 0;
        while(i > 0) { 
            sum += Math.pow(i % 10, p);
            i /= 10;
        }

        DFS(sum);
    }
}