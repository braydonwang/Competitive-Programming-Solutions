import java.util.*;
public class P2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		for (int i = 0; i < 5; i++) {
			boolean balanced = true;
			Stack<Character> s = new Stack<Character>();
			String str = sc.nextLine();
			for (int j = 0; j < str.length(); j++) {
				char ch = str.charAt(j);
				if (ch == '(' || ch == '[' || ch == '{') {
					s.push(ch);
				}
				else if (ch == ')') {
					if (!s.isEmpty() && s.peek() == '(') {
						s.pop();
					}
					else {
						balanced = false;
						break;
					}
				}
				else if (ch == ']') {
					if (!s.isEmpty() && s.peek() == '[') {
						s.pop();
					}
					else {
						balanced = false;
						break;
					}
				}
				else if (ch == '}') {
					if (!s.isEmpty() && s.peek() == '{') {
						s.pop();
					}
					else {
						balanced = false;
						break;
					}
				}
			}
			if (s.isEmpty() && balanced == true) {
				System.out.println("balanced");
			}
			else {
				System.out.println("not balanced");
			}
		}
	}
}
