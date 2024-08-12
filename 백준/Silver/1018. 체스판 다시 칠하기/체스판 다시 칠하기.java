import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
 private static int getSolustion(int startRow, int startCol, String[] board) {
        String[] orgBoard = {"WBWBWBWB", "BWBWBWBW"};
        int whiteSol = 0; //화이트 기준 변경값

        for (int i = 0; i < 8; i++) {
            int row = startRow + i;
            for (int j = 0; j < 8; j++) {
                int col = startCol + j;
                //정답지와 같은지 비교한다 
                //정답지가 2개 기에 %2 를하여 에러를 방지
                //자른 체스판과 정답 체스판이 같은지 확인 후 다르면 whileSol을 +1 한다.
                if (board[row].charAt(col) != orgBoard[row % 2].charAt(j)) whiteSol++;
            }
        }

        //블랙 체스판과 화이트 체스판의 최소 비용은 64안에서 정해진다.
        //예) while가 8x8 크기의 체스판에서 30 이면 black 은 34 이다.
        //while만 구했기 때문에 64 - whitesol을 하면 블랙의 최소 비용
        return Math.min(whiteSol, 64 - whiteSol);
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        //입력받기
        String[] board= new String[row];

        //세로 높이 만큼 한줄로 입력받는다.
        for (int i = 0; i < row; i++) board[i] = br.readLine(); 

        //1. 체스판 만들기
        //8x8 크기로 체스판을 자르고 시작해야하기에 -8
        int sol = Integer.MAX_VALUE;
        for (int i = 0; i <= row - 8; i++) {
            for (int j = 0; j <= col - 8; j++) {

                //2. 현재 체스판의 최소 비용 구하기
                int curSol = getSolustion(i,j,board);
                
                //3. 전체 최적의 값과 비교하여 갱신하기
                // 최소값을 col에 저장한다.
                if (sol > curSol) sol = curSol; 
            }
        }

        bw.write(String.valueOf(sol));
        bw.flush();
        bw.close();
        br.close();
    }

   
}