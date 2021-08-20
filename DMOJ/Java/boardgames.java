import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		boolean[] vis = new boolean[1000000];
		int[] dis = new int[1000000];
		Queue<Integer> q = new LinkedList();
		q.add(n); vis[n] = true; dis[n] = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur*3 < 1000000 && !vis[cur*3]) {
				q.add(cur*3); vis[cur*3] = true; dis[cur*3] = dis[cur]+1;
			}
			if (cur - 1 > 0 && !vis[cur-1]) {
				q.add(cur-1); vis[cur-1] = true; dis[cur-1] = dis[cur]+1;
			}
			if (cur - 3 > 0 && !vis[cur-3]) {
				q.add(cur-3); vis[cur-3] = true; dis[cur-3] = dis[cur]+1;
			}
			if (cur % 2 == 0 && !vis[cur/2]) {
				q.add(cur/2); vis[cur/2] = true; dis[cur/2] = dis[cur]+1;
			}
			if (vis[m]) {
				break;
			}
		}
		System.out.println(dis[m]);
    }
}
