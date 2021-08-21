import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt();
		int[] array = new int[n+1];
		int[] maxl = new int[n+2], cntl = new int[n+2], maxr = new int[n+2], cntr = new int[n+2];
		for (int i = 1; i <= n; i++) {
			array[i] = readInt();
			if (array[i] > maxl[i-1]) {
				maxl[i] = array[i];
				cntl[i] = 1;
			} else if (array[i] == maxl[i-1]) {
				maxl[i] = array[i];
				cntl[i] = cntl[i-1] + 1;
			} else {
				maxl[i] = maxl[i-1];
				cntl[i] = cntl[i-1];
			}
		}
		for (int i = n; i >= 1; i--) {
			if (array[i] > maxr[i+1]) {
				maxr[i] = array[i];
				cntr[i] = 1;
			} else if (array[i] == maxr[i+1]) {
				maxr[i] = array[i];
				cntr[i] = cntr[i+1] + 1;
			} else {
				maxr[i] = maxr[i+1];
				cntr[i] = cntr[i+1];
			}
		}
		for (int i = 0; i < q; i++) {
			int a = readInt(), b = readInt();
			if (maxl[a-1] == maxr[b+1]) {
				System.out.println(maxl[a-1] + " " + (cntl[a-1]+cntr[b+1]));
			} else if (maxl[a-1] > maxr[b+1]) {
				System.out.println(maxl[a-1] + " " + cntl[a-1]);
			} else {
				System.out.println(maxr[b+1] + " " + cntr[b+1]);
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
