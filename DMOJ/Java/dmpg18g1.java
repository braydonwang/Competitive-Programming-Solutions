import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		boolean[] chair = new boolean[n+1];
		int[] st = new int[n+1];
		for (int i = 0; i < k; i++) {
			chair[readInt()] = true;
		}
		for (int i = 1; i <= k+1; i++) {
			int x = readInt();
			if (chair[x]) {
				chair[x] = false;
			} else {
				st[x] = i;
			}
		}
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j <= n; j++) {
				if (chair[j] && !s.isEmpty()) {
					chair[j] = false;
					s.pop();
				} else if (st[j] > 0) {
					s.add(st[j]);
					st[j] = 0;
				}
			}
		}
		System.out.println(s.pop());
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
