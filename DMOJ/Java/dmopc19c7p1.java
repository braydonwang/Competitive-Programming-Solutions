import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int a = readInt(), b = readInt(), c = readInt(), d = readInt();
		int total = 0;
		if (a > 0) {
			total += (a+1)*2 + 2;
		}
		if (b > 0) {
			total += (b+1)*2;	
		}
		if (c > 0) {
			total += (c+1)*2 - 2;	
		}
		if (a == 0 && b == 0 && c == 0) {
			total = 4;
		}
		if (total != d) {
			System.out.println("invalid");
		} else {
			System.out.println("C" + (a+b+c+1) + "H" + d);
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
