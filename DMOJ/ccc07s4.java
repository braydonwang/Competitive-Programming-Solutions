import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer> adj[];
	public static void main(String[] args) throws IOException {
		int n = readInt();
		adj = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		while (true) {
			int a = readInt(), b = readInt();
			if (a == 0 && b == 0) {
				break;
			}
			adj[b].add(a);
		}
		int[] p = new int[n+1];
		while (!adj[n].isEmpty()) {
			int num = adj[n].remove(0);
			p[num] = 1;
		}
		for(int i = n-1; i > 1; i--) {
			while (!adj[i].isEmpty()) {
				int num = adj[i].remove(0);
				p[num] += p[i];
			}
		}
		System.out.println(p[1]);
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
