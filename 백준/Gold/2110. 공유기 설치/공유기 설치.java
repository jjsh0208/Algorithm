import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    static int[] ary ;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken()); //가지고있는 전선의 수
        int m = Integer.parseInt(st.nextToken()); //필요한 전선의 개수


        ary = new int[n];

        for (int i = 0; i < ary.length; i++) {
            ary[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ary);

        int low = 1;        //최소 거리가 가질 수 있는 최소값
        int hi = ary[n - 1] - ary[0] + 1; //최소 거리로 나올 수 있는 최대값
   
        while(low < hi){
            int mid = (low + hi) / 2;


            if (canIstall(mid) < m) { //설치가능한 공유기 수가 m 개수에 못미치면 거리를 좁혀야하기때문에 hi를 줄인다.
                hi = mid;
            }else{
                low = mid + 1;
            }

        }

        System.out.println(low - 1);
    }

    private static int canIstall(int distance) {
        
        int cnt = 1;
        int lastLocation = ary[0];

            for (int i = 1; i < ary.length; i++) {
                int location = ary[i];


                if (location - lastLocation >= distance) {
                cnt++;
                lastLocation = location;
            }
        }

        //현재 탐색하는 집의 위치와 직전의 설치했던 집의 위치간 거리가
        //최소거리 (distance)보다 크거나 같을 때 공유기 설치 개수를 늘리고 마지막 설치 위치를 갱신한다.

        return cnt;
    }

    
}