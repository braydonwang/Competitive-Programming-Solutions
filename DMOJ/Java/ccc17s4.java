import java.util.*;
import java.io.*;
class Edge implements Comparable<Edge>{
	int u;
	int v;
	int weight;
	int index;
	Edge(int u, int v, int weight, int index){
		this.u = u;
		this.v = v;
		this.weight = weight;
		this.index = index;
	}
	public int compareTo(Edge o) {
		if (this.weight == o.weight) {
			return this.index - o.index;
		}
		return this.weight - (o).weight;
	}
}
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), d = readInt();
		parent = new int[n+1];
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}
		Edge[] edge = new Edge[m];
		for (int i = 1; i <= m; i++) {
			int a = readInt(), b = readInt(), c = readInt();
			edge[i-1] = new Edge(a,b,c,i);
		}
		Arrays.sort(edge);
		int count = 0;
		int max = 0;
		int cnt = 0;
		for (int i = 0; i < edge.length; i++) {
			if (cnt == n-1) {
				break;
			}
			if (find(edge[i].u) != find(edge[i].v)) {
				union(edge[i].u,edge[i].v);
				cnt++;
				max = edge[i].weight;
				if (edge[i].index >= n) {
					count++;
				}
			}
		}
		if (true) {
			for (int i = 0; i <= n; i++) {
				parent[i] = i;
			}
			for (Edge e: edge) {
				if (find(e.v) != find(e.u)) {
					if (e.weight < max || (e.weight == max && e.index < n)) {
						union(e.v,e.u);
					} else if (e.index < n && e.weight <= d) {
						System.out.println(count-1);
						return;
					}
				}
			}
		}
		System.out.println(count);
	}
	public static int find(int v) {
		if (parent[v] == v) {
			return v;
		}
		else {
			int result = find(parent[v]);
			parent[v] = result;
			return result;
		}
	}
	public static void union(int a, int b) {
		int arep = find(a);
		int brep = find(b);
		parent[arep] = brep;
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
