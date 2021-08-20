import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt();
		int[] array = new int[n+1];
		for (int i = 1; i <= n; i++) {
			array[i] = readInt();
		}
		for (int i = 0; i < q; i++) {
			int a = readInt(), l = readInt(), r = readInt();
			Integer[] temp = new Integer[r-l+1];
			for (int j = l, cnt = 0; j <= r; j++, cnt++) {
				temp[cnt] = array[j];
			}
			if (a == 1) {
				Arrays.sort(temp);
			} else {
				Arrays.sort(temp,Collections.reverseOrder());
			}
			for (int j = l, cnt = 0; j <= r; j++,cnt++) {
				array[j] = temp[cnt];
			}
		}
		for (int i = 1; i < n; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println(array[n]);
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
