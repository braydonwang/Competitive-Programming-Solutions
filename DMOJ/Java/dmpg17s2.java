import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] array;
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt();
		array = new int[n+1];
		for (int i = 0; i <= n; i++) {
			array[i] = i;
		}
		for (int i = 0; i < q; i++) {
			String str = next();
			int a = readInt(), b = readInt();
			if (str.equals("A")) {
				union(a,b);
			}
			else {
				if (find(a) == find(b)) {
					System.out.println("Y");
				}
				else {
					System.out.println("N");
				}
			}
		}
	}
	public static int find(int v) {
		if (array[v] == v) {
			return v;
		}
		else {
			int result = find(array[v]);
			array[v] = result;
			return result;
		}
	}
	public static void union(int a, int b) {
		int arep = find(a);
		int brep = find(b);
		array[arep] = brep;
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
