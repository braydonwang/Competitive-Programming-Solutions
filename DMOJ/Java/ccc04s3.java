import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String[][] array;
	static int[][] ans;
	static boolean[][] vis;
	public static void main(String[] args) throws IOException {
		array = new String[10][9];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				array[i][j] = next();
			}
		}
		
		ans = new int[10][9];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				ans[i][j] = -1;
			}
		}
		while (true) {
			boolean flag = false;
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 9; j++) {
					if (ans[i][j] == -1) {
						vis = new boolean[10][9];
						ans[i][j] = solve(i,j);
						if (ans[i][j] != -1) {
							flag = true;
						}
					}
				}
			}
			if (!flag) {
				break;
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				if (ans[i][j] < 0) {
					System.out.print("* ");
				} else {
					System.out.print(ans[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
	static int solve(int row, int col) {
		if (vis[row][col] && ans[row][col] == -1) {
			ans[row][col] = -1;
			return -1;
		} else if (vis[row][col]) {
			return ans[row][col];
		}
		vis[row][col] = true;
		if (array[row][col].indexOf("+") == -1) {
			if (array[row][col].charAt(0) >= 'A' && array[row][col].charAt(0) <= 'J') {
				int newr = array[row][col].charAt(0) - 'A', newc = array[row][col].charAt(1) - '1';
				return solve(newr,newc);
			} else {
				return Integer.parseInt(array[row][col]);
			}
		}
		String str = array[row][col];
		int ind = 0, ret = 0;
		String temp = array[row][col];
		while (str.indexOf("+",ind) != -1) {
			temp = str.substring(ind,str.indexOf("+",ind));
			int newr = temp.charAt(0) - 'A', newc = temp.charAt(1) - '1';
			ind = str.indexOf("+",ind) + 1;
			int num = solve(newr,newc);
			if (num == -1) {
				ans[row][col] = -1;
				return -1;
			}
			ret += num;
		}
		temp = str.substring(ind);
		int newr = temp.charAt(0) - 'A', newc = temp.charAt(1) - '1';
		int num = solve(newr,newc);
		if (num == -1) {
			ans[row][col] = -1;
			return -1;
		}
		ret += num;
		return ret;
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
