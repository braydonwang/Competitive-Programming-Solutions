import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
	    Stack<Character> stack = new Stack<Character>();
		String str = sc.nextLine();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == ')') {
				if (!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
					continue;
				}
			}
			stack.push(ch);
		}
		if (stack.isEmpty()) {
			System.out.println("YES");
		}
		else if (stack.size() == 2){
			char a = stack.peek();
			stack.pop();
			char b = stack.peek();
			stack.pop();
			if (a == b) {
				System.out.println("YES");
			}
		}
		else {
			System.out.println("NO");
		}
    }
}
