import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] array;
	static long[] fac;
	static int n;
	public static void main(String[] args) throws IOException {
		n = readInt();
		int k = readInt();
		String str = next();
		if (n == k) {
			System.out.println(Math.pow(26,k));
			return;
		}
		array = new int[26];
		fac = new long[20];
		fac[0] = 1;
		for (int i = 1; i < 20; i++) {
			fac[i] = i * fac[i-1];
		}
		for (int i = 0; i < n; i++) {
			if (str.charAt(i) != '*') {
				array[str.charAt(i)-'a']++;
			}
		}
		System.out.println(solve(k,0));
	}
	static long solve(int cnt, int num) {
		long total = 0;
		if (cnt == 0) {
			long temp = fac[n];
			for (int i = 0; i < 26; i++) {
				temp /= fac[array[i]];
			}
			return total += temp;
		}
		for (int i = num; i < 26; i++) {
			array[i]++;
			total += solve(cnt-1,i);
			array[i]--;
		}
		return total;
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
