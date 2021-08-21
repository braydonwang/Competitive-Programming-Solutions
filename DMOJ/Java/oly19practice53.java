import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		long sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		System.out.println(sum);
    }
}
