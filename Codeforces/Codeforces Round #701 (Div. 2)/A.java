import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for (int z = 0; z < t; z++) {
			int a = readInt(), b = readInt();
			int min2 = 0;
			if (b == 1) {
				min2++;
			}
			int temp = a;
			while (temp != 0) {
				if (b == 1) {
					temp /= 2;
				} else {
					temp /= b;
				}
				min2++;
			}
			for (int i = b+1; i - b <= min2; i++) {
				int count = i-b; temp = a;
				while (temp != 0) {
					temp /= i;
					count++;
				}
				min2 = Math.min(min2, count);
			}
			System.out.println(min2);
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
