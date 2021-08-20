import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		int w = readInt(), n = readInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = readInt();
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		int count = 0;
		for (int i = 0; i < n; i++) {
			list.add(array[i]);
			int total = 0;
			for (int j = 0; j < list.size(); j++) {
				total += list.get(j);
			}
			if (total > w) {
				break;
			}
			if (list.size() == 4) {
				list.remove(0);
			}
			count++;
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
