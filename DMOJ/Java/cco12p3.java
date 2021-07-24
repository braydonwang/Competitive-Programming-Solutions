import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String str;
	static int n;
	static int[][][] dp;
	static int[][] array;
	static ArrayList<Pair> adj[];
	public static void main(String[] args) throws IOException {
		int v = readInt(), t = readInt();
		int start = readCharacter() - 'A';
		for (int i = 1; i < v; i++) {
			char ch = readCharacter();
		}
		for (int i = 0; i < t; i++) {
			char ch = readCharacter();
		}
		array = new int[26][26];
		int r1 = readInt();
		for (int i = 0; i < r1; i++) {
			char a = readCharacter(), b = readCharacter();
			array[b-'a'][a-'A'] = 1;
		}
		int r2 = readInt();
		adj = new ArrayList[26];
		for (int i = 0; i < 26; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < r2; i++) {
			char a = readCharacter(), b = readCharacter(), c = readCharacter();
			adj[a-'A'].add(new Pair(b-'A',c-'A'));
		}
		int w = readInt();
		for (int i = 0; i < w; i++) {
			str = next();
			n = str.length();
			dp = new int[n][n][26];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					Arrays.fill(dp[j][k], -1);
				}
			}
			System.out.println(solve(0,n-1,start));
		}
	}
	static int solve(int l, int r, int ch) {
		if (l == r) {
			return array[str.charAt(l)-'a'][ch];
		}
		if (dp[l][r][ch] != -1) {
			return dp[l][r][ch];
		}
		dp[l][r][ch] = 0;
		for (int i = l; i < r; i++) {
			for (Pair p: adj[ch]) {
				if (solve(l,i,p.f) == 1 && solve(i+1,r,p.s) == 1) {
					dp[l][r][ch] = 1;
					break;
				}
			}
			if (dp[l][r][ch] == 1) {
				break;
			}
		}
		return dp[l][r][ch];
	}
	static class Pair{
		int f, s;
		Pair(int f, int s){
			this.f = f;
			this.s = s;
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
