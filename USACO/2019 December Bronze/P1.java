import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int k, n;
	static int[][] array;
	public static void main(String[] args) throws IOException {
		k = readInt(); n = readInt();
		array = new int[k][n];
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j] = readInt();
			}
		}
		int count = 0;
		for (int i = 1; i <= n-1; i++) {
			for (int j = i+1; j <= n; j++) {
				boolean done = true;
				int pos = rank(i,j,0);
				for (int l = 1; l < k; l++) {
					if (rank(i,j,l) != pos) {
						done = false;
						break;
					}
				}
				if (done) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
	static int rank(int x, int y, int a) {
		int pos1 = 0, pos2 = 0;
		for (int i = 0; i < n; i++) {
			if (array[a][i] == x) {
				pos1 = i;
			} else if (array[a][i] == y) {
				pos2 = i;
			}
		}
		if (pos1 > pos2) {
			return 1;
		} else {
			return -1;
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
