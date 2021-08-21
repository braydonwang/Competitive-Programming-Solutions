import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] array;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		array = new int[n+1];
		int[] num = new int[m*2];
		
		for (int i = 1; i <= n; i++) {
			array[i] = i;
		}
		for (int i = 0; i < 2*m; i+=2) {
			int a = readInt(), b = readInt();
			num[i] = a; num[i+1] = b;
		}
		int count = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < m; i++) {
			if (find(num[i*2]) != find(num[i*2+1])) {
				union(num[i*2],num[i*2+1]);
				count++;
				list.add(i+1);
			}
		}
		if (count == n-1) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
		else {
			System.out.println("Disconnected Graph");
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
