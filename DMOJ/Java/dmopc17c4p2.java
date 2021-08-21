import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), r = readInt();
		int[] val = new int[n];
		ArrayList<Integer> adj[] = new ArrayList[n+1];
		for (int i = 0; i < n; i++) {
			val[i] = readInt();
		}
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < n-1; i++) {
			int a = readInt(), b = readInt();
			adj[a].add(b);
			adj[b].add(a);
		}
		for (int i = 0; i < r; i++) {
			Queue<Integer> q = new LinkedList();
			ArrayList<Integer> list = new ArrayList<Integer>();
			boolean[] vis = new boolean[n+1];
			int[] pre = new int[n+1];
			int num = readInt(), x = readInt(), y = readInt();
			q.add(x); vis[x] = true; pre[x] = -1;
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int nxt: adj[cur]) {
					if (!vis[nxt]) {
						q.add(nxt);
						vis[nxt] = true;
						pre[nxt] = cur;
					}
				}
			}
			list.add(val[y-1]);
			while (pre[y] != -1) {
				list.add(val[pre[y]-1]);
				y = pre[y];
			}
			if (num == 1) {
				int sum = 0;
				for (int j = 0; j < list.size(); j++){
					sum += list.get(j);
				}
				sum = (int) (Math.round((sum / (list.size()*1.0))));
				System.out.println(sum);
			} else if (num == 2) {
				Collections.sort(list);
				if (list.size() % 2 == 0) {
					int temp = list.size() / 2;
					int median = (int) (Math.round((list.get(temp) + list.get(temp-1))/2.0));
					System.out.println(median);
				} else {
					int temp = list.size() / 2;
					System.out.println(list.get(temp));
				}
			} else {
				TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
				int max = 0;
				for (int j = 0; j < list.size(); j++) {
					map.put(list.get(j), map.getOrDefault(list.get(j), 0)+1);
					max = Math.max(map.get(list.get(j)), max);
				}
				for (int key: map.keySet()) {
					if (map.get(key) == max) {
						System.out.println(key);
						break;
					}
				}
			}
		}
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
