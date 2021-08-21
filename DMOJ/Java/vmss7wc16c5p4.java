import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int x = readInt();
		int[] bar = new int[x+1];
		int[] piece = new int[3];
		for (int i = 0; i < 3; i++) {
			piece[i] = readInt();
		}
		Arrays.fill(bar, -1);
		bar[0] = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < bar.length-piece[i]; j++) {
				if (bar[j] != -1 && bar[j] + 1 > bar[j + piece[i]]) {
					bar[j+piece[i]] = bar[j] + 1;
				}
			}
		}
		System.out.println(bar[x]);
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
