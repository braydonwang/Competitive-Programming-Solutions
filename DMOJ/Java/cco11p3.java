import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		/*int n = readInt();
		ArrayList<String> list = new ArrayList<String>();
		list.add("January");
		list.add("February");
		list.add("March");
		list.add("April");
		list.add("May");
		list.add("June");
		list.add("July");
		list.add("August");
		list.add("September");
		list.add("October");
		list.add("November");
		list.add("December");
		for (int i = 0; i < n; i++) {
			String str = readLine();
			String[] array = str.split(" ");
			for (int j = 0; j < array.length; j++) {
				if (isValid(array[j])) {
					if (isNumber(array[j].charAt(0)) && isNumber(array[j].charAt(1)) && isNumber(array[j].charAt(3)) && isNumber(array[j].charAt(4)) && isNumber(array[j].charAt(6)) && isNumber(array[j].charAt(7))) {
						if (array[j].charAt(2) == '/' && array[j].charAt(5) == '/') {
							int day = Integer.parseInt(array[j].substring(0,2));
							int month = Integer.parseInt(array[j].substring(3,5));
							int year = Integer.parseInt(array[j].substring(6,8));
							if (day >= 1 && day <= 31 && month >= 1 && month <= 12 && year >= 0 && year <= 99) {
								if (year <= 24) {
									year = year + 2000;
								}
								else {
									year = year + 1900;
								}
								System.out.print(array[j].substring(0,6) + year);
							}
						} else if (array[j].charAt(2) == '.' && array[j].charAt(5) == '.') {
							int year = Integer.parseInt(array[j].substring(0,2));
							int month = Integer.parseInt(array[j].substring(3,5));
							int day = Integer.parseInt(array[j].substring(6,8));
							if (day >= 1 && day <= 31 && month >= 1 && month <= 12 && year >= 0 && year <= 99) {
								if (year <= 24) {
									year = year + 2000;
								}
								else {
									year = year + 1900;
								}
								System.out.print(year + array[j].substring(2));
							}
						}
					}
				} else if (list.contains(array[j])){
					if (array.length - j >= 3) {
						String temp = array[j+1];
						temp.replaceAll(",", "");
						if (temp.length() == 2 && isNumber(temp.charAt(0)) && isNumber(temp.charAt(1))){
							int num = Integer.parseInt(temp);
							if (num >= 1 && num <= 31) {
								temp = array[j+2];
								temp.replaceAll(",", "");
								if (temp.length() == 2 && isNumber(temp.charAt(0)) && isNumber(temp.charAt(1))) {
									num = Integer.parseInt(temp);
									if (num <= 24) {
										num += 2000;
									}
									else {
										num += 1900;
									}
									System.out.print(array[j] + " " + array[j+1] + " " + num);
								}
							}
						}
					}
				}
				System.out.println();
			}
		}
		
		int n = readInt();
		int[][] dir = {{2,1},{2,-1},{1,2},{1,-2},{-2,1},{-2,-1},{-1,2},{-1,-2}};
		for (int i = 0; i < n; i++) {
			int r = readInt(), c = readInt(), pr = readInt(), pc = readInt(), kr = readInt(), kc = readInt();
			Queue<Integer> q = new LinkedList();
			int[][] dis = new int[r+1][c+1];
			q.add(kc); q.add(kr); dis[kr][kc] = 0;
			while (!q.isEmpty()) {
				int x = q.poll(), y = q.poll();
				for (int j = 0; j < dir.length; j++) {
					int newx = x + dir[j][0];
					int newy = y + dir[j][1];
					if (newx > 0 && newx <= c && newy > 0 && newy <= r) {
						q.add(newx); q.add(newy); dis[newy][newx] = dis[y][x] + 1;
						if (dis[newy][newx] > r-pr) {
							break;
						}
					}
				}
			}
			boolean win = false;
			boolean stale = false;
			for (int j = pr; j <= r; j++) {
				if (dis[j][pc] > 0) {
					if (dis[j][pc] == j-pr && dis[j][pc] < r-pr) {
						System.out.println("Win in " + dis[j][pc] + " knight move(s).");
						win = true;
						break;
					}
				}
			}
			if (!win) {
				for (int j = pr; j <= r; j++) {
					if (dis[j][pc] > 0) {
						if (dis[j][pc] == j-pr-1 && j != pr && dis[j][pc] < r-pr) {
							System.out.println("Stalemate in " + dis[j][pc] + " knight move(s).");
							stale = true;
							break;
						}
					}
				}
			}
			if (!win && !stale) {
				System.out.println("Loss in " + (r-pr-1) + " knight move(s).");
			}
		}
		
		int n = readInt(), c = readInt(), k = readInt();
		int[] cherry = new int[n];
		int totalCherry = 0;
		int totalWeight = 0;
		for (int i = 0; i < n; i++) {
			cherry[i] = readInt();
			totalCherry += cherry[i];
		}
		ArrayList<Edge> adj[] = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < n-1; i++) {
			int a = readInt(), b = readInt(), d = readInt();
			adj[a].add(new Edge(b,d)); adj[b].add(new Edge(a,d));
			totalWeight += d;
		}
		int count = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < adj[i].size(); j++) {
				Edge edge = adj[i].get(j);
				adj[i].remove(j);
				Queue<Integer> q = new LinkedList();
				boolean[] vis = new boolean[n+1];
				int total = cherry[0];
				int weight = 0;
				q.add(1); vis[1] = true;
				while (!q.isEmpty()) {
					int cur = q.poll();
					for (Edge nxt: adj[cur]) {
						if (!vis[nxt.v]) {
							if (nxt.v != edge.v || nxt.w != edge.w) {
								q.add(nxt.v);
								vis[nxt.v] = true;
								total += cherry[nxt.v-1];
								weight += nxt.w;
							}
						}
					}
				}
				if (totalCherry - total >= c && totalWeight - weight <= k){
					count++;
					System.out.println(edge.v + " " + edge.w);
				}
				adj[i].add(edge);
			}
		}
		System.out.println(count);*/
		
		int n = readInt();
        int m = readInt();
        int K = readInt();
        boolean vis[][] = new boolean [n+1][n+1];
        ArrayList<Integer> adj[] = new ArrayList [m+1];
        for (int k = 0; k < m+1; k++) {
            adj[k] = new ArrayList();
        }
        for (int k = 0; k < K; k++) {
            int x = readInt();
            int y = readInt();
            for (int nxt: adj[y]) {
                if (vis[x][nxt]) {
                    System.out.println("NO");
                    return;
                }
                vis[x][nxt] = vis[nxt][x] = true;
            }
            adj[y].add(x);
        }
        System.out.println("YES");
	}
	static class Edge{
		int v, w;
		Edge(int v, int w){
			this.v = v;
			this.w = w;
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
