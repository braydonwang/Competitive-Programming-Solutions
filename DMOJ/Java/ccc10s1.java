import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		int k = readInt();
		TreeMap<String,Integer> map = new TreeMap<String,Integer>();
		for (int i = 0; i < k; i++) {
			String str = next();
			int r = readInt(), s = readInt(), d = readInt();
			map.put(str, 2*r + 3*s + d);
		}
		String name = "";
		int max = 0;
		for (String key: map.keySet()) {
			if (map.get(key) > max) {
				max = map.get(key);
				name = key;
			}
		}
		System.out.println(name);
		if (k == 1) {
			return;
		}
		map.remove(name);
		max = 0;
		name = "";
		for (String key: map.keySet()) {
			if (map.get(key) > max) {
				max = map.get(key);
				name = key;
			}
		}
		System.out.println(name);
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
