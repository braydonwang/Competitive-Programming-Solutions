import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int va = readInt(), vb = readInt(), m = readInt();
		if (Math.max(va, vb) < m) {
			System.out.println("Not possible");
		} else {
			Queue<Integer> q = new LinkedList();
			ArrayList<Integer> adj[][] = new ArrayList[va+1][vb+1];
			for (int i = 0; i <= va; i++) {
				for (int j = 0; j <= vb; j++) {
					adj[i][j] = new ArrayList();
				}
			}
			//1 -> fill A
			//2 -> fill B
			//3 -> pour A B
			//4 -> pour B A
			//5 -> chug A
			//6 -> chug B
			int[][] dis = new int[va+1][vb+1];
			boolean[][] vis = new boolean[va+1][vb+1];
			q.add(0); q.add(0); vis[0][0] = true;
			while (!q.isEmpty()) {
				int a = q.poll(), b = q.poll();
				if (a == m || b == m) {
					for (int nxt: adj[a][b]) {
						if (nxt == 1) {
							System.out.println("fill A");
						} else if (nxt == 2) {
							System.out.println("fill B");
						} else if (nxt == 3) {
							System.out.println("pour A B");
						} else if (nxt == 4) {
							System.out.println("pour B A");
						} else if (nxt == 5) {
							System.out.println("chug A");
						} else {
							System.out.println("chug B");
						}
					}
					return;
				}
				if (!vis[va][b]) {
					q.add(va); q.add(b); vis[va][b] = true; dis[va][b] = dis[a][b] + 1;
					adj[va][b].addAll(adj[a][b]); adj[va][b].add(1);
				}
				if (!vis[a][vb]) {
					q.add(a); q.add(vb); vis[a][vb] = true; dis[a][vb] = dis[a][b] + 1;
					adj[a][vb].addAll(adj[a][b]); adj[a][vb].add(2);
				}
				int dif = vb - b, pour = Math.min(dif, a);
				if (!vis[a-pour][b+pour]) {
					q.add(a-pour); q.add(b+pour); vis[a-pour][b+pour] = true; dis[a-pour][b+pour] = dis[a][b] + 1;
					adj[a-pour][b+pour].addAll(adj[a][b]); adj[a-pour][b+pour].add(3);
				}
				dif = va - a; pour = Math.min(dif, b);
				if (!vis[a+pour][b-pour]) {
					q.add(a+pour); q.add(b-pour); vis[a+pour][b-pour] = true; dis[a+pour][b-pour] = dis[a][b] + 1;
					adj[a+pour][b-pour].addAll(adj[a][b]); adj[a+pour][b-pour].add(4);
				}
				if (!vis[0][b]) {
					q.add(0); q.add(b); vis[0][b] = true; dis[0][b] = dis[a][b] + 1;
					adj[0][b].addAll(adj[a][b]); adj[0][b].add(5);
				}
				if (!vis[a][0]) {
					q.add(a); q.add(0); vis[a][0] = true; dis[a][0] = dis[a][b] + 1;
					adj[a][0].addAll(adj[a][b]); adj[a][0].add(6);
				}
			}
			System.out.println("Not possible");
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
