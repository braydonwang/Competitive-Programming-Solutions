import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt();
		String str = next();
		str = " " + str;
		int[] pre = new int[n+1], suf = new int[n+2], last = new int[26];
		for (int i = 1; i <= n; i++) {
			char c = str.charAt(i);
			int ch = str.charAt(i) - 'A';
			if (last[ch] == 0) {
				pre[i]++;
			} else {
				for (int j = last[ch]+1; j < i; j++) {
					if (str.charAt(j) < c) {
						pre[i]++;
						break;
					}
				}
			}
			last[ch] = i;
			pre[i] += pre[i-1];
		}
		last = new int[n+1];
		for (int i = n; i >= 1; i--) {
			char c = str.charAt(i);
			int ch = str.charAt(i) - 'A';
			if (last[ch] == 0) {
				suf[i]++;
			} else {
				for (int j = i+1; j < last[ch]; j++) {
					if (str.charAt(j) < c) {
						suf[i]++;
						break;
					}
				}
			}
			last[ch] = i;
			suf[i] += suf[i+1];
		}
		for (int i = 0; i < q; i++) {
			System.out.println(pre[readInt()-1] + suf[readInt()+1]);
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
