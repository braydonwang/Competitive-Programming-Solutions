import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		List<Integer> adj[] = new ArrayList[n+1];
		for(int i = 0; i <= n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt(), y = sc.nextInt();
			adj[x].add(y); adj[y].add(x);
		}
		int w = sc.nextInt();
		Queue<Integer> Q = new LinkedList();
		boolean[] visited = new boolean[n+1];
		for (int i = 0; i < w; i++) {
			int a = sc.nextInt();
			Q.add(a);
			visited[a] = true;
		}
		Queue<Integer> q = new LinkedList();
		boolean[] vis = new boolean[n+1];
		int[] dis = new int[n+1];
		int count = 0;
		q.add(1); vis[1] = true; dis[1] = 0;
		while (!q.isEmpty()) {
			count++;
			int cur = q.poll();
			for (int nxt: adj[cur]) {
				if (!vis[nxt] && !visited[nxt]) {
					q.add(nxt); vis[nxt] = true; dis[nxt] = dis[cur]+1;
				}
			}
			if (count % 4 == 0) {
				for (int i = 0; i < Q.size(); i++) {
					int curr = Q.poll();
					for (int e: adj[curr]) {
						if (!visited[e]) {
							visited[e] = true;
						}
					}
				}
			}
		}
		if (vis[n]) {
			System.out.println(dis[n]);
		}
		else {
			System.out.println("sacrifice bobhob314");
		}
    }
}
