public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a string with digits:");
    String input = sc.nextLine();
    System.out.println("Sum of digits: " + sumOfDigits(input));
}

public static int sumOfDigits(String s) {
    int sum = 0;
    for (char c : s.toCharArray()) {
        if (Character.isDigit(c)) {
            sum += Character.getNumericValue(c);
        }
    }
    return sum;
}
