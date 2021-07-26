import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long[][][] s;
	static Stack<Long> stack;
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt();
		s = new long[n+1][20][2];
		for (int i = 1; i <= n; i++) {
			s[i][0][0] = readLong();
			s[i][0][1] = i;
		}
		for (int i = 1; 1 << i <= n; i++) {
			for (int j = 1; j + (1 << i) - 1 <= n; j++) {
				if (s[j][i-1][0] < s[j+(1 << (i-1))][i-1][0]) {
					s[j][i][0] = s[j][i-1][0];
					s[j][i][1] = s[j][i-1][1];
				} else {
					s[j][i][0] = s[j+(1 << (i-1))][i-1][0];
					s[j][i][1] = s[j+(1 << (i-1))][i-1][1];
				}
			}
		}
		for (int i = 0; i < q; i++) {
			long v = readLong();
			int l = readInt(), r = readInt()+1;
			stack = new Stack<Long>();
			while (l != r) {
				r = (int) get(l,r-1);
			}
			while (!stack.isEmpty()) {
				v = v % stack.pop();
			}
			System.out.println(v);
		}
	}
	static long get(int l, int r) {
		int size = (int)(Math.log(r-l+1) / Math.log(2));
		if (s[l][size][0] < s[r-(1 << size)+1][size][0]) {
			stack.add(s[l][size][0]);
			return s[l][size][1];
		} else {
			stack.add(s[r-(1 << size)+1][size][0]);
			return s[r-(1 << size)+1][size][1];
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
