import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {    

    static String n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = br.readLine();


        arr = new int[n.length()];

        for(int i = 0; i < n.length(); i++){
            arr[i] = Integer.parseInt(n.substring(i , i + 1));
        }

        for(int i = 0; i < arr.length; i++){
            
            int max = i;

            for(int j = i + 1; j < arr.length; j++){
                if( arr[j] > arr[max])
                    max = j;
            }

            if(arr[i] < arr[max]){
                int temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;
            }
        }
    

        for(int i : arr){
            System.out.print(i);
        }


        br.close();

    }

} 