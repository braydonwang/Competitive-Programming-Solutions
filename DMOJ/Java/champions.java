import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		int[] array = new int[n];
		int[] temp = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = readInt();
			temp[i] = array[i];
		}
		int[] sub = new int[n];
		for (int i = 0; i < k; i++) {
			int a = readInt()-1, b = readInt()-1;
			if (array[a] < array[b]) {
				sub[b]++;
			} else if (array[b] < array[a]) {
				sub[a]++;
			}
		}
		Arrays.sort(temp);
		//System.out.println(Arrays.toString(sub));
		for (int i = 0; i < n; i++) {
			int lo = 0, hi = n-1, ans = 0;
			while (lo <= hi) {
				int mid = (lo + hi) / 2;
				if (temp[mid] < array[i]) {
					ans = Math.max(ans, mid+1);
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
			System.out.print(ans - sub[i] + " ");
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
