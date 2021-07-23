import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int max = (int)1 << 30;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for (int a = 0; a < t; a++) {
			int n = readInt(), m = readInt(), f = readInt(), k = readInt();
			if (f >= n+m){
			    System.out.println("0.00");
			    continue;
			}
			double[][][] dp = new double[n+1][m+1][f+1];
			double[][] c = new double[n+1][m+1];
			for (int i = 0; i <= n; i++) {
				for (int j = 0; j <= m; j++) {
					c[i][j] = max;
					for (int l = 0; l <= f; l++) {
						dp[i][j][l] = max;
					}
				}
			}
			for (int i = 0; i < k; i++) {
				int x = readInt(), y = readInt();
				double z = readDouble();
				c[x][y] = Math.min(c[x][y], z);
			}
			dp[1][1][f] = 0;
			Queue<Node> q = new LinkedList();
			int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
			q.add(new Node(1,1,f,0));
			while (!q.isEmpty()) {
				Node cur = q.poll();
				int row = cur.row, col = cur.col, fuel = cur.fuel;
				double cost = cur.cost;
				if (dp[row][col][fuel] < cost){
				    continue;
				}
				for (int i = 0; i < 4; i++) {
					int newr = row + dir[i][0], newc = col + dir[i][1];
					if (newr >= 1 && newr <= n && newc >= 1 && newc <= m) {
						if (c[row][col] != max) {
							for (int j = fuel-1; j < f; j++) {
								double newCost = (j - (fuel - 1)) * c[row][col] + cost;
								if (j < 0 || dp[newr][newc][j] <= newCost) {
									continue;
								}
								dp[newr][newc][j] = newCost;
								q.add(new Node(newr,newc,j,newCost));
							}
						} else {
							if (fuel == 0) {
								continue;
							}
							if (dp[newr][newc][fuel-1] <= cost) {
								continue;
							}
							dp[newr][newc][fuel-1] = cost;
							q.add(new Node(newr,newc,fuel-1,cost));
						}
					}
				}
			}
			double min = max;
			for (int i = 0; i <= f; i++) {
				min = Math.min(min,dp[n][m][i]);
			}
			if (min == max) {
				System.out.println("Stranded on the shoulder");
			} else {
				System.out.printf("%.2f", min);
				System.out.println();
			}
		}
	}
	static class Node{
		int row, col, fuel;
		double cost;
		Node(int row, int col, int fuel, double cost){
			this.row = row;
			this.col = col;
			this.fuel = fuel;
			this.cost = cost;
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
