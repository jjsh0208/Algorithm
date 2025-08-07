import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {    

    static int n;
    static Data[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new Data[n];

        for(int i = 0; i < n; i++){
            arr[i] = new Data(i , Integer.parseInt(br.readLine()));
        }

        Arrays.sort(arr);


        int answer = 0;
        for(int i = 0; i < n; i++){
            if(answer < (arr[i].index - i)){
                answer = arr[i].index  - i;
            }
        }

        System.out.println(answer + 1);

        br.close();

    }

    static public class Data implements Comparable<Data>{
        public int index;
        public int value;

        Data(int index, int value){
            this.index = index;
            this.value = value;
        }


        @Override
        public int compareTo(Data d){
            return this.value - d.value;
        }
    }

} 