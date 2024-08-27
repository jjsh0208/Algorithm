import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    private static int[] ary; //체스판
    private static int n; //입력받을 변수
    private static int cnt = 0; //확인용 카운트

    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        ary = new int[n];
        

        nQueen(0);
        System.out.println(cnt);        
    }

    private static void nQueen(int depth) {
        
        if (depth == n) { //입력받은 크기와 같으면 반환 (체스판의 크기 만큼 (가로, 세로))
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {

            ary[depth] = i;

            if (Possibility(depth)) {
                nQueen(depth + 1);
            }
            
        }

    }

    private static boolean Possibility(int col) {
        
        for (int i = 0; i < col; i++) {
            if (ary[col] == ary[i]) {
                return false;
            }else if (Math.abs(col - i) == Math.abs(ary[col] - ary[i])) {
                return false;
            }
        }

        return true;
    }
}