import java.util.*;
public class Main
{
  public static int[] stockSpan(int[] p, int n) {
    int[] res = new int[n];
    Stack<Integer> s = new Stack<>();
    res[0] = 1;
    s.push(0);
    for (int c = 1; c<n;c++) {
      while (!s.isEmpty() && p[s.peek()]<p[c]) s.pop();
      res[c] = s.isEmpty() ? (c+1) : c-s.peek();
    }  
    return res;
  }
	public static void main(String[] args) {
	  int n = 8;
	  int[] price = {100, 80, 60, 70, 60, 75, 85, 120};
	  int[] out = stockSpan(price, n);
	  for (int i = 0; i<n;i++) {
	    System.out.print(out[i] + " ");
	  }
	}
}
