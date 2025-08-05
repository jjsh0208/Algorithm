import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {    

    static int S , P;
    static int[] checkArr;
    static int[] myArr;
    static int check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        char[] A = new char[S];
        checkArr = new int[4]; // 체크할 문자 횟수
        myArr = new int[4]; // 검사할 문자 횟수

        check = 0;

        int answer = 0;

        A = br.readLine().toCharArray();
        
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 4; i++){
            checkArr[i] = Integer.parseInt(st.nextToken());

            if(checkArr[i] == 0) check++;
        }

        for(int i = 0; i < P; i++){ // 초기 앞자리 처리
            Add(A[i]);
        }

        if(check == 4) answer++;


        for(int i = P; i < S; i++){
            int j = i - P;

            Add(A[i]);
            Remove(A[j]);

            if(check == 4) answer++;
        }
        System.out.println(answer);
        br.close();

    }

    private static void Add(char c){
        switch(c){

            case 'A':
                myArr[0]++;
                if(myArr[0] == checkArr[0])
                    check++;
                break;
        
            case 'C':
                myArr[1]++;
                if(myArr[1] == checkArr[1])
                    check++;
                break;

            case 'G':
                myArr[2]++;
                if(myArr[2] == checkArr[2])
                    check++;
                break;

            case 'T':
                myArr[3]++;
                if(myArr[3] == checkArr[3])
                    check++;
                break;
            }
    }


    private static void Remove(char c){
        switch(c){
            case 'A':
            if(myArr[0] == checkArr[0])
                check--;
            myArr[0]--;
            break;

            case 'C':
            if(myArr[1] == checkArr[1])
                check--;
            myArr[1]--;
            break;

            case 'G':
            if(myArr[2] == checkArr[2])
                check--;
            myArr[2]--;
            break;

            case 'T':
            if(myArr[3] == checkArr[3])
                check--;
            myArr[3]--;
            break;
        

        }
    }
}