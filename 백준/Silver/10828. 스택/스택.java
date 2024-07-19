import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {
    static LinkedList<Integer> stack = new LinkedList<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {        
        int n = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < n; i++) {
            String text = br.readLine();
            if (text.startsWith("push")) {
                String[] parts = text.split(" ");
                push(Integer.parseInt(parts[1]));
            } else if (text.equals("pop")) {
                pop();
            } else if (text.equals("size")) {
                size();
            } else if (text.equals("empty")) {
                empty();
            } else if (text.equals("top")) {
                top();
            }
        }

        bw.flush();
        bw.close();
    }

    private static void empty() throws IOException {
        bw.write(stack.isEmpty() ? "1" : "0");
        bw.newLine();
    }

    private static void size() throws IOException {
        bw.write(String.valueOf(stack.size()));
        bw.newLine();
    }

    private static void pop() throws IOException {
        if (stack.isEmpty()) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(stack.removeLast()));
        }
        bw.newLine();
    }

    private static void top() throws IOException {
        if (stack.isEmpty()) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(stack.getLast()));
        }
        bw.newLine();
    }

    private static void push(int num) {
        stack.add(num);
    }
}