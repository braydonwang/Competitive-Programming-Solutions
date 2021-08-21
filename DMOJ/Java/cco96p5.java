import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		ArrayList<String> list = new ArrayList<String>();
		List<Integer> adj[] = new ArrayList[n+1];
		for (int i = 0; i < n; i++) {
			String x = sc.next().substring(0,1);
			String y = sc.next().substring(0,1);
			if (!list.contains(x)) {
				list.add(x);
			}
			if (!list.contains(y)) {
				list.add(y);
			}
			if (adj[list.indexOf(x)] == null) {
				adj[list.indexOf(x)] = new ArrayList();
			}
			if (adj[list.indexOf(y)] == null) {
				adj[list.indexOf(y)] = new ArrayList();
			}
			adj[list.indexOf(x)].add(list.indexOf(y));
			adj[list.indexOf(y)].add(list.indexOf(x));
		}
		for (int i = 0; i < m; i++) {
			String a = sc.next().substring(0,1);
			String b = sc.next().substring(0,1);
			String c = b;
			Queue<Integer> q = new LinkedList();
			boolean[] vis = new boolean[n+1];
			int[] pre = new int[n+1];
			q.add(list.indexOf(a)); vis[list.indexOf(a)] = true; pre[list.indexOf(a)] = -1;
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int nxt: adj[cur]) {
					if (!vis[nxt]) {
						q.add(nxt); vis[nxt] = true; pre[nxt] = cur;
					}
				}
				if (vis[list.indexOf(b)]) {
					break;
				}
			}
			String temp = "";
			while (true) {
				temp += list.get(pre[list.indexOf(b)]);
				b = list.get(pre[list.indexOf(b)]);
				if (pre[list.indexOf(b)] == -1) {
					break;
				}
			}
			for (int k = temp.length()-1; k >= 0; k--) {
				System.out.print(temp.charAt(k));
			}
			System.out.print(c);
			System.out.println();
		}
    }
}
