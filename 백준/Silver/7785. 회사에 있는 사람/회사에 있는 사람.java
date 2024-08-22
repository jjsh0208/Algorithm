import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        HashMap<String,String> map = new HashMap<>();

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
                map.put(st .nextToken(), st.nextToken());
            
        }

        List<String> ary = new ArrayList<>();
        for (Map.Entry<String, String> s : map.entrySet()) {
            if (s.getValue().equals("enter")) {
                ary.add(s.getKey());
            }
        }

        Collections.sort(ary, Collections.reverseOrder());

        for (String string : ary) {
            System.out.println(string);
        }


        br.close();
    }
}