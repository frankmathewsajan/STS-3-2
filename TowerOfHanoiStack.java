import java.util.Stack;

public class TowerOfHanoiStack {
    public static void main(String[] args) {
        int n = 3;
        if (args.length > 0) {
            try { n = Integer.parseInt(args[0]); }
            catch (NumberFormatException e) { System.err.println("Invalid number, using 3"); }
        }
        if (n <= 0) return;

        Stack<Integer> source = new Stack<>();
        Stack<Integer> auxiliary = new Stack<>();
        Stack<Integer> destination = new Stack<>();
        String sName = "S", aName = "A", dName = "D";

        for (int i = n; i >= 1; i--) source.push(i);

        // If number of disks is even, swap auxiliary and destination
        if (n % 2 == 0) {
            Stack<Integer> tmpS = auxiliary; auxiliary = destination; destination = tmpS;
            String tmpN = aName; aName = dName; dName = tmpN;
        }

        long totalMoves = (long) Math.pow(2, n) - 1;
        for (long i = 1; i <= totalMoves; i++) {
            switch ((int)(i % 3)) {
                case 1 -> moveBetweenPoles(source, destination, sName, dName);
                case 2 -> moveBetweenPoles(source, auxiliary, sName, aName);
                default -> moveBetweenPoles(auxiliary, destination, aName, dName);
            }
        }
    }

    private static void moveBetweenPoles(Stack<Integer> src, Stack<Integer> dest, String sName, String dName) {
        if (src.isEmpty()) {
            int disk = dest.pop();
            src.push(disk);
            System.out.printf("Move disk %d from %s to %s%n", disk, dName, sName);
        } else if (dest.isEmpty()) {
            int disk = src.pop();
            dest.push(disk);
            System.out.printf("Move disk %d from %s to %s%n", disk, sName, dName);
        } else if (src.peek() > dest.peek()) {
            int disk = dest.pop();
            src.push(disk);
            System.out.printf("Move disk %d from %s to %s%n", disk, dName, sName);
        } else {
            int disk = src.pop();
            dest.push(disk);
            System.out.printf("Move disk %d from %s to %s%n", disk, sName, dName);
        }
    }
}