import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), t = readInt(), k = readInt(), v = readInt();
		int[] array = new int[n+1];
		int temp = 0;
		for (int i = 0; i < v; i++) {
			int x = readInt();
			if (x >= 1 && x <= t) {
				temp++;
			}
			array[x] = 1;
		}
		int count = 0;
		for (int i = 1; i <= n-t+1; i++) {
			int r = i + t - 1;
			if (i != 1) {
				if (array[i-1] == 1) {
					temp--;
				}
				if (array[r] == 1) {
					temp++;
				}
			}
			if (temp >= k) {
				continue;
			}
			int diff = k - temp;
			count += diff;
			while (diff != 0) {
				if (array[r] == 0) {
					array[r] = 1;
					diff--;
				}
				r--;
			}
			temp = k;
		}
		System.out.println(count);
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
