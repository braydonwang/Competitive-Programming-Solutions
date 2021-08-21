import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int w = readInt(), d = readInt();
		HashSet<Integer> cur = new HashSet();
		int[] a = new int[d];
		for (int i = 0; i < d; i++) {
			a[i] = readInt();
			cur.add(a[i]);
		}
		for (int i = 1; i <= w; i++) {
			HashSet<Integer> nxt = new HashSet();
			for (int x: cur) {
				for (int j = 0; j < d; j++) {
					nxt.add(x+a[j]);
					nxt.add(x*a[j]);
				}
			}
			cur = nxt;
		}
		int t = readInt();
		for (int i = 0; i < t; i++) {
			if (cur.contains(readInt())) {
				System.out.println("Y");
			} else {
				System.out.println("N");
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
