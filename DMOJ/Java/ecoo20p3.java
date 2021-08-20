import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for (int aa = 0; aa < t; aa++) {
			int n = readInt();
			String ans = "";
			for (int i = 0; i < n; i++) {
				int h = readInt(), w = readInt();
				int l = Integer.MAX_VALUE, r = 0, u = Integer.MAX_VALUE, d = 0;
				char[][] array = new char[h][w];
				for (int j = 0; j < h; j++) {
					String temp = next();
					for (int k = 0; k < w; k++) {
						array[j][k] = temp.charAt(k);
						if (array[j][k] == '*') {
							l = Math.min(l, k);
							r = Math.max(r, k);
							u = Math.min(u, j);
							d = Math.max(d, j);
						}
					}
				}
				char[][] grid = new char[d-u+1][r-l+1];
				for (int j = u; j <= d; j++) {
					for (int k = l; k <= r; k++) {
						grid[j-u][k-l] = array[j][k];
					}
				}
				if (w == 3) {
					grid = new char[d-u+1][3];
					for (int j = u; j <= d; j++) {
						for (int k = 0; k <= 2; k++) {
							grid[j-u][k] = array[j][k];
						}
					}
				}
				if ((r-l+1) % 2 == 0) {
					char[][] temp = new char[grid.length][grid[0].length];
					for (int j = 0; j < grid.length; j++) {
						for (int k = 0; k < grid[0].length; k++) {
							temp[j][k] = grid[j][k];
						}
					}
					grid = new char[temp.length][temp[0].length+1];
					for (int j = 0; j < grid.length; j++) {
						for (int k = 0; k < grid[0].length-1; k++) {
							if (k == 0) {
								grid[j][k] = '-';
							}
							grid[j][k+1] = temp[j][k];
						}
					}
				}
				if ((d-u+1) % 2 == 0) {
					char[][] temp = new char[grid.length][grid[0].length];
					for (int j = 0; j < grid.length; j++) {
						for (int k = 0; k < grid[0].length; k++) {
							temp[j][k] = grid[j][k];
						}
					}
					grid = new char[temp.length+1][temp[0].length];
					for (int j = 0; j < grid.length-1; j++) {
						for (int k = 0; k < grid[0].length; k++) {
							if (j == grid.length-2) {
								grid[j+1][k] = '-';
							}
							grid[j][k] = temp[j][k];
						}
					}
				}
				/*if ((r-l+1) % 2 == 0 && (d-u+1) % 2 == 0 && l-1 >= 0 && d+1 < h) {
					grid = new char[d-u+2][r-l+2];
					for (int j = u; j <= d+1; j++) {
						for (int k = l-1; k <= r; k++) {
							grid[j-u][k-(l-1)] = array[j][k];
						}
					}
				}*/
				/*for (int k = 0; k < grid.length; k++) {
					for (int j = 0; j < grid[k].length; j++) {
						System.out.print(grid[k][j]);
					}
					System.out.println();
				}*/
				boolean[] line = new boolean[7];
				int midh = (d-u+1)/2;
				for (int a = 1; a < grid[0].length - 1; a++) {
					if (grid[0][a] == '*') {
						line[0] = true;
					}
					if (grid[midh][a] == '*') {
						line[3] = true;
					}
					if (grid[grid.length-1][a] == '*') {
						line[6] = true;
					}
				}
				for (int a = 1; a < midh; a++) {
					if (grid[a][0] == '*') {
						line[1] = true;
					}
					if (grid[a][grid[0].length-1] == '*') {
						line[2] = true;
					}
				}
				for (int a = midh+1; a < grid.length-1; a++) {
					if (grid[a][0] == '*') {
						line[4] = true;
					}
					if (grid[a][grid[0].length-1] == '*') {
						line[5] = true;
					}
				}
				if (h == 3 || w == 3 || grid.length == 3 || grid[0].length == 3) {
					if (grid[0][0] == '*') {
						line[1] = true;
					}
					if (grid[0][grid[0].length-1] == '*') {
						line[2] = true;
					}
					if (grid[grid.length-1][0] == '*') {
						line[4] = true;
					}
					if (grid[grid.length-1][grid[0].length-1] == '*') {
						line[5] = true;
					}
				}
				//System.out.println(Arrays.toString(line));
				if (line[0] && line[1] && line[4] && line[2] && line[5] && line[6] && line[3]) {
					ans += 8;
				} else if (line[0] && line[1] && line[4] && line[2] && line[5] && line[6]) {
					ans += 0;
				} else if (line[0] && line[1] && line[4] && line[3] && line[5] && line[6]) {
					ans += 6;
				} else if (line[0] && line[1] && line[2] && line[3] && line[5] && line[6]) {
					ans += 9;
				} else if (line[0] && line[1] && line[3] && line[5] && line[6]) {
					ans += 5;
				} else if (line[0] && line[2] && line[3] && line[4] && line[6]) {
					ans += 2;
				} else if (line[0] && line[2] && line[3] && line[5] && line[6]) {
					ans += 3;
				} else if (line[1] && line[2] && line[3] && line[5]) {
					ans += 4;
				} else if (line[0] && line[2] && line[5]) {
					ans += 7;
				} else if ((line[2] && line[5]) || (line[1] && line[4])) {
					ans += 1;
				}
			}
			System.out.println(ans);
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
