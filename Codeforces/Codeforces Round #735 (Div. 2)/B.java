import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for (int z = 0; z < t; z++) {
			int n = readInt(), k = readInt();
			int[] a = new int[n];
			for (int j = 0; j < n; j++) {
				a[j] = readInt();
			}
			long max = (long)-1e12;
			for (int i = Math.max(0,n-2*k-1); i < n; i++) {
				for (int j = i+1; j < n; j++) {
					max = Math.max(max, (1L*i+1)*(1L*j+1)-k*(1L*a[i]|a[j]));
				}
			}
			System.out.println(max);
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
