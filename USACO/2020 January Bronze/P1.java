import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		String str = readLine();
		String[] array = str.split(" ");
		int total = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i].length() + total <= k) {
				total += array[i].length();
				if (i == 0) {
					System.out.print(array[i]);
				} else {
					System.out.print(" " + array[i]);
				}
			} else {
				System.out.println();
				total = array[i].length();
				System.out.print(array[i]);
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
