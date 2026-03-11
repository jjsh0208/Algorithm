import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long result = n;

        // 제곱근 까지만 진행
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) { // i 가 소인수 인지 확인한다.
                // 해당 소인수의 배수는 정답과 서로소가 아니니까 배제
                result = result - result / i; // 결과값 업데이트

                // 해당 소인수를 완전히 제거하기 위해 나눠버림
                // 그래야 혹여나 그 수의 배수가 나와서 소인수로 보는 실수를 없애기 위함 또 범위 줄이기
                while(n % i == 0){

                    n /= i;
                }
            }
        }

        if(n > 1){
            result = result - result / n;
        }
        System.out.println(result);
    }

}