import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long f[], inv[], mod = (long)1e9+7;
	public static void main(String[] args) throws IOException {
		int n = readInt(); f = new long[n+1]; inv = new long[n+1];
		init();
		int[] a = new int[n+1], c = new int[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = readInt(); c[a[i]]++;
		}
		Arrays.sort(a,1,n+1);
		int d = readInt();
		for (int i = 0; i < d; i++) {
			int k = readInt();
			int num = a[k];
			int lo = 1, hi = k, ans = k;
			while (lo <= hi) {
				int mid = (lo + hi) / 2;
				if (a[mid] < num) {
					lo = mid + 1;
				} else {
					ans = mid;
					hi = mid - 1;
				}
			}
			int N = c[num], K = k - ans + 1;
			System.out.println(choose(N,K));
		}
	}
	static long choose(int n, int k) {
		return f[n] * inv[k] % mod * inv[n-k] % mod;
	}
	static void init() {
        f[0] = 1; inv[0] = 1;
        for (int i = 1; i < f.length; i++) f[i] = f[i-1] * i % mod;
        for (int i = 1; i < f.length; i++) inv[i] = qpow(f[i], mod-2, mod);
    }
    static long qpow(long x, long exp, long mod) {
        if (exp == 0) return 1;
        long t = qpow(x,exp/2,mod);
        t = t * t % mod;
        return (exp & 1) != 0? t * x % mod: t;
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
