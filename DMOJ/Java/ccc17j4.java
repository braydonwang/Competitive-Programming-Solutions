import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		int num = sc.nextInt(); int a = 1; int b = 2; int c = 0; int d = 0;
		int count = 0;
		for (int i = 0; i < num%720; i++) {
			d++;
			if (d == 10) {
				d = 0; c++;
			}
			if (c == 6) {
				c = 0; b++;
			}
			if (b == 10) {
				b = 0; a++;
			}
			if (b == 3 && a == 1) {
				b = 1; a = 0;
			}
			if (a == 2) {
				a = 0;
			}
			if (a == 0 && b-c == c-d) {
				count++;
			}
			else if (a != 0 && a-b == b-c && b-c == c-d) {
				count++;
			}
		}
		if (num < 720) {
			System.out.println(count);
		}
		else {
			System.out.println(count+(num/720)*31);
		}
    }
}
