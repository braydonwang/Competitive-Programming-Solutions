import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		String str = next();
		int[][] array = {{1,2},{3,4}};
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'H') {
				int temp = array[1][0];
				array[1][0] = array[0][0];
				array[0][0] = temp;
				temp = array[1][1];
				array[1][1] = array[0][1];
				array[0][1] = temp;
			}
			else {
				int temp = array[0][0];
				array[0][0] = array[0][1];
				array[0][1] = temp;
				temp = array[1][1];
				array[1][1] = array[1][0];
				array[1][0] = temp;
			}
		}
		System.out.println(array[0][0] + " " + array[0][1]);
		System.out.println(array[1][0] + " " + array[1][1]);
	}
	static class Edge implements Comparable<Edge>{
		int v, w;
		Edge(int v, int w){
			this.v = v;
			this.w = w;
		}
		public int compareTo(Edge x) {
			return this.w - x.w;
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
