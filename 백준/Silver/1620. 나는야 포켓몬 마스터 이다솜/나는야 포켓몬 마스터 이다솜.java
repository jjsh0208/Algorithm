import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String,Integer> pokemon_int = new HashMap<String,Integer>();
        HashMap<Integer,String> pokemon_string = new HashMap<Integer,String>();

        for (int i = 1; i <= n; i++) {
            String p_name = br.readLine();
            pokemon_string.put(i, p_name);
            pokemon_int.put(p_name, i);
        }

        for (int i = 0; i < m; i++) {
            String p = br.readLine();

            if(isNum(p)){
                bw.write(pokemon_string.get(Integer.parseInt(p)) + '\n');
            }else{
                bw.write(String.valueOf(pokemon_int.get(p)) + '\n');
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isNum(String p) {
       
        for (int i = 0; i < p.length(); i++) {
            if(!Character.isDigit(p.charAt(i))){
                return false;
            }
       }
       return true;
    }
}