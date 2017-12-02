package suanfa;


import java.io.IOException;
import java.util.Stack;

/**
 * Author ： Martin
 * Date : 17/9/25
 * Description :
 * Version : 2.0
 */
public class Chapter1 {
    public static boolean isPalindrom(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }


    public static Integer calculator(String str) {

        Stack<Character> ops = new Stack<>();
        Stack<Integer> values = new Stack<>();

        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') ;
            else if (str.charAt(i) == '+') {
                ops.push(str.charAt(i));
                values.push(sum);
            }
            else if (str.charAt(i) == '-') {
                ops.push(str.charAt(i));
                values.push(sum);
            }
            else if (str.charAt(i) == '*') {
                ops.push(str.charAt(i));
                values.push(sum);
            }
            else if (str.charAt(i) == '/') {
                ops.push(str.charAt(i));
                values.push(sum);
            }
            else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                sum = sum * 10 + Integer.parseInt(String.valueOf(str.charAt(i)));
            }
            else if (str.charAt(i) == ')') {
                Character op = ops.pop();
                Integer val = values.pop();
                if (op == '+')  val = val + sum;
                else if (op == '-') val = val - sum;
                else if (op == '*') val = val * sum;
                else if (op == '/') val = val  / sum;
                values.push(val);
            }
        }

        return values.pop();
    }

    private static class UF {
        private int[] id;
        private int count;

        public UF(int N) {
            count = N;
            id = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
            }
        }

        public int count() {
            return count;
        }

        public boolean connected(int p, int q) {
            return true;
        }

        public int findFirst(int p) {
            return id[p];
        }

        public void unionFirst(int p, int q) {
            int PID = findFirst(p);
            int QID = findFirst(q);

            if (PID == QID) return;
            for (int i = 0; i < id.length; i++) {
                if (id[i] == PID) id[i] = QID;
            }
            count--;
        }

        public int findSecond(int p) {
            while (p != id[p]) p = id[p];
            return p;
        }

        public void unionSecond(int p, int q) {
            int pRoot = findSecond(p);
            int qRoot = findSecond(q);
            if (pRoot == qRoot) return;
            id[pRoot] = qRoot;
            count--;
        }
    }

    public static void main(String[] args) throws IOException {
        int N = System.in.read();
        UF uf = new UF(N);

    }

}
