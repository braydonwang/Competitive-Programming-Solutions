import java.util.*;
import java.io.*;
public class CCC2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] array;
    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt(), t = readInt();
        double[] v = new double[n+1];
        int[] w = new int[n+1];
        for (int i = 1; i <= n; i++) {
            w[i] = readInt();
        }
        int count = 0;
        double[] dp = new double[t+1];
        for (int i = 0; i < m; i++) {
            int x = readInt();
            if (x == 0) {
                count++;
            }
            for (int j = 0; j < x; j++) {
                int y = readInt();
                v[y] += 1.0/x;
            }
        }
        Arrays.fill(dp, count);
        for (int i = 1; i <= n; i++) {
            for (int j = t; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-w[i]] + v[i]);
            }
        }
        System.out.printf("%.2f", dp[t]);
        System.out.println();
    }
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
