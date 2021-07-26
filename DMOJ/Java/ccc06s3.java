import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int xr = readInt(), yr = readInt(), xj = readInt(), yj = readInt();
		double slope = 0, b = 0;
		if (xr == xj) {
			slope = Integer.MAX_VALUE;
		} else if (yr == yj) {
			slope = 0;
		} else {
			slope = (yj - yr*1.0) / (xj - xr);
			b = yr - slope * xr;
		}
		int n = readInt();
		int count = 0;
		for (int i = 0; i < n; i++) {
			boolean done = false;
			int c = readInt();
			int prex = readInt(), prey = readInt();
			int startx = prex, starty = prey;
			for (int j = 1; j < c; j++) {
				int curx = readInt(), cury = readInt();
				if (done) {
					continue;
				}
				if (cury == prey) {
					if (slope == Integer.MAX_VALUE) {
						double x = xr, y = cury;
						if (check(x,y,xr,yr,xj,yj,prex,prey,curx,cury)) {
							count++;
							done = true;
						}
					} else if (slope == 0) {
						if (yr == cury) {
							count++;
							done = true;
						}
					} else {
						double x = (cury - b) / (slope*1.0), y = cury;
						if (check(x,y,xr,yr,xj,yj,prex,prey,curx,cury)) {
							count++;
							done = true;
						}
					}
				} else if (curx == prex) {
					if (slope == Integer.MAX_VALUE) {
						if (curx == xr) {
							count++;
							done = true;
						}
					} else if (slope == 0) {
						double x = curx, y = yr;
						if (check(x,y,xr,yr,xj,yj,prex,prey,curx,cury)) {
							count++;
							done = true;
						}
					} else {
						double x = curx, y = slope * curx + b;
						if (check(x,y,xr,yr,xj,yj,prex,prey,curx,cury)) {
							count++;
							done = true;
						}
					}
				} else {
					double s = (cury - prey*1.0) / (curx - prex), bb = cury - s * curx;
					if (slope == Integer.MAX_VALUE) {
						double x = xr, y = s * xr + bb;
						if (check(x,y,xr,yr,xj,yj,prex,prey,curx,cury)) {
							count++;
							done = true;
						}
					} else if (slope == 0) {
						double x = (yr - bb) / (s*1.0), y = yr;
						if (check(x,y,xr,yr,xj,yj,prex,prey,curx,cury)) {
							count++;
							done = true;
						}
					} else {
						double x = (bb - b*1.0) / (slope - s), y = slope * x + b;
						if (check(x,y,xr,yr,xj,yj,prex,prey,curx,cury)) {
							count++;
							done = true;
						}
					}
				}
				prex = curx; prey = cury;
			}
			if (done) {
				continue;
			}
			int cury = starty, curx = startx;
			if (cury == prey) {
				if (slope == Integer.MAX_VALUE) {
					double x = xr, y = cury;
					if (check(x,y,xr,yr,xj,yj,prex,prey,curx,cury)) {
						count++;
						done = true;
					}
				} else if (slope == 0) {
					if (yr == cury) {
						count++;
						done = true;
					}
				} else {
					double x = (cury - b) / (slope*1.0), y = cury;
					if (check(x,y,xr,yr,xj,yj,prex,prey,curx,cury)) {
						count++;
						done = true;
					}
				}
			} else if (curx == prex) {
				if (slope == Integer.MAX_VALUE) {
					if (curx == xr) {
						count++;
						done = true;
					}
				} else if (slope == 0) {
					double x = curx, y = yr;
					if (check(x,y,xr,yr,xj,yj,prex,prey,curx,cury)) {
						count++;
						done = true;
					}
				} else {
					double x = curx, y = slope * curx + b;
					if (check(x,y,xr,yr,xj,yj,prex,prey,curx,cury)) {
						count++;
						done = true;
					}
				}
			} else {
				int s = (cury - prey) / (curx - prex), bb = cury - s * curx;
				if (slope == Integer.MAX_VALUE) {
					double x = xr, y = s * xr + bb;
					if (check(x,y,xr,yr,xj,yj,prex,prey,curx,cury)) {
						count++;
						done = true;
					}
				} else if (slope == 0) {
					double x = (yr - bb) / (s*1.0), y = yr;
					if (check(x,y,xr,yr,xj,yj,prex,prey,curx,cury)) {
						count++;
						done = true;
					}
				} else {
					double x = (bb - b*1.0) / (slope - s), y = slope * x + b;
					if (check(x,y,xr,yr,xj,yj,prex,prey,curx,cury)) {
						count++;
						done = true;
					}
				}
			}
		}
		System.out.println(count);
	}
	static boolean check(double x, double y, int xr, int yr, int xj, int yj, int prex, int prey, int curx, int cury) {
		if (x >= Math.min(xr, xj) && x <= Math.max(xr, xj) && x >= Math.min(prex, curx) && x <= Math.max(prex,curx) && y >= Math.min(yr, yj) && y <= Math.max(yr, yj) && y >= Math.min(prey, cury) && y <= Math.max(prey, cury)){
			return true;
		}
		return false;
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
