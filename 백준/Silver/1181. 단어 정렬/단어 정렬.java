import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;


public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] ary = new String[n];


        for (int i = 0; i < ary.length; i++) {
            ary[i] = br.readLine();
        }

        Set<String> set = new LinkedHashSet<>(Arrays.asList(ary));

        ary = set.toArray(new String[0]);

        Arrays.sort(ary, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                
                //단어의 길이가 같은 경우
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }else{
                    return o1.length() - o2.length();
                }
            }
            
        
        });

        for (int i = 0; i < ary.length; i++) {
            System.out.println(ary[i]);
        }

        br.close();
    }
}