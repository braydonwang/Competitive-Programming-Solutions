import java.util.*;
import java.io.*;
public class CCC2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] array;
    public static void main(String[] args) throws IOException {
        int n = readInt(), q = readInt();
        array = new int[n+1];
        long[] size = new long[n+1], resource = new long[n+1];
        for (int i = 1; i <= n; i++) {
            array[i] = i;
        }
        long[] a = new long[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = readInt();
            size[i] = 1; resource[i] = a[i];
        }
        for (int i = 0; i < q; i++) {
            int num = readInt();
            if (num == 1) {
                int x = readInt(), y = readInt();
                int fx = find(x), fy = find(y);
                if (fx != fy) {
                    size[fx] += size[fy];
                    resource[fx] += resource[fy];
                    union(fx,fy);
                }
            } else if (num == 2) {
                int x = readInt();
                System.out.println(size[find(x)]);
            } else {
                int x = readInt();
                System.out.println(resource[find(x)]);
            }
        }
    }
    public static int find(int v) {
        if (array[v] == v) {
            return v;
        }
        else {
            int result = find(array[v]);
            array[v] = result;
            return result;
        }
    }
    public static void union(int a, int b) {
        int arep = find(a);
        int brep = find(b);
        array[brep] = arep;
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
