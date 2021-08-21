import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(); int x = readInt();
		int[] array = new int[n];
		int[] prefix = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = readInt();
			if (i == 0) {
				prefix[i] = array[i];
			}
			else {
				prefix[i] = prefix[i-1] + array[i];
			}
		}
		for (int i = 0; i < x; i++) {
			int a = readInt(); int b = readInt();
			System.out.println(prefix[prefix.length-1] - (prefix[b-1]-prefix[a-1]+array[a-1]));
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
