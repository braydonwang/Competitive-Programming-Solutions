import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
		int first = readInt();
		map.put(first,0);
		for (int i = 1; i < n; i++) {
			int x = readInt();
			Integer key = map.floorKey(x);
			if (key == null) {
				System.out.println("NO");
				return;
			}
			map.put(x,0);
			map.put(key,map.get(key)+1);
			if (map.get(key) == 2) {
				map.remove(key);
			}
		}
		System.out.println("YES");
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
