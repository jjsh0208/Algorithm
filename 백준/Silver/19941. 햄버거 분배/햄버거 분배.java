import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {	
 	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 식탁의 길이
        int n = Integer.parseInt(st.nextToken());
        // 햄버거를 선택할 수 있는 길이
        int k = Integer.parseInt(st.nextToken());

        char[] c = br.readLine().toCharArray();

        int cnt = 0;
        A:for(int i = 0; i < c.length; i++){

            if(c[i] == 'P'){
                // 현재 값이 p 이면 k 만큼 앞에서부터 k만큼 뒤까지 검사
                // 햄버거가 존재하면 카운트를 증가하고 값을 변경한다.
                // 계속해서 검사할 수 있기떄문에 B for문을 멈춘다.
                B:for(int j = i - k; j <= i + k; j++){

                    if(j < 0 || j >= n) continue;

                    if(c[j] == 'H'){
                        cnt++;
                        c[j] = 'X';
                        break B;
                    }
                }
            }
        }

        System.out.println(cnt);

	}
}