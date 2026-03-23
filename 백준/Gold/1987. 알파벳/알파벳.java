import java.util.*;
import java.io.*;

public class Main {

    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};

    static int r,c, result;
    static char[][] map;
    static Set<Character> visited = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();

        map = new char[r][c];

        for(int i = 0; i < r; i++){
            String line = sc.next();
            for(int j = 0; j < c; j++){
                map[i][j] = line.charAt(j);
            }
        }

        result = 0;

        DFS(0,0,1);

        System.out.println(result);
    }

    private static void DFS(int y, int x ,int cnt) {

        result = Math.max(result, cnt);

        visited.add(map[y][x]);

        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(mapCheck(ny,nx) && !visited.contains(map[ny][nx])){
                DFS(ny,nx, cnt + 1);
            }
        }
        visited.remove(map[y][x]);

    }

    private static boolean mapCheck(int ny, int nx){
        return ny >= 0 && ny < r && nx >= 0 && nx < c;
    }
}