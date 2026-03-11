import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        long min = sc.nextLong();
        long max = sc.nextLong();

        // 최대값과 최소값 차이만큼 배열 선언
        boolean[] check = new boolean[(int)(max - min + 1)];

        // 2의 제곱수인 4부터 max보다 작거나 같을때 까지
        for(long i = 2; i * i <= max; i++){
            // 현재 인덱스 제곱수
            long pow = i * i;

            // min 범위 내에서 현재 제곱수의 가장 작은 배수 찾기
            long start_index = min / pow;

            // 나머지가 있다는 건 딱 안 나누어떨어졌다는 뜻이므로,
            // 몫에 1을 더해줘야 min보다 크거나 같은 최초의 배수를 찾을 수 있습니다.
            // 예: 10 % 4 != 0 이므로 start_index를 3으로 만듦. (3 * 4 = 12부터 시작)
            if(min % pow != 0){
                start_index++;
            }

            // 제곱수의 배수를 모두 걸러냄
            for(long j = start_index; pow * j <= max; j++){
                // (j * pow)는 현재 걸러낼 실제 숫자입니다. (예: 12, 16, 20 ...)
                check[(int) ((j * pow) - min)] = true;
            }
        }

        int cnt = 0;

        for(int i = 0; i <= max - min; i++){
            if(!check[i]){
                cnt++;
            }
        }

        System.out.println(cnt);
    }

}