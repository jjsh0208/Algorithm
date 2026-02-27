import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int[] s = {0,5,5,5,5,5};
    static int[][] map = new int[10][10]; // 종이판
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 10; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0,0);

        if(result == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }

    private static void backtracking(int xy,int cnt) {
        if(xy == 100){
            result = Math.min(result, cnt);
            return;
        }

        int x = xy % 10;
        int y = xy / 10;

        if(result <= cnt) return;

        if(map[y][x] == 1){
            for(int i = 5; i > 0; i--){
                if(s[i] > 0 && check(x,y,i)){
                    s[i]--; // 해당 크기 종이 수 감소
                    fill(x,y,i,0); // 종이 붙이기 1을 0으로 변경
                    backtracking(xy + 1,cnt + 1);
                    s[i]++;
                    fill(x,y,i,1);
                }
            }
        }else{
            backtracking(xy + 1,cnt);
        }
    }

    private static void fill(int x, int y, int size, int swap) {
        for(int i = y; i < y + size; i++){
            for(int j = x; j < x + size; j++){
                map[i][j] = swap;
            }
        }
    }

    private static boolean check(int x, int y,int size) {
        if(x + size > 10 || y + size > 10) return false; // 현재 크기를 더했을 때 맵을 벗어나는지 검사
        for(int i = y; i < y + size; i++){
            for(int j = x; j < x + size; j++){
                if(map[i][j] != 1) return false;
            }
        }
        return true;
    }


}