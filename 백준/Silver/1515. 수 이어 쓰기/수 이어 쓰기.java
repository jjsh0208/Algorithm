import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {	
 	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 수를 1부터 키워가며 n의 0번째 자리 수 부터 비교해가며 앞으로 전진
        // 최대 3000까지 키웠음에도 같은걸 못찾으면 현재까지 진행한 수 중에서 최소값 출력

        String n = br.readLine();

        int pointer = 0;
        int base = 0;

        while(base++ <= 30000){
            String b = String.valueOf(base);

            for(int i = 0; i < b.length(); i++){
                if(n.charAt(pointer) ==  b.charAt(i)){
                    pointer++;
                }
                if (pointer == n.length()) {
                    System.out.println(base);
                    return;
                }
            }
        }

	}
}