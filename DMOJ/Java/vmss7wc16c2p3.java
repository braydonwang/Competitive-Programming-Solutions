import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] pos = new int[1000001];
		for (int i = 1; i <= n; i++) {
			int x = readInt();
			pos[x] = i;
		}
		int m = readInt();
		List<Integer> list = new ArrayList();
		for (int i = 1; i <= m; i++) {
			int x = readInt();
			if (pos[x] == 0){
			    continue;
			}
			if (list.isEmpty() || pos[x] > list.get(list.size()-1)) {
				list.add(pos[x]);
			} else {
				int p = Collections.binarySearch(list, pos[x]);
				if (p < 0) {
					p = -p-1; list.set(p, pos[x]);
				}
			}
		}
		System.out.println(list.size());
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
