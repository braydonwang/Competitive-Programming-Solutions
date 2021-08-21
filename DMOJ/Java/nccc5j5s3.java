import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		List<Integer> adj[] = new ArrayList[n+1];
		int[] array = new int[m*2];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < 2*m; i+=2) {
			int a = sc.nextInt(), b = sc.nextInt();
			array[i] = a; array[i+1] = b;
			adj[a].add(b);
		}
		int removed1 = 0, removed2 = 0;
		for (int i = 0; i < m*2; i+=2) {
			if (removed1 != 0 && removed2 != 0) {
				adj[removed1].add(removed2);
			}
			Queue<Integer> q = new LinkedList();
			boolean[] vis = new boolean[n+1];
			q.add(1); vis[1] = true;
			removed1 = array[i]; removed2 = array[i+1];
			adj[removed1].remove(adj[removed1].indexOf(removed2));
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int nxt: adj[cur]) {
					if (!vis[nxt]) {
						q.add(nxt);
						vis[nxt] = true;
					}
				}
			}
			if (vis[n]) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
    }
}
