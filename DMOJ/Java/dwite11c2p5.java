import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 5; i++) {
			int n = readInt();
			HashMap<String,Integer> map = new HashMap<String,Integer>();
			int count = 0;
			parent = new int[n*2+1];
			for (int j = 0; j < n*2+1; j++) {
				parent[j] = j;
			}
			for (int j = 0; j < n; j++) {
				String a = next(), b = next(), c = next();
				if (!map.containsKey(b)) {
					map.put(b,count++);
				}
				if (!map.containsKey(c)) {
					map.put(c,count++);
				}
				if (a.equals("p")) {
					if (find(map.get(b)) != find(map.get(c))) {
						union(map.get(b), map.get(c));
					}
				}
				else {
					if (find(map.get(b)) == find(map.get(c))) {
						System.out.println("connected");
					}
					else {
						System.out.println("not connected");
					}
				}
			}
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
