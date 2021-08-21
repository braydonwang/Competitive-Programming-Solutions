import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		for (int a = 0; a < 5; a++) {
			int x = readInt();
			int l = 0, r = 0;
			int temp = x+1, count = 0;
			while (true) {
				if (isPrime(temp) && count == 1) {
					r = temp;
					break;
				} else if (isPrime(temp)) {
					count++;
				}
				temp++;
			}
			temp = x-1; count = 0;
			while (true) {
				if (isPrime(temp) && count == 1) {
					l = temp;
					break;
				} else if (isPrime(temp)) {
					count++;
				}
				temp--;
			}
			if (x - l < r - x) {
				System.out.println(l);
			} else {
				System.out.println(r);
			}
		}
	}
	static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
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
