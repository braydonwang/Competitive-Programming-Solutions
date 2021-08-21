import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		ArrayList<Integer> adj[] = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		double total = 0;
		for (int i = 0; i < m; i++) {
			int a = readInt(), b = readInt();
			adj[a].add(b); adj[b].add(a);
		}
		boolean[] h = new boolean[n+1];
		int ch = 0;
		for (int i = 1; i <= n; i++) {
			if (adj[i].size() == 1) {
				h[i] = true;
				ch++;
			} else if (adj[i].size() != 4) {
				System.out.println("Impossible");
				return;
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int nxt: adj[i]) {
				if (h[nxt] || h[i]) {
					total += 413;
				} else {
					if (adj[i].lastIndexOf(nxt) != adj[i].indexOf(nxt)) {
						total += 307.5;
					} else {
						total += 346;
					}
				}
			}
		}
		System.out.println((int)total/2);
		int cc = n-ch;
		if (cc == 1 && ch == 1) {
			System.out.println("CH");
		} else if (cc == 1) {
			System.out.println("CH" + ch);
		} else if (ch == 1) {
			System.out.println("C" + cc + "H");
		} else {
			System.out.println("C" + cc + "H" + ch);
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
