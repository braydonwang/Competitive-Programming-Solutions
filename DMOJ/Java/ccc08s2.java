import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		while (true) {
			int n = readInt();
			if (n == 0) {
				break;
			}
			int count = 0;
			for (int i = 0; i <= n; i++) {
				for (int j = 0; j <= n; j++) {
					if (i*i + j*j <= n*n) {
						count++;
					}
					else{
					    break;
					}
				}
			}
			System.out.println((count*4)-(n*4)-3);
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
