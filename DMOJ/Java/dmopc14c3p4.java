import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt(), max = 0, maxk = 200;
		int[] k = new int[t], a = new int[t], b = new int[t];
		for (int c = 0; c < t; c++) {
			k[c] = readInt(); a[c] = readInt(); b[c] = readInt();
			max = Math.max(max,b[c]);
		}
		int[] fact = new int[max+1];
		for (int i = 1; i <= max; i++) {
			for (int j = 1; i*j <= max; j++) {
				fact[i*j]++;
			}
		}
		int[][] pre = new int[maxk+1][max+1];
		for (int i = 1; i <= maxk; i++) {
			for (int j = 1; j <= max; j++) {
				if (fact[j] == i) {
					pre[i][j]++;
				}
				pre[i][j] += pre[i][j-1];
			}
		}
		for (int i = 0; i < t; i++) {
		    if (k[i] > maxk){
		        System.out.println(0);
		    } else {
		        System.out.println(pre[k[i]][b[i]] - pre[k[i]][a[i]-1]);
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
