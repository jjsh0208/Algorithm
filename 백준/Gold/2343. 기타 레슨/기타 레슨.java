import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        int start = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (start < arr[i]) start = arr[i];
            end += arr[i];
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                if (sum + arr[i] > mid) {
                    cnt++;
                    sum = 0;
                }
                sum += arr[i];
            }

            if (sum != 0) {
                cnt++;
            }
            if (cnt > m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        System.out.println(start);

    }
}



