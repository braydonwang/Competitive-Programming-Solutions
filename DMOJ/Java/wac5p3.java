import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = readInt();
		}
		int len = 1;
		int count = 0;
		while (len*len <= n) {
			int[] freq = new int[n+1];
			int total = 0;
			for (int i = 0; i < n; i++) {
				freq[array[i]]++;
				if (freq[array[i]] == len) {
					total++;
				} else if (freq[array[i]] == len+1) {
					total--;
				}
				if (i >= len*len) {
					freq[array[i-len*len]]--;
					if (freq[array[i-len*len]] == len) {
						total++;
					} else if (freq[array[i-len*len]] == len-1) {
						total--;
					}
				}
				if (i >= len*len-1) {
					if (total == len) {
						count++;
					}
				}
			}
			len++;
		}
		System.out.println(count);
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
