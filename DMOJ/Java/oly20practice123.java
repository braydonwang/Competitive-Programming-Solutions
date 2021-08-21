import java.util.*;
import java.io.*;
public class CCC2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        String str = next();
        int n = str.length();
        long total = 0, temp = 9;
        for (int i = 1; i < n; i += 2) {
            total += temp;
            temp *= 100;
        }
        if (n % 2 == 0) {
            System.out.println(total);
        } else {
            total += Long.parseLong(str) - (long)Math.pow(10, n-1) + 1;
            System.out.println(total);
        }
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
