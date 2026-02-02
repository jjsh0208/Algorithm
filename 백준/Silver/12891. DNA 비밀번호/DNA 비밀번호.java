import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    static int[] checkArr;
    static int[] myArr;
    static int check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int result = 0;

        char[] arr = new char[s];

        checkArr = new int[4];
        myArr = new int[4];

        check = 0;

        arr = br.readLine().toCharArray(); // DNA 문자열 입력받음


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken()); // 문자열에 포함돼야 할 문자의 최소 개수
            if (checkArr[i] == 0) check++; // 최소개수 0 이면 그 문자는 기본적으로 조건 만족이기 때문에 check++
        }

        for (int i = 0; i < p; i++) { // 첫번째 위치부터 부분 문자열읠 끝까지 현재 배열에 추가한다.
            Add(arr[i]);
        }

        if(check == 4){ // check의 수가 4이면 현재 윈도우에서는 최소조건을 만족해서 result++
            result++;
        }

        // 슬라이딩 윈도우
        for(int i = p; i < s; i++){ // 다음 슬라이딩 윈도우 시작 부분 문자열의 길이부터 시작
            int j = i - p; // 현재 길이 - 부분 문자열의 길이
            Add(arr[i]); // 현재 위치 추가
            Remove(arr[j]); // 현재 위치 제거
            if(check == 4) result++; // 4종류의 문자의 개수 조건을 모두 충족하면 result++;
        }

        System.out.println(result);
        br.close();
    }

    //A’, ‘C’, ‘G’, ‘T
    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) {
                    check++;
                }
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) {
                    check++;
                }
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) {
                    check++;
                }
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) {
                    check++;
                }
                break;
            default:
                break;

        }
    }

    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) {
                    check--;
                }
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) {
                    check--;
                }
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) {
                    check--;
                }
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) {
                    check--;
                }
                myArr[3]--;
                break;
            default:
                break;

        }
    }
}