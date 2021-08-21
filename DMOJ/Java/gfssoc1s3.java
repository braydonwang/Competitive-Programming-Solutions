import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Queue<String> line = new LinkedList();
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), t = readInt();
		char[][] array = new char[n][m];
		int gx = 0, gy = 0;
		int[] hx = new int[t], hy = new int[t];
		int count = 0;
		for (int i = 0; i < n; i++) {
			String str = next();
			for (int j = 0; j < m; j++) {
				array[i][j] = str.charAt(j);
				if (array[i][j] == 'G') {
					gx = j; gy = i;
				} else if (array[i][j] == 'H') {
					hx[count] = j; hy[count] = i; count++;
				}
			}
		}
		String temp = "";
		for (int i = 1; i <= t; i++) {
			temp += Integer.toString(i);
		}
		permutation(temp);
		int min = Integer.MAX_VALUE;
		while (!line.isEmpty()) {
			int total = 0;
			String str = line.poll();
			for (int i = 0; i < t; i++) {
				int first = 0;
				int second = 0;
				if (i == 0) {
					first = 0;
					second = Integer.parseInt(str.substring(0,1));
				} else {
					first = Integer.parseInt(str.substring(i-1,i));
					second = Integer.parseInt(str.substring(i,i+1));
				}
				Queue<Integer> q = new LinkedList();
				boolean[][] vis = new boolean[n][m];
				int[][] dis = new int[n][m];
				if (first == 0) {
					q.add(gx); q.add(gy); vis[gy][gx] = true; dis[gy][gx] = 0;
				} else {
					q.add(hx[first-1]); q.add(hy[first-1]);
					vis[hy[first-1]][hx[first-1]] = true;
					dis[hy[first-1]][hx[first-1]] = 0;
				}
				while (!q.isEmpty()) {
					int x = q.poll();
					int y = q.poll();
					if (x + 1 < m && array[y][x+1] != 'X' && !vis[y][x+1]) {
						q.add(x+1); q.add(y); vis[y][x+1] = true; dis[y][x+1] = dis[y][x]+1;
					}
					if (x - 1 >= 0 && array[y][x-1] != 'X' && !vis[y][x-1]) {
						q.add(x-1); q.add(y); vis[y][x-1] = true; dis[y][x-1] = dis[y][x]+1;
					}
					if (y + 1 < n && array[y+1][x] != 'X' && !vis[y+1][x]) {
						q.add(x); q.add(y+1); vis[y+1][x] = true; dis[y+1][x] = dis[y][x]+1;
					}
					if (y - 1 >= 0 && array[y-1][x] != 'X' && !vis[y-1][x]) {
						q.add(x); q.add(y-1); vis[y-1][x] = true; dis[y-1][x] = dis[y][x]+1;
					}
				}
				total += dis[hy[second-1]][hx[second-1]];
			}
			min = Math.min(total, min);
		}
		System.out.println(min);
	}
	public static void permutation(String str) {
        permutation2("", str);
    }
 
    private static void permutation2(String prefix, String str) {
        int n = str.length();
        if (n == 0) line.add(prefix);
        else {
            for (int i = 0; i < n; i++) {
                permutation2(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
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
