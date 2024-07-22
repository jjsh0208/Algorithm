import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        int h = 0;
        int[] number = new int[3]; //1~ 1000 사이의 수를 저장할 공간


        for (int i = 1; i <= n; i++) {
            if (0 < i && i < 100) {
                h = i;
            }else if (i == 1000) break;
            else{
                int t = i;
                int index = 0; //배열의 인덱스로 사용할 정수
                while(t > 0){
                    number[index] = t % 10;
                    t /= 10;
                    index++; 
                }
                if (number[0] - number[1] == number[1] - number[2])  h++;
            }
        }

        bw.write(String.valueOf(h));

        bw.flush();
        bw.close();
        br.close();
        
    }
}