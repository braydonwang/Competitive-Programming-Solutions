import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int h = readInt(), v = readInt();
		int[] a1 = new int[h], a2 = new int[v];
		HashMap<Integer,Integer> map = new HashMap(), map2 = new HashMap();
		for (int i = 0; i < h; i++) {
			a1[i] = readInt();
			for (int j = 0; j < i; j++) {
				map.put(a1[i] - a1[j], map.getOrDefault(a1[i] - a1[j], 0)+1);
			}
		}
		for (int i = 0; i < v; i++) {
			a2[i] = readInt();
			for (int j = 0; j < i; j++) {
				map2.put(a2[i] - a2[j], map2.getOrDefault(a2[i] - a2[j], 0)+1);
			}
		}
		int sum = 0;
		for (int x: map.keySet()) {
			sum += map.get(x) * map2.getOrDefault(x, 0);
		}
		System.out.println(sum);
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
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
