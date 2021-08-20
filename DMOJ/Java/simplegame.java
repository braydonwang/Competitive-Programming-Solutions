import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = readInt();
		}
		int[][] pre = new int[n][2];
		int[][] suf = new int[n][2];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (array[i] > max) {
				pre[i][0] = array[i];
				pre[i][1] = i+1;
				max = array[i];
			}
			else {
				pre[i][0] = pre[i-1][0];
				pre[i][1] = pre[i-1][1];
			}
		}
		max = Integer.MIN_VALUE;
		for (int i = n-1; i >= 0; i--) {
			if (array[i] > max) {
				suf[i][0] = array[i];
				suf[i][1] = i+1;
				max = array[i];
			}
			else {
				suf[i][0] = suf[i+1][0];
				suf[i][1] = suf[i+1][1];
			}
		}
		for (int i = 0; i < q; i++) {
			int a = readInt();
			System.out.println(pre[a-2][1] + " " + suf[a][1]);
		}
	}
	static class Fiber implements Comparable<Fiber>{
		int u,v,c;
		Fiber(int u, int v, int c){
			this.u = u;
			this.v = v;
			this.c = c;
		}
		public int compareTo(Fiber f) {
			return this.c-f.c;
		}
	}
	static class Cable implements Comparable<Cable>{
		int u,v,c;
		Cable(int u, int v, int c){
			this.u = u;
			this.v = v;
			this.c = c;
		}
		public int compareTo(Cable f) {
			return this.c-f.c;
		}
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
