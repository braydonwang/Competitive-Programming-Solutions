import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		String str = next();
		int n = str.length();
		str = "!" + str;
		int[] a = new int[n+1], b = new int[n+1], c = new int[n+1];
		for (int i = 1; i <= n; i++) {
			if (str.charAt(i) == 'A') {
				a[i]++;
			} else if (str.charAt(i) == 'B') {
				b[i]++;
			} else {
				c[i]++;
			}
			a[i] += a[i-1]; b[i] += b[i-1]; c[i] += c[i-1];
		}
		int na = a[n], nb = b[n], nc = c[n];
		for (int i = 1; i <= n; i++) {
			if (i >= na + nb) {
				solve(a,b,c,na,nb,i); solve(b,a,c,nb,na,i);
			} 
			if (i >= na + nc) {
				solve(a,c,b,na,nc,i); solve(c,a,b,nc,na,i);
			}
			if (i >= nb + nc) {
				solve(b,c,a,nb,nc,i); solve(c,b,a,nc,nb,i);
			}
		}
		System.out.println(ans);
	}
	static void solve(int[] x, int[] y, int[] z, int nx, int ny, int i) {
		int s2 = i - ny + 1, e2 = i, e1 = s2 - 1, s1 = e1 - nx + 1;
		//System.out.println(s1 + " " + e1 + " " + s2 + " " + e2);
		int nonx = y[e1] - y[s1-1] + z[e1] - z[s1-1], nony = x[e2] - x[s2-1] + z[e2] - z[s2-1];
		int overlap = Math.min(x[e2] - x[s2-1], y[e1] - y[s1-1]);
		ans = Math.min(ans, nonx + nony - overlap);
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
