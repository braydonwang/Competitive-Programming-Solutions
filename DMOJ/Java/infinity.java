import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String a = next(), b = next();
		a = a.toUpperCase(); b = b.toUpperCase();
		long num1 = 0, num2 = 0;
		long temp = 1;
		for (int i = a.length()-1; i >= 0; i--) {
			char ch = a.charAt(i);
			if (ch >= 'A') {
				num1 += (ch - 55) * temp;
			} else {
				num1 += (ch - '0') * temp;
			}
			temp *= 16;
		}
		temp = 1;
		for (int i = b.length()-1; i >= 0; i--) {
			char ch = b.charAt(i);
			if (ch >= 'A') {
				num2 += (ch - 55) * temp;
			} else {
				num2 += (ch - '0') * temp;
			}
			temp *= 16;
		}
		if (num1 + num2 > 1061109567) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
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
