import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for (int i = 0; i < n; i++) {
			String str = readLine();
			map.put(str, map.getOrDefault(str, 0)+1);
		}
		for (int i = 0; i < n-1; i++) {
			String x = readLine();
			map.put(x, map.get(x)-1);
		}
		for (String a : map.keySet()) {
			if (map.get(a) == 1) {
				System.out.println(a);
				break;
			}
		}
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
