import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		for (int a = 0; a < n; a++) {
			int r = sc.nextInt(), c = sc.nextInt();
			char[][] array = new char[r][c];
			for (int i = 0; i < r; i++) {
				String str = sc.next();
				for (int j = 0; j < c; j++) {
					array[i][j] = str.charAt(j);
				}
			}
			Queue<Integer> q = new LinkedList();
			boolean[][] vis = new boolean[r][c];
			int[][] dis = new int[r][c];
			boolean connect = false;
			q.add(0); q.add(0); vis[0][0] = true; dis[0][0] = 1;
			while (!q.isEmpty()) {
				int x = q.poll(), y = q.poll();
				if (array[y][x] == '|') {
					if (y - 1 >= 0 && array[y-1][x] != '*' && vis[y-1][x] == false) {
						q.add(x); q.add(y-1); vis[y-1][x] = true; dis[y-1][x] = dis[y][x] + 1;
					}
					if (y + 1 < r && array[y+1][x] != '*' && vis[y+1][x] == false) {
						q.add(x); q.add(y+1); vis[y+1][x] = true; dis[y+1][x] = dis[y][x] + 1;
					}
				}
				else if (array[y][x] == '-') {
					if (x - 1 >= 0 && array[y][x-1] != '*' && vis[y][x-1] == false) {
						q.add(x-1); q.add(y); vis[y][x-1] = true; dis[y][x-1] = dis[y][x] + 1;
					}
					if (x + 1 < c && array[y][x+1] != '*' && vis[y][x+1] == false) {
						q.add(x+1); q.add(y); vis[y][x+1] = true; dis[y][x+1] = dis[y][x] + 1;
					}
				}
				else {
					if (y - 1 >= 0 && array[y-1][x] != '*' && vis[y-1][x] == false) {
						q.add(x); q.add(y-1); vis[y-1][x] = true; dis[y-1][x] = dis[y][x] + 1;
					}
					if (y + 1 < r && array[y+1][x] != '*' && vis[y+1][x] == false) {
						q.add(x); q.add(y+1); vis[y+1][x] = true; dis[y+1][x] = dis[y][x] + 1;
					}
					if (x - 1 >= 0 && array[y][x-1] != '*' && vis[y][x-1] == false) {
						q.add(x-1); q.add(y); vis[y][x-1] = true; dis[y][x-1] = dis[y][x] + 1;
					}
					if (x + 1 < c && array[y][x+1] != '*' && vis[y][x+1] == false) {
						q.add(x+1); q.add(y); vis[y][x+1] = true; dis[y][x+1] = dis[y][x] + 1;
					}
				}
				if (vis[r-1][c-1]) {
					System.out.println(dis[r-1][c-1]);
					connect = true;
					break;
				}
			}
			if (!connect) {
				System.out.println(-1);
			}
		}
    }
}
