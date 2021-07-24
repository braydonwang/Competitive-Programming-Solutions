import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int count;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		int[] f = new int[n], s = new int[n], cereal = new int[m+1], ans = new int[n];
		for (int i = 0; i < n; i++) {
			f[i] = readInt(); s[i] = readInt();
		}
		for (int i = n-1; i >= 0; i--) {
			solve(i,f[i],cereal,s);
			ans[i] = count;
		}
		for (int i = 0; i < n; i++) {
			System.out.println(ans[i]);
		}
	}
	static void solve(int ind, int flavor, int[] cereal, int[] s) {
		if (cereal[flavor] == 0) {
			count++;
			cereal[flavor] = ind;
		} else if (cereal[flavor] > ind) {
			int temp = cereal[flavor];
			cereal[flavor] = ind;
			if (s[temp] != flavor) {
				solve(temp,s[temp],cereal,s);
			}
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
