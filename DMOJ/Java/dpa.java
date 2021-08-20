import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] array = new int[n+1];
		for (int i = 1; i <= n; i++) {
			array[i] = readInt();
		}
		int[] dis = new int[n+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[1] = 0;
		for (int i = 1; i <= n; i++) {
			if (i + 1 <= n) {
				dis[i+1] = Math.min(Math.abs(array[i]-array[i+1])+ dis[i],dis[i+1]);
			}
			if (i + 2 <= n) {
				dis[i+2] = Math.min(Math.abs(array[i]-array[i+2])+ dis[i],dis[i+2]);
			}
		}
		System.out.println(dis[n]);
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
