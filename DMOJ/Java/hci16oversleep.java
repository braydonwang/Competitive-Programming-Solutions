import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int r = sc.nextInt(), c = sc.nextInt();
		int sx = 0, sy = 0, ex = 0, ey = 0;
		char[][] array = new char[r][c];
		for (int i = 0; i < r; i++) {
			String str = sc.next();
			for (int j = 0; j < c; j++) {
				array[i][j] = str.charAt(j);
				if (array[i][j] == 's') {
					sx = j;
					sy = i;
				}
				else if (array[i][j] == 'e') {
					ex = j;
					ey = i;
				}
			}
		}
		Queue<Integer> q = new LinkedList();
		boolean[][] vis = new boolean[r][c];
		int[][] dis = new int[r][c];
		int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
		q.add(sx); q.add(sy); vis[sy][sx] = true; dis[sy][sx] = 0;
		while (!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();
			for (int i = 0; i < 4; i++) {
				int newx = x + direction[i][0];
				int newy = y + direction[i][1];
				if (newx >= 0 && newx < c && newy >= 0 && newy < r && !vis[newy][newx] && array[newy][newx] != 'X') {
					q.add(newx); q.add(newy); vis[newy][newx] = true; dis[newy][newx] = dis[y][x] + 1;
				}
			}
		}
		if (!vis[ey][ex]) {
			System.out.println(-1);
		} 
		else {
			System.out.println(dis[ey][ex]-1);
		}
    }
}
