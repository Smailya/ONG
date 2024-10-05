import java.util.*;

public class HtmlTagValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter HTML-like code:");
        String input = sc.nextLine();
        
        System.out.println("Is the input valid? " + isValidHtml(input));
    }

    public static boolean isValidHtml(String s) {
        Stack<String> stack = new Stack<>();
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '<') {
                // Check if it's a closing tag
                int j = s.indexOf('>', i);
                if (j == -1) {
                    return false; // No closing '>'
                }
                String tag = s.substring(i + 1, j);

                if (!tag.isEmpty() && tag.charAt(0) == '/') {
                    // Closing tag
                    String closingTag = tag.substring(1);
                    if (stack.isEmpty() || !stack.peek().equals(closingTag)) {
                        return false; // Mismatch in closing tag
                    }
                    stack.pop();
                } else {
                    // Opening tag
                    stack.push(tag);
                }
                i = j;
            }
            i++;
        }

        return stack.isEmpty();
    }
}
