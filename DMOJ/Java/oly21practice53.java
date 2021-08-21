import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int a = readInt(), b = readInt();
		//x + y = a
		//2x + 4y = b
		if (b % 2 != 0) {
			System.out.println("No");
			return;
		}
		//x + 2y = b/2, x = b/2 - 2y, b/2 - 2y + y = a, b/2 - y = a, y = b/2 - a, x = 2a - b/2
		int x = 2*a - b/2, y = b/2 - a;
		if (x >= 0 && y >= 0 && x + y == a && 2*x + 4*y == b) {
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
