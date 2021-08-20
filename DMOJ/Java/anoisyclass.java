import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		ArrayList<Integer> adj[] = new ArrayList[n+1];
		int[] array = new int[n];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < m; i++) {
			int a = readInt(), b = readInt();
			adj[a].add(b);
			array[b-1]++;
		}
		int count = 0;
		Queue<Integer> q = new LinkedList();
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				q.add(i+1);
				count++;
			}
		}
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int nxt: adj[cur]) {
				array[nxt-1]--;
				if (array[nxt-1] == 0) {
					q.add(nxt);
					count++;
				}
			}
		}
		if (count == n) {
			System.out.println("Y");
		}
		else {
			System.out.println("N");
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
