import java.util.*;
import java.io.*;
public class CCC2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++) {
        	a[i] = readInt();
        }
        double[] dp = new double[n+1];
        for (int i = 1; i <= n; i++) {
        	dp[i] = dp[i-1] + a[i];
        	if (i >= 2) {
        		dp[i] = Math.min(dp[i], dp[i-2] + Math.max(a[i], a[i-1]) + (Math.min(a[i], a[i-1]) / 2.0));
        	}
        	if (i >= 3) {
        		dp[i] = Math.min(dp[i], dp[i-3] + a[i] + a[i-1] + a[i-2] - Math.min(a[i], Math.min(a[i-1], a[i-2])));
        	}
        }
        System.out.printf("%.1f", dp[n]);
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
