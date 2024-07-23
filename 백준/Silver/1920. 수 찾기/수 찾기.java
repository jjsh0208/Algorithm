import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int ary[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ary = new int[n];


        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < ary.length; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ary);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");

        for (int i = 0; i < m; i++) {
            if (binarySearch(Integer.parseInt(st.nextToken())) != -1) {
                bw.write(String.valueOf(1));
                bw.newLine();
            }else{
                bw.write(String.valueOf(0));
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }

    private static int binarySearch(int key){
        int left = 0; //왼쪽 인덱스;
        int right = ary.length -1; //오른쪽 인덱스

        while(left <= right){
            int mid = (left + right) / 2;


            if (key < ary[mid]) {
                right = mid - 1;
            }
            else if (key > ary[mid]) {
                left = mid + 1;
            }else{
                return mid;
            }

        }

        return -1;
    }

}