import java.util.*;

public class TowerOfHanoi {
    static Stack<Integer> src = new Stack<>();
    static Stack<Integer> aux = new Stack<>();
    static Stack<Integer> dest = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = n; i >= 1; i--) src.push(i);
        char s = 's', a = 'a', d = 'd';
        if (n % 2 == 0) {
            char t = d;
            d = a;
            a = t;
        }
        int total = (int) Math.pow(2, n) - 1;
        for (int i = 1; i <= total; i++) {
            switch (i % 3) {
                case 1:
                    move(src, dest, s, d);
                    break;
                case 2:
                    move(src, aux, s, a);
                    break;
                default:
                    move(aux, dest, a, d);
                    break;
            }
        }
    }

    static void move(Stack<Integer> tsrc, Stack<Integer> tdest, char ts, char td) {
        if (tsrc.isEmpty()) {
            tsrc.push(tdest.pop());
            System.out.println(td + "->" + ts);
        } else if (tdest.isEmpty()) {
            tdest.push(tsrc.pop());
            System.out.println(ts + "->" + td);
        } else if (tsrc.peek() < tdest.peek()) {
            tdest.push(tsrc.pop());
            System.out.println(ts + "->" + td);
        } else {
            tsrc.push(tdest.pop());
            System.out.println(td + "->" + ts);
        }
    }
}
