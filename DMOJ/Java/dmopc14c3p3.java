import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		Pair[] array = new Pair[n];
		for (int i = 0; i < n; i++) {
			array[i] = new Pair(next(), readInt());
		}
		Arrays.sort(array);
		int q = readInt();
		for (int i = 0; i < q; i++) {
			int s = readInt(), d = readInt();
			int lo = 0, hi = n-1;
			String ans = "";
			while (lo <= hi) {
				int mid = (lo + hi) / 2;
				if (array[mid].x >= s && array[mid].x <= s + d) {
					ans = array[mid].str;
					hi = mid - 1;
				} else if (array[mid].x < s){
					lo = mid + 1;
				} else if (array[mid].x > s + d) {
					hi = mid - 1;
				}
			}
			if (ans.equals("")) {
				System.out.println("No suitable teacher!");
			} else {
				System.out.println(ans);
			}
		}
	}
	static class Pair implements Comparable<Pair>{
		String str;
		int x;
		Pair(String str, int x){
			this.str = str;
			this.x = x;
		}
		public int compareTo(Pair p) {
			return this.x - p.x;
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
