import java.util.Stack;
import java.util.Arrays;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> stack = new Stack<>();

        int[] up = new int[n];
        int[] down = new int[n];

        // up[i]는 i행의 위쪽 행 인덱스, down[i]는 아래쪽 행 인덱스
        for (int i = 0; i < n; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }

        for (String c : cmd) {
            if (c.startsWith("C")) {
                stack.push(k);
                if (up[k] != -1) down[up[k]] = down[k];
                if (down[k] != n) up[down[k]] = up[k];

                // 삭제 후 다음 위치 결정 (마지막 행이면 위로, 아니면 아래로)
                k = (down[k] == n) ? up[k] : down[k];
            } else if (c.startsWith("Z")) {
                int r = stack.pop();
                if (up[r] != -1) down[up[r]] = r;
                if (down[r] != n) up[down[r]] = r;
            } else {
                String[] s = c.split(" ");
                int x = Integer.parseInt(s[1]);

                for (int i = 0; i < x; i++) {
                    k = s[0].equals("U") ? up[k] : down[k];
                }
            }
        }

        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        for (int i : stack) {
            answer[i] = 'X';
        }

        return new String(answer);
    }
}
