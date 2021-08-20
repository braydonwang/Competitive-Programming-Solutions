import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int x = sc.nextInt(); int y = sc.nextInt();
		int cx = 0; int cy = 0;
		while (true) {
			int m = sc.nextInt(); int n = sc.nextInt();
			if (m == 0 && n == 0) {
				break;
			}
			cx += m;
			cy += n;
			if (cx > x) {
				cx = x;
			}
			else if (cx < 0) {
				cx = 0;
			}
			if (cy > y) {
				cy = y;
			}
			else if (cy < 0) {
				cy = 0;
			}
			System.out.println(cx + " " + cy);
		}
    }
}
