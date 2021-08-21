import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String str = next();
		int n = str.length();
		long[] hash1 = new long[n+2], hash2 = new long[n+2];
		long[] pow = new long[n+1];
		int base = 31;
		pow[0] = 1;
		for (int i = 1; i <= n; i++) {
			hash1[i] = hash1[i-1] * base + str.charAt(i-1);
			pow[i] = pow[i-1] * base;
		}
		for (int i = n; i >= 1; i--) {
			hash2[i] = hash2[i+1] * base + str.charAt(i-1);
		}
		//System.out.println(Arrays.toString(hash2));
		for (int i = n-1; i >= 1; i--) {
			long num = hash1[i];
			long num2 = hash2[1] - hash2[i+1] * pow[i];
			//System.out.println(num + " " + num2);
			if (num == num2) {
				for (int j = 2; j + i - 1 <= n; j++) {
					if (hash1[j+i-1] - hash1[j-1] * pow[i] == num) {
						System.out.println(i);
						return;
					}
				}
			}
		}
		System.out.println(0);
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
