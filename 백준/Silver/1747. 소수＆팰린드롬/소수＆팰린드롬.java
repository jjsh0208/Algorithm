import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        br.close();

        int[] arr = new int[1003002];

        for(int i = 2; i < arr.length; i++){
            arr[i] = i;
        }

        for(int i = 2; i < Math.sqrt(arr.length); i++){
            if(arr[i] == 0) continue;

            for(int j = i + i; j < arr.length; j = j + i){
                arr[j] = 0;
            }
        }

        int i = n;
        while(true){
            if(arr[i] != 0){;
                int result = arr[i];
                if(isPalindrome(result)){
                    System.out.println(result);
                    break;
                }
            }
            i++;
        }
    }

    private static boolean isPalindrome(int num) {
        char[] number = String.valueOf(num).toCharArray();

        int s = 0;
        int e = number.length - 1;

        while( s < e){
            if(number[s] != number[e]) return false;
            s++;
            e--;
        }

        return true;
    }
}