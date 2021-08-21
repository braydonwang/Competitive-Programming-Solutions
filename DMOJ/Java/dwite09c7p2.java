import java.io.*;
import java.util.*;

public class Main {
    public static boolean isPrime(int x) {
		if (x == 2 || x == 3) {
			return true;
		}
		else {
			for (int i = 2; i <= Math.sqrt(x); i++) {
				if (x % i == 0) {
					return false;
				}
			}
			return true;
		}
	}
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		for (int i = 0; i < 5; i++) {
			int sum = 0;
			int num = sc.nextInt();
			for (int j = 2; j <= num; j++) {
				if (isPrime(j)) {
					sum+= j;
				}
			}
			System.out.println(sum);
		}
    }
}
