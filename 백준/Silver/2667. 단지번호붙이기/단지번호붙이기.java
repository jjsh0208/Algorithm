import java.util.*;
import java.io.*;

public class Main {

    static int n, cnt, totalCnt;
    static int[][] map;
    static ArrayList<Integer> result;

    // 방향 배열 세팅 (상, 하, 좌, 우)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        result = new ArrayList<>();
        map = new int[n][n];
        cnt = 0;
        totalCnt = 0;

        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 1) {
                    cnt = 0;
                    DFS(i,j);
                    totalCnt++;
                    result.add(cnt);
                }
            }
        }

        Collections.sort(result);

        System.out.println(totalCnt);

        for(int i : result){
            System.out.println(i);
        }

    }

    private static void DFS(int row, int col) {

        map[row][col] = 0;

        cnt++;

        for(int i = 0; i < 4; i++){
            int newRow = row + dy[i];
            int newCol = col + dx[i];

            if(check(newRow,newCol) && map[newRow][newCol] == 1){
                DFS(newRow,newCol);
            }
        }

    }

    private static boolean check(int row, int col){
        return row >= 0 && row < n && col >= 0 && col < n;
    }

}