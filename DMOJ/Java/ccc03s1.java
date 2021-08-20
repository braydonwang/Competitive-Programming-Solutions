import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		int total = 1;
		while (true) {
			int num = sc.nextInt();
			if (num == 0) {
				System.out.println("You Quit!");
				break;
			}
			if (total + num <= 100) {
				if (total + num == 54) {
					total = 19;
				}
				else if (total + num == 90) {
					total = 48;
				}
				else if (total + num == 99) {
					total = 77;
				}
				else if (total + num == 9) {
					total = 34;
				}
				else if (total + num == 40) {
					total = 64;
				}
				else if (total + num == 67) {
					total = 86;
				}
				else {
					total+= num;
				}
			}
			System.out.println("You are now on square " + total);
			
			if (total == 100) {
				System.out.println("You Win!");
				break;
			}
		}
    }
}
