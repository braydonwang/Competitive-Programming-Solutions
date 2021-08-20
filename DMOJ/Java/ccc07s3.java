import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		List<Integer> adj[] = new ArrayList[10000];
		for (int i = 0; i <= 9999; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt(), y = sc.nextInt();
			adj[x].add(y);
		}
		while (true) {
			int a = sc.nextInt(), b = sc.nextInt();
			if (a == 0 && b == 0) {
				break;
			}
			boolean[] vis = new boolean[10000];
			int[] dis = new int[10000];
			Queue<Integer> q = new LinkedList<>();
			q.add(a); vis[a] = true; dis[a] = -1;
			boolean connect = false;
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int nxt: adj[cur]) {
					if (!vis[nxt]) {
						q.add(nxt);
						vis[nxt] = true;
						dis[nxt] = dis[cur] + 1;
					}
				}
				if (vis[b]) {
					System.out.println("Yes " + dis[b]);
					connect = true;
					break;
				}
			}
			if (!connect) {
				System.out.println("No");
			}
		}
    }
}
