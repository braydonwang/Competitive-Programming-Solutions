import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			list.add(next());
		}
		int count = 0;
		for (int i = 0; i < m; i++) {
			int t = readInt();
			boolean good = true;
			for (int j = 0; j < t; j++) {
				String str = next();
				if (!list.contains(str)) {
					good = false;
				}
			}
			if (good) {
				count++;
			}
		}
		System.out.println(count);
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
}
