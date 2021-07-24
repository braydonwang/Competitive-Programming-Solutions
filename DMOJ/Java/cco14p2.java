import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), a = readInt(), b = readInt();
		ArrayList<Edge> adj[] = new ArrayList[n+1], rev[] = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList(); rev[i] = new ArrayList();
		}
		int[] x = new int[m], y = new int[m], l = new int[m], c = new int[m];
		for (int i = 0; i < m; i++) {
			x[i] = readInt(); y[i] = readInt(); l[i] = readInt(); c[i] = readInt();
			adj[x[i]].add(new Edge(y[i],l[i],c[i])); rev[y[i]].add(new Edge(x[i],l[i],c[i]));
		}
		int[] dis = new int[n+1], dis2 = new int[n+1];
		djikstra(a,b,adj,dis); djikstra(b,a,rev,dis2);
		Pair[] sort = new Pair[m];
		for (int i = 0; i < m; i++) {
			sort[i] = new Pair(dis[x[i]] + dis2[y[i]] + l[i],c[i]);
		}
		Arrays.sort(sort);
		int[] pre = new int[m+1];
		for (int i = 1; i <= m; i++) {
			pre[i] = pre[i-1] + sort[i-1].c;
		}
		int q = readInt();
		for (int i = 0; i < q; i++) {
			int d = readInt();
			int lo = 0, hi = m-1, ans = -1;
			while (lo <= hi) {
				int mid = (lo + hi) / 2;
				if (sort[mid].v <= d) {
					ans = mid;
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
			System.out.println(pre[ans+1]);
		}
	}
	static class Pair implements Comparable<Pair>{
		long v;
		int c;
		Pair(long v, int c){
			this.v = v;
			this.c = c;
		}
		public int compareTo(Pair p) {
			return Long.compare(this.v, p.v);
		}
	}
	static void djikstra(int a, int b, ArrayList<Edge> adj[], int[] dis) {
		PriorityQueue<Edge> q = new PriorityQueue();
		Arrays.fill(dis, (int)1e9);
		dis[a] = 0; q.add(new Edge(a,0,0));
		while (!q.isEmpty()) {
			Edge cur = q.poll();
			if (cur.w > dis[cur.v]) {
				continue;
			}
			for (Edge e: adj[cur.v]) {
				if (dis[e.v] > dis[cur.v] + e.w) {
					dis[e.v] = dis[cur.v] + e.w;
					q.add(new Edge(e.v, dis[e.v],0));
				}
			}
		}
	}
	static class Edge implements Comparable<Edge>{
		int v, w, z;
		Edge(int v, int w, int z){
			this.v = v;
			this.w = w;
			this.z = z;
		}
		public int compareTo(Edge e) {
			return this.w - e.w;
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
