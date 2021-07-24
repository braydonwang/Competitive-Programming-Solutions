import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), k = readInt();
		int[] a = new int[n], b = new int[n];
		int[] temp = new int[n+1];
		int[] nxt = new int[n+1];
		int[] ans = new int[n+1];
		for (int i = 0; i < m; i++) {
			a[i] = readInt(); b[i] = readInt();
		}
		for (int i = 1; i <= n; i++) {
			int cur = i;
			for (int j = 0; j < m; j++) {
				if (cur >= a[j] && cur <= b[j]) {
					cur = b[j] - cur + a[j];
				}
			}
			temp[cur] = i;
		}
		for (int i = 1; i <= n; i++) {
			nxt[temp[i]] = i;
		}
		boolean[] vis = new boolean[n+1];
		for (int i = 1; i <= n; i++) {
			int cur = i;
			ArrayList<Integer> list = new ArrayList<Integer>();
			if (!vis[cur]) {
				do {
					vis[cur] = true;
					list.add(cur);
					cur = nxt[cur];
				} while (cur != i);
				
				int rem = k % list.size();
				for (int j = 0; j < list.size(); j++){
					ans[list.get((j+rem)%list.size())] = list.get(j);
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			System.out.println(ans[i]);
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
