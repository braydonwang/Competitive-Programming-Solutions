import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt(), m = sc.nextInt(), count = 0;
		for (int i = 0; i < 500; i++) {
			if (i*i*i >= n && i*i*i <= m && Math.sqrt(i*i*i) == (int)(Math.sqrt(i*i*i))) {
				count++;
			} else if (i*i*i > m) {
				break;
			}
		}
		System.out.println(count);
	}
}
