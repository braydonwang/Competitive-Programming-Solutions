import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		int count = 0;
		Stack<Integer> s = new Stack<Integer>();
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			if (!s.isEmpty() && x == 0) {
				s.pop();
			}
			else {
				s.push(x);
			}
		}
		if (s.isEmpty()) {
			System.out.println(0);
		}
		else {
			while (!s.isEmpty()) {
				count = count + s.pop();
			}
			System.out.println(count);
		}
    }
}
