import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{

    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] ary = new int[9];
        int sum = 0;

        for (int i = 0; i < ary.length; i++) {
            int n = Integer.parseInt(br.readLine());
            ary[i] = n;
            sum += n;
        }

        Arrays.sort(ary);
        int a = 0 , b = 0; //난쟁이가 아닌 두명을 담기 위한 변수 a, b

      for (int i = 0; i < ary.length - 1; i++) { //0 ~ 8 까지 마지막은 검사할 필요가없다.
        for (int j = i + 1; j < ary.length; j++) {
            a = ary[i];
            b = ary[j];
            if ((sum - a - b) == 100) {
                for (int k = 0; k < ary.length; k++) {
                    if (ary[k] == a || ary[k] == b) {
                        continue;
                    }
                    System.out.println(ary[k]);
                }
                return;
            }
        }
      }
    }
}