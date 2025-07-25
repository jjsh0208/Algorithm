import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {    

    static int n;
    static String str;
    static int res = 0;
    static int[] alphabet = new int[26];
    static int[] check;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 문자열 개수 입력
        int n = Integer.parseInt(br.readLine());
        
        // 기준 문자열
        String str = br.readLine();
        
        for(int i = 0; i < str.length(); i++){
            int idx = str.charAt(i) - 'A'; //- 65
            alphabet[idx]++;
        }

        for(int i = 0; i < n -1; i++){
            check = alphabet.clone();
            String curr = br.readLine();

            // 길이 차이가 1 이상인 경우는 같을 수가 없다
            if(curr.length() - str.length() > 1) continue;

            int cnt = 0;

            for(int j = 0; j < curr.length(); j++){
                int idx = curr.charAt(j) -  'A';


                if(check[idx] > 0 ){
                    cnt++;
                    check[idx]--;
                }
            }

            // 기준 값보다 길이가 1 작은 경우
            if(str.length() - 1 == curr.length()){
                if(cnt == curr.length()) res++;
            }

            // 기준 값보다 길이가 1 큰 경우
            else if(str.length() + 1 == curr.length()){
                if(cnt == str.length()) res++;
            }

            else if(str.length() == curr.length()){

                if(cnt == str.length()) res++;

                else if(cnt == str.length() - 1) res++;
            }

        }

        System.out.print(res);



    }
}
