import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		Box[] array = new Box[n];
		for (int i = 0; i < n; i++) {
			int x = readInt(), v = readInt();
			array[i] = new Box(x,v);
		}
		Arrays.sort(array);
		long count = 0;
		for (int i = 0; i < array.length; i++){
			if (array[i].a < m) {
				m -= array[i].a;
				count += array[i].p * array[i].a;
			}
			else {
				count += array[i].p * m;
				break;
			}
		}
		System.out.println(count);
	}
	static class Box implements Comparable<Box>{
		int p,a;
		Box(int p, int a){
			this.p = p;
			this.a = a;
		}
		public int compareTo(Box b) {
			return p-b.p;
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
