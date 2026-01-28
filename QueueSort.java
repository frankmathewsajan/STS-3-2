import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    Queue<Integer> q = new LinkedList<>();
	    
		int n = sc.nextInt();
		for (int i = 0;i<n;i++) {
		    q.offer(sc.nextInt());
		}
		System.out.println("Before sort : " + q);
		sort(q);
		System.out.println("After sort : " + q);
	}
	static void sort(Queue<Integer> q) {
	    int n = q.size();
	    for (int i=0;i<n ;i++ ) {
	        int M_VAL = 9999;
	        int M_IDX = -1;
	        for (int j=0;j<n ;j++ ) {
	            int t = q.poll();
	            if (t<M_VAL && j < n-i) {
	                M_VAL = t;
	                M_IDX = j;
	            }
	            q.offer(t);
	        }
	        for (int k=0;k<n;k++) {
	            int t = q.poll();
	            if (k!=M_IDX) {
	                q.offer(t);
	            }
	            
	        }
	        q.offer(M_VAL);
	        
	    }
	}
}
