import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int k = Integer.parseInt(st.nextToken()); //가지고있는 전선의 수
        int n = Integer.parseInt(st.nextToken()); //필요한 전선의 개수
        int[] ary = new int[k];


        long max = 0;
        long min = 0;

        for (int i = 0; i < k; i++) {
            ary[i] =Integer.parseInt(br.readLine());

            if (max <= ary[i]) {
                max = ary[i];
            }
        }

        max++;

        while (min < max) {
            long mid = (min + max) / 2; //배열의 정수 중에서 중간값을 구한다.
            
            long sum = 0;

            for (int tree : ary) { 
                
                //배열의 값을 중간값으로 나눴을 때 0보다 크면 나눠서 sum 더한다
               sum += (tree / mid);
            }


            if(sum < n){ //자른 전선의 수가 찾고자하는 수가보다 작으면 더 많이 잘라야하기 때문에 길이를 낮춘다.
                max = mid;
            }else{//자른 전선의 수의 찾고자하는 수보다 크면 하향선을 높인다.
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }

    
}