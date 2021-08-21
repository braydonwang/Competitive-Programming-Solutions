import java.util.*;
import java.io.*;
public class CCC2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int[] array = new int[n], sorted = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = readInt();
            sorted[i] = array[i];
        }
        Arrays.sort(sorted);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] != sorted[i]) {
                count++;
                if (count > 2) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
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
