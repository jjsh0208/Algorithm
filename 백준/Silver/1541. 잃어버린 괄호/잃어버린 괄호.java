import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String read = br.readLine();
        int answer = 0;

        String[] arr = read.split("-");


        for(int i = 0; i < arr.length; i++){
            int sum = customSum(arr[i]);

            if(i == 0){
                answer += sum;
            }else{
                answer -= sum;
            }
        }


        System.out.println(answer);

    }

    private static int customSum(String s) {
        String[] part = s.split("[+]");

        int sum = 0;
        for(int i = 0; i < part.length; i++){
            sum += Integer.parseInt(part[i]);
        }

        return sum;
    }


}