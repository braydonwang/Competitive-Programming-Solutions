import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int k = readInt();
		int[] array = new int[k];
		for (int i = 0; i < k; i++) {
			array[i] = readInt();
		}
		int x = readInt();
		boolean[] menu = new boolean[21];
		for (int i = 0; i < 4; i++) {
			menu[readInt()] = true;
		}
		int t = readInt(), total = 0;
		int[] freq = new int[21];
		for (int i = 0; i < t; i++) {
			int n = readInt();
			if (!menu[n]) {
				total += array[n-1];
			} else {
				freq[n]++;
			}
		}
		boolean done = false;
		while (!done) {
			int temp = 0;
			done = true;
			for (int i = 1; i <= 20; i++) {
				if (freq[i] > 0) {
					temp += array[i-1];
					done = false;
					freq[i]--;
				}
			}
			if (temp < x) {
				total += temp;
			} else {
				total += x;
			}
		}
		System.out.println(total);
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
