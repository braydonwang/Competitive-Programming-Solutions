import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int a = readInt(), b = readInt(), c = readInt(), d = readInt();
		System.out.println((a+b)/2.0);
		System.out.println((a+c)/2.0);
		System.out.println((a+d)/2.0);
		System.out.println((b+c)/2.0);
		System.out.println((b+d)/2.0);
		System.out.println((c+d)/2.0);
		System.out.println((a+b+c)/3.0);
		System.out.println((a+b+d)/3.0);
		System.out.println((a+c+d)/3.0);
		System.out.println((b+c+d)/3.0);
		System.out.println((a+b+c+d)/4.0);
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
