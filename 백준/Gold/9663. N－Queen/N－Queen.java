import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n, cnt;
    static int[] map; // 체스판

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n];
        cnt = 0;

        backtracking(0);

        System.out.println(cnt);
    }

    private static void backtracking(int row) {
        if(row == n){
            cnt++;
            return;
        }

        for(int i = 0; i < n; i++){
            map[row] = i;
            if(check(row)){
                backtracking(row + 1);
            }
        }
    }

    private static boolean check(int row) {
        for(int i = 0; i < row; i++){
            if(map[i] == map[row]) return false;
            if(Math.abs(row - i) == Math.abs(map[i] - map[row])) return false;
        }
        return true;
    }


}