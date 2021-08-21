import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long max = Long.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for (int i = 0; i < t; i++) {
			long x = readLong();
			System.out.println(solve(x));
		}
	}
	static long solve(long x) {
		if (x == 0) {
			return 0;
		} else {
		    if (x == 3){
		        return 3;
		    }
			if (x % 2 == 0) {
				return 1 + solve(x/2);
			} else if (x % 4 == 1) {
				return 1 + solve(x-1);
			} else {
				return 1 + solve(x+1);
			}
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
