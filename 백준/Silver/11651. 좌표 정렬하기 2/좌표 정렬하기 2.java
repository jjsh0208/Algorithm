import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] ary = new int[n][2];

   
        for (int i = 0; i < ary.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            ary[i][0] = Integer.parseInt(st.nextToken());
            ary[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ary, (e1, e2) -> {
            if (e1[1] == e2[1]) { //오름차순할 때 두 값이 같으면 두번 째 값을 비교
                return e1[0] - e2[0];
            }else{ // 값이 다르면 서로 비교해서 오름차순
               return e1[1] - e2[1];
            }
        });
        
        for (int i = 0; i < ary.length; i++) {
            System.out.println(ary[i][0] + " " + ary[i][1]);
        }

        br.close();
    }
}