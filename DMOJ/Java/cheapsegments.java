import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int max = (int)1e5+2;
	static int log = 19;
	static int[][] anc;
	static Event[] vec;
	static int[] node, dep;
	static ArrayList<Integer> adj[];
	public static void main(String[] args) throws IOException {
		int n = readInt();
		node = new int[max]; dep = new int[max];
		anc = new int[log][max];
		for (int i = 0; i < log; i++) {
			Arrays.fill(anc[i], -1);
		}
		adj = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		vec = new Event[max];
		ArrayList<Event> p = new ArrayList();
		for (int i = 1; i <= n; i++) {
			vec[i] = new Event(readInt(),readInt(),readInt());
			p.add(new Event(vec[i].l,i,0));
			p.add(new Event(vec[i].r,i,1));
		}
		Collections.sort(p);
		Stack<Integer> st = new Stack();
		st.push(0);
		for (Event x: p) {
			if (x.v == 0) {
				adj[st.peek()].add(x.r);
				st.add(x.r);
			} else {
				st.pop();
			}
		}
		vec[0] = new Event(0,0,(int)1e9);
		dfs(0,-1,0);
		int q = readInt();
		for (int i = 0; i < q; i++) {
			int a = readInt(), b = readInt();
			int ans = lca(a,b);
			if (ans == 0) {
				System.out.println(-1);
			} else {
				System.out.println(node[ans]);
			}
		}
	}
	static void dfs(int u, int pa, int best) {
		anc[0][u] = pa; node[u] = best;
		if (vec[u].v <= vec[node[best]].v) {
			node[u] = u;
		}
		for (int i = 1; i < log; i++) {
			if (anc[i-1][u] != -1) {
				anc[i][u] = anc[i-1][anc[i-1][u]];
			}
		}
		for (int v: adj[u]) {
			if (v == pa) {
				continue;
			}
			dep[v] = dep[u] + 1; dfs(v,u,node[u]);
		}
	}
	static int lca(int u, int v) {
		if (dep[u] < dep[v]) {
			int temp = u;
			u = v;
			v = temp;
		}
		for (int i = log-1; i >= 0; i--) {
			if (anc[i][u] != -1 && dep[anc[i][u]] >= dep[v]) {
				u = anc[i][u];
			}
		}
		if (u == v) {
			return anc[0][u];
		}
		for (int i = log-1; i >= 0; i--) {
			if (anc[i][u] != -1 && anc[i][v] != -1 && anc[i][u] != anc[i][v]) {
				u = anc[i][u]; v = anc[i][v];
			}
		}
		return anc[0][u];
	}
	static class Event implements Comparable<Event>{
		int l, r, v;
		Event(int l, int r, int v){
			this.l = l;
			this.r = r;
			this.v = v;
		}
		public int compareTo(Event e) {
			return this.l - e.l;
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
