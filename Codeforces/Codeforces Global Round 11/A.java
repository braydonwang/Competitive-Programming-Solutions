import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for (int i = 0; i < t; i++) {
			int n = readInt();
			int[] array = new int[n];
			int sum = 0;
			for (int j = 0; j < n; j++) {
				array[j] = readInt();
				sum += array[j];
			}
			Arrays.sort(array);
			if (sum == 0) {
				System.out.println("NO");
				continue;
			} else if (sum > 0) {
				System.out.println("YES");
				for (int j = n-1; j >= 0; j--) {
					System.out.print(array[j] + " ");
				}
				System.out.println();
			} else {
				System.out.println("YES");
				for (int x: array) {
					System.out.print(x + " ");
				}
				System.out.println();
			}
		}
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
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
