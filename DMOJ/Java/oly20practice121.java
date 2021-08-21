import java.util.*;
import java.io.*;
public class CCC2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = readInt();
        Pair[] l = new Pair[n+2];
        l[0] = new Pair(0,0);
        int[] r = new int[n+1], ans = new int[n+2];
        for (int i = 1; i <= n+1; i++) {
            l[i] = new Pair(readInt(),i);
        }
        for (int i = 1; i <= n; i++) {
            r[i] = readInt();
        }
        Arrays.sort(l); Arrays.sort(r);
        int[] suf = new int[n+3];
        for (int i = n+1; i >= 1; i--) {
            suf[i] = Math.max(suf[i+1], Math.max(l[i].val-r[i-1], 0));
        }
        /*System.out.println(Arrays.toString(suf));
        for (int i = 1; i <= n+1; i++) {
            System.out.print(l[i].val + " ");
        }
        System.out.println();
        for (int i = 1; i <= n; i++) {
            System.out.print(r[i] + " ");
        }
        System.out.println();*/
        int pre = 0;
        for (int i = 1; i <= n; i++) {
            ans[l[i].ind] = Math.max(pre, suf[i+1]);
            pre = Math.max(pre, Math.max(l[i].val-r[i],0));
        }
        ans[l[n+1].ind] = pre;
        for (int i = 1; i <= n+1; i++) {
            System.out.print(ans[i] + " ");
        }
    }
    static class Pair implements Comparable<Pair>{
        int val, ind;
        Pair(int val, int ind){
            this.val = val;
            this.ind = ind;
        }
        public int compareTo(Pair p) {
            return this.val - p.val;
        }
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
