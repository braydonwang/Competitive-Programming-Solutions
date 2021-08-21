import java.util.*;
import java.io.*;
class Edge implements Comparable{
	int u;
	int v;
	int weight;
	Edge(int u, int v, int weight){
		this.u = u;
		this.v = v;
		this.weight = weight;
	}
	@Override
	public int compareTo(Object o) {
		return this.weight - ((Edge)o).weight;
	}
}
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] parent;
	static ArrayList<Integer> adj[];
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		Edge[] edge = new Edge[n-1 + (n-k)];
		parent = new int[n+1];
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}
		for (int i = 1; i <= n-k; i++) {
			edge[i-1] = new Edge(i,i+k,0);
		}
		int count = 1;
		for (int i = n-k; i < edge.length; i++) {
			int w = readInt();
			edge[i] = new Edge(count,count+1,w);
			count++;
		}
		Arrays.sort(edge);
		int total = 0;
		count = 0;
		for (int i = 0; i < edge.length; i++) {
			if (find(edge[i].u) != find(edge[i].v)) {
				union(edge[i].u,edge[i].v);
				total += edge[i].weight;
				count++;
			}
			if (count == n-1) {
				break;
			}
		}
		System.out.println(total);
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
