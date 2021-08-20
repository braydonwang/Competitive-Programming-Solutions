import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			List<Integer> adj[] = new ArrayList[x+1];
			ArrayList<String> list = new ArrayList<String>();
			for (int j = 0; j <= x; j++) {
				adj[j] = new ArrayList();
			}
			String root = "";
			for (int j = 0; j < x/2; j++) {
				String str1 = sc.next();
				String str2 = sc.next();
				if (!list.contains(str1)) {
					list.add(str1);
				}
				if (!list.contains(str2)) {
					list.add(str2);
				}
				adj[list.indexOf(str1)].add(list.indexOf(str2));
				adj[list.indexOf(str2)].add(list.indexOf(str1));
				if (j == x/2-1) {
					root = str2;
				}
			}
			Queue<Integer> q = new LinkedList();
			boolean[] vis = new boolean[x+1];
			int[] dis = new int[x+1];
			q.add(list.indexOf(root)); vis[list.indexOf(root)] = true;
			dis[list.indexOf(root)] = 0;
			int max = 0;
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int nxt: adj[cur]) {
					if (!vis[nxt]) {
						q.add(nxt);
						vis[nxt] = true;
						dis[nxt] = dis[cur] + 1;
						max = Math.max(dis[nxt], max);
					}
				}
			}
			System.out.println((x*10) - (max*20));
		}
    }
}
