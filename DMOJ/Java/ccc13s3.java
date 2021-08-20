import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int count = 0;
	static int t;
	public static void main(String[] args) throws IOException {
		t = readInt(); int g = readInt();
		boolean[][] vis = new boolean[5][5];
		int[] score = new int[5];
		for (int i = 0; i < g; i++) {
			int a = readInt(), b = readInt(), c = readInt(), d = readInt();
			vis[a][b] = true; vis[b][a] = true;
			if (c > d) {
				score[a] += 3;
			} else if (c < d) {
				score[b] += 3;
			} else {
				score[a]++; score[b]++;
			}
		}
		solve(vis,score);
		System.out.println(count);
	}
	static void solve(boolean[][] vis, int[] score) {
		int[] b = score;
		if (!vis[1][2]) {
			vis[1][2] = true;
			b[1] += 3; solve(vis,b); b[1] -= 3;
			b[2] += 3; solve(vis,b); b[2] -= 3;
			b[1]++; b[2]++; solve(vis,b); b[1]--; b[2]--;
			vis[1][2] = false;
		} else if (!vis[1][3]) {
			vis[1][3] = true;
			b[1] += 3; solve(vis,b); b[1] -= 3;
			b[3] += 3; solve(vis,b); b[3] -= 3;
			b[1]++; b[3]++; solve(vis,b); b[1]--; b[3]--;
			vis[1][3] = false;
		} else if (!vis[1][4]) {
			vis[1][4] = true;
			b[1] += 3; solve(vis,b); b[1] -= 3;
			b[4] += 3; solve(vis,b); b[4] -= 3;
			b[1]++; b[4]++; solve(vis,b); b[1]--; b[4]--;
			vis[1][4] = false;
		} else if (!vis[2][3]) {
			vis[2][3] = true;
			b[2] += 3; solve(vis,b); b[2] -= 3;
			b[3] += 3; solve(vis,b); b[3] -= 3;
			b[2]++; b[3]++; solve(vis,b); b[2]--; b[3]--;
			vis[2][3] = false;
		} else if (!vis[2][4]) {
			vis[2][4] = true;
			b[2] += 3; solve(vis,b); b[2] -= 3;
			b[4] += 3; solve(vis,b); b[4] -= 3;
			b[2]++; b[4]++; solve(vis,b); b[2]--; b[4]--;
			vis[2][4] = false;
		} else if (!vis[3][4]) {
			vis[3][4] = true;
			b[3] += 3; solve(vis,b); b[3] -= 3;
			b[4] += 3; solve(vis,b); b[4] -= 3;
			b[3]++; b[4]++; solve(vis,b); b[3]--; b[4]--;
			vis[3][4] = false;
		} else {
			boolean good = true;
			for (int i = 1; i <= 4; i++) {
				if (t == i) {
					continue;
				}
				if (b[i] >= b[t]) {
					good = false;
					break;
				}
			}
			if (good) {
				count++;
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
