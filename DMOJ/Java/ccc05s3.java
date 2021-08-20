import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int r = readInt(), c = readInt();
		int[][] temp = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				temp[i][j] = readInt();
			}
		}
		int[][] array = new int[r][c];
		array = temp;
		for (int a = 1; a < n; a++) {
			r = readInt(); c = readInt();
			array = new int[temp.length*r][temp[0].length*c];
			int[][] og = new int[r][c];
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					og[i][j] = readInt();
				}
			}
			for (int i = 0; i < temp.length; i++) {
				for (int j = 0; j < temp[0].length; j++) {
					int val = temp[i][j];
					for (int k = 0; k < r; k++) {
						for (int l = 0; l < c; l++) {
							array[i*r+k][j*c+l] = og[k][l] * val;
						}
					}
				}
			}
			temp = new int[array.length][array[0].length];
			temp = array;
		}
		int[] row = new int[array.length], col = new int[array[0].length];
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, maxr = Integer.MIN_VALUE, minr = Integer.MAX_VALUE, maxc = Integer.MIN_VALUE, minc = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				max = Math.max(max,array[i][j]);
				min = Math.min(min, array[i][j]);
				col[j] += array[i][j];
				row[i] += array[i][j];
				if (i == array.length-1) {
					maxc = Math.max(maxc, col[j]);
					minc = Math.min(minc, col[j]);
				}
			}
			maxr = Math.max(maxr, row[i]);
			minr = Math.min(minr, row[i]);
		}
		System.out.println(max);
		System.out.println(min);
		System.out.println(maxr);
		System.out.println(minr);
		System.out.println(maxc);
		System.out.println(minc);
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
