import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		Pair[] array = new Pair[m];
		for (int i = 0; i < m; i++) {
			array[i] = new Pair(readCharacter(),readInt(),readInt());
		}
		Arrays.sort(array);
		int[][] freq = new int[26][2];
		for (int i = 0; i < 26; i++) {
			freq[i][1] = 1;
		}
		char[] ans = new char[n+1];
		Arrays.fill(ans, '%');
		for (int i = 0; i < m; i++) {
			Pair cur = array[i];
			int ch = cur.ch-'a';
			int x = cur.x, v = cur.v;
			if (freq[ch][0] > x) {
				System.out.println(-1);
				return;
			} else {
				for (int j = freq[ch][1]; j <= v && freq[ch][0] < x; j++) {
					if (ans[j] == '%') {
						freq[ch][0]++;
						ans[j] = (char)(ch+'a');
					}
				}
				if (freq[ch][0] < x) {
					System.out.println(-1);
					return;
				}
				freq[ch][1] = v+1;
			}
		}
		for (int i = 1; i <= n; i++) {
			if (ans[i] == '%') {
				for (int j = 0; j < 26; j++) {
					if (freq[j][1] <= i) {
						ans[i] = (char)(j+'a');
						break;
					}
				}
			}
			if (ans[i] == '%') {
				System.out.println(-1);
			   	return;
			}
		}
		for (int i = 1; i <= n; i++) {
			System.out.print(ans[i]);
		}
	}
	static class Pair implements Comparable<Pair>{
		char ch;
		int x, v;
		Pair (char ch, int x, int v){
			this.ch = ch;
			this.x = x;
			this.v = v;
		}
		public int compareTo(Pair p) {
			return this.v - p.v;
		}
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
