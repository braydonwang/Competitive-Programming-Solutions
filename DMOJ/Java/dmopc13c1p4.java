import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int l = sc.nextInt(), w = sc.nextInt();
			int cx = 0, cy = 0, wx = 0, wy = 0;
			char[][] array = new char[w][l];
			for (int j = 0; j < w; j++) {
				String str = sc.next();
				for (int k = 0; k < str.length(); k++) {
					array[j][k] = str.charAt(k);
					if (array[j][k] == 'C') {
						cx = k; cy = j;
					} else if (array[j][k] == 'W') {
						wx = k; wy = j;
					}
				}
			}
			Queue<Integer> q = new LinkedList();
			boolean[][] vis = new boolean[w][l];
			int[][] dis = new int[w][l];
			q.add(cx); q.add(cy); vis[cy][cx] = true; dis[cy][cx] = 0;
			while (!q.isEmpty()) {
				int x = q.poll();
				int y = q.poll();
				if (x-1 >= 0 && array[y][x-1] != 'X' && vis[y][x-1] == false) {
					q.add(x-1);
					q.add(y);
					vis[y][x-1] = true;
					dis[y][x-1] = dis[y][x]+1;
				}
				if (y-1 >= 0 && array[y-1][x] != 'X' && vis[y-1][x] == false) {
					q.add(x);
					q.add(y-1);
					vis[y-1][x] = true;
					dis[y-1][x] = dis[y][x]+1;
				}
				if (x+1 < l && array[y][x+1] != 'X' && vis[y][x+1] == false) {
					q.add(x+1);
					q.add(y);
					vis[y][x+1] = true;
					dis[y][x+1] = dis[y][x]+1;
				}
				if (y+1 < w && array[y+1][x] != 'X' && vis[y+1][x] == false) {
					q.add(x);
					q.add(y+1);
					vis[y+1][x] = true;
					dis[y+1][x] = dis[y][x]+1;
				}
				if (vis[wy][wx]) {
					break;
				}
			}
			if (dis[wy][wx] < 60 && vis[wy][wx]) {
				System.out.println(dis[wy][wx]);
			}
			else {
				System.out.println("#notworth");
			}
		}
    }
}
