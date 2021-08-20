import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] diff = new int[(int) (1e7+5)];
		int big = 0;
		for (int i = 0; i < n; i++) {
			int l = readInt(), r = readInt();
			diff[l]++; diff[r]--;
			big = Math.max(big, r);
		}
		int max = 0;
		for (int i = 1; i <= big ; i++) {
			diff[i] += diff[i-1];
			max = Math.max(diff[i], max);
		}
		System.out.println(max);
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
