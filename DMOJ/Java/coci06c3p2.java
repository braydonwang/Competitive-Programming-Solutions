import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		int scatter = 0;
		int a,b;
		for (int i = 0; i < 4; i++) {
		    String str = sc.nextLine();
			for (int j = 0; j < 4; j++) {
                if (str.charAt(j) != '.'){
                    a = (str.charAt(j) - 65) % 4;
                    b = (str.charAt(j) - 65) / 4;
                    scatter += Math.abs(i-b) + Math.abs(j-a);
                }
			}
		}
		System.out.println(scatter);
    }
}
