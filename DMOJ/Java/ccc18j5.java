import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		List<Integer> adj[] = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList();
			int m = sc.nextInt();
			for (int j = 1; j <= m; j++) {
				adj[i].add(sc.nextInt());
			}
		}
		Queue<Integer> q = new LinkedList();
		boolean vis[] = new boolean[n+1]; int dis[] = new int[n+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		q.add(1); vis[1] = true; dis[1] = 1;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int nxt: adj[cur]) {
				if (!vis[nxt]) {
					q.add(nxt);
					vis[nxt] = true;
					dis[nxt] = dis[cur] + 1;
				}
			}
		}
		boolean flag = true;
		for (int i = 1; i <= n; i++) {
			if (!vis[i]) {
				flag = false;
			}
		}
		System.out.println(flag? "Y": "N");
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			if (adj[i].isEmpty()) {
				ans = Math.min(ans, dis[i]);
			}
		}
		System.out.println(ans);
    }
}
