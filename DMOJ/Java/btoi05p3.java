import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int w = readInt(), h = readInt();
		int x1 = readInt(), y1 = readInt(), x2 = readInt(), y2 = readInt();
		int cnt = 0;
		int x = 0, y = 0;
		ArrayList<Edge> adj[] = new ArrayList[(w+1)*(h+1)];
		for (int i = 0; i < (w+1)*(h+1); i++) {
			adj[i] = new ArrayList();
		}
		int v1 = 0, v2 = 0;
		for (int i = 0; i < 2*h+1; i++) {
			String str = next();
			for (int j = 0; j < str.length(); j++) {
				if (cnt % 2 == 0) {
					v1 = y*(w+1) + x; v2 = v1 + 1;
					x++;
				} else {
					v1 = y*(w+1) + x;
					if (j % 2 == 0) {
						v2 = v1 + w + 1;
						x++;
					} else {
						v2 = v1 + w;
					}
				}
				if (str.charAt(j) == 'b') {
					//System.out.println(v1 + " " + v2 + " " + 0);
					adj[v1].add(new Edge(v2,0));
					adj[v2].add(new Edge(v1,0));
				} else if (str.charAt(j) == 'w') {
					//System.out.println(v1 + " " + v2 + " " + 1);
					adj[v1].add(new Edge(v2,1));
					adj[v2].add(new Edge(v1,1));
				}
			}
			cnt++;
			if (cnt % 2 == 0) {
				x = 0; y++;
			} else {
				x = 0;
			}
		}
		Queue<Edge> q = new LinkedList();
		int[][] dis = new int[(w+1)*(h+1)][2];
		for (int i = 0; i < (w+1)*(h+1); i++) {
			dis[i][0] = dis[i][1] = Integer.MAX_VALUE;
		}
		q.add(new Edge(y1*(w+1)+x1,0)); q.add(new Edge(y1*(w+1)+x1,1)); dis[y1*(w+1)+x1][0] = dis[y1*(w+1)+x1][1] = 0;
		while (!q.isEmpty()) {
			Edge cur = q.poll();
			for (Edge nxt: adj[cur.v]) {
				if (dis[nxt.v][nxt.w] > dis[cur.v][cur.w] + 1 && cur.w != nxt.w) {
					dis[nxt.v][nxt.w] = dis[cur.v][cur.w] + 1; 
					q.add(new Edge(nxt.v,nxt.w));
				}
			}
		}
		System.out.println(Math.min(dis[y2*(w+1)+x2][0],dis[y2*(w+1)+x2][1]));
	}
	static class Edge{
		int v, w;
		Edge(int v, int w){
			this.v = v;
			this.w = w;
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
