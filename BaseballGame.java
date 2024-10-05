public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter operations separated by space (e.g., 5 -2 C D +):");
    String[] ops = sc.nextLine().split(" ");
    System.out.println("Total Score: " + calculateScore(ops));
}

public static int calculateScore(String[] ops) {
    List<Integer> scores = new ArrayList<>();
    
    for (String op : ops) {
        if (op.equals("C")) {
            scores.remove(scores.size() - 1);
        } else if (op.equals("D")) {
            scores.add(2 * scores.get(scores.size() - 1));
        } else if (op.equals("+")) {
            scores.add(scores.get(scores.size() - 1) + scores.get(scores.size() - 2));
        } else {
            scores.add(Integer.parseInt(op));
        }
    }
    
    return scores.stream().mapToInt(Integer::intValue).sum();
}
