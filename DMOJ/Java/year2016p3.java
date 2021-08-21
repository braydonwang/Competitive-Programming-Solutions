import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] array = new int[n];
		int[] vis = new int[(int) (1e6-1)];
		for (int i = 0; i < n; i++) {
			array[i] = readInt();
			vis[array[i]]++;
		}
		Arrays.sort(array);
		int max = 0;
		for (int i = n-3; i >= 0; i--) {
			for (int j = n-2; j >= i+1; j--) {
				if (vis[(array[j]-array[i])+array[j]] >= 1) {
					if (array[i] == array[j] && vis[(array[j]-array[i])+array[j]] >= 3) {
						max = Math.max(max, array[i] + array[j] + (array[j] - array[i]) + array[j]);
					} else if (array[i] != array[j]){
						max = Math.max(max, array[i] + array[j] + (array[j] - array[i]) + array[j]);
					}
				}
			}
		}
		System.out.println(max);
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
