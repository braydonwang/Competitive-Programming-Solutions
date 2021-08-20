import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		int[] array = new int[n], count = new int[(int) (1e6+5)];
		for (int i = 0; i < n; i++) {
			array[i] = readInt();
		}
		int l = 0, r = 0, total = 0;
		long ans = 0;
		while (l < n) {
			while (r < n && total < k) {
				if (count[array[r]] == 0) {
					total++;
				}
				count[array[r]]++;
				r++;
			}
			if (total < k) {
				break;
			}
			ans += n - r + 1;
			count[array[l]]--;
			if (count[array[l]] == 0) {
				total--;
			}
			l++;
		}
		System.out.println(ans);
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
