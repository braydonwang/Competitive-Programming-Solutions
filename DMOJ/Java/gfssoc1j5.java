import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt(), m = sc.nextInt(), t = sc.nextInt();
		List<Integer> adj[] = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0 ; i < m; i++) {
			adj[sc.nextInt()].add(sc.nextInt());
		}
		int x = sc.nextInt();
		for (int i = 0; i < x; i++) {
			Queue<Integer> q = new LinkedList();
			boolean[] vis = new boolean[n+1];
			int[] dis = new int[n+1];
			int a = sc.nextInt(), b = sc.nextInt();
			q.add(a); vis[a] = true; dis[a] = 0;
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int nxt: adj[cur]) {
					if (!vis[nxt]) {
						q.add(nxt); vis[nxt] = true; dis[nxt] = dis[cur]+1;
					}
				}
				if (vis[b]){
				    break;
				}
			}
			if (vis[b]) {
				System.out.println(dis[b]*t);
			}
			else {
				System.out.println("Not enough hallways!");
			}
		}
    }
}
