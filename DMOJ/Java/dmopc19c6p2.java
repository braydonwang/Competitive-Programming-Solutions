import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int a = readInt(), b = readInt();
		int[] fb = new int[b+1];
		for (int j = 2; j <= b; j++) {
			int x = j;
			for (int i = 2; i <= Math.sqrt(x); i++) {
				if (isPrime(i)) {
					while (x >= i) {
						if (x % i == 0) {
							x /= i;
							fb[i]++;
						} else {
							break;
						}
					}
				}
			}
			fb[x]++;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 2; i <= Math.sqrt(a); i++) {
			int count = 0;
			if (isPrime(i)) {
				while (a >= i) {
					if (a % i == 0) {
						count++;
						a /= i;
					} else {
						break;
					}
				}
				if (count != 0) {
					min = Math.min(min, fb[i]/count);
				}
			}
		}
		if (a != 1) {
			min = Math.min(min, fb[a]);
		}
		System.out.println(min);
	}
	static boolean isPrime(int x) {
		return true;
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
