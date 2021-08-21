import java.util.*;
import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int g = readInt(), p = readInt();
		ArrayList<Integer> adj[] = new ArrayList[g+1];
		for (int i = 0; i <= g; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < p; i++) {
			adj[readInt()].add(readInt());
		}
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
		long sum = 0;
		for (int i = g; i > 0; i--) {
			for (int j = 0; j < adj[i].size(); j++) {
				q.add(adj[i].get(j));
			}
			if (!q.isEmpty()) {
				sum += q.poll();
			}
		}
		System.out.println(sum);
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
