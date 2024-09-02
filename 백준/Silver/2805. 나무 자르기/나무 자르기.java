import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] ary = new int[n];

        st = new StringTokenizer(br.readLine()," ");

        int max = 0;
        int min = 0;

        for (int i = 0; i < n; i++) {
            ary[i] =Integer.parseInt(st.nextToken());

            if (max <= ary[i]) {
                max = ary[i];
            }
        }

        // Arrays.sort(ary);

        while (min < max) {
            int mid = (min + max) / 2;
            
            long sum = 0;

            for (int tree : ary) {
                if((tree - mid) > 0) sum += (tree - mid);
            }


            if(sum < m){ //자른 나무의 합이 가져가고자하는 길이보다 작으면 높이를 낮춰야한다.
                max = mid;
            }else{//자른 나무의 합이 가져가고자하는 길이보다 크면 높이를 높여햔다. (하한선을 높인다.)
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }

    
}