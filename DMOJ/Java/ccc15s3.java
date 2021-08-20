import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int g = readInt();
		int p = readInt();
		int[] planes = new int[g+1];

		int count = 0;
		int j;
		for (int i = 0; i < p; i++) {
			int num = readInt();
			for (j = num; j > 0; j--) {
				int x = planes[j];
				if (x == 0) {
					planes[j] = 1;
					break;
				}
				planes[j] += 1;
				j -= x - 1;
			}
			if (j <= 0) {
				System.out.println(count);
				return;
			} else {
				count++;
			}
		}
		System.out.println(p);
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
