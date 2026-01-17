import java.util.*;

public class Celebrity {
    static int findCeleb(int[][] m, int n) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            st.push(i);
        }
        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();
            if (m[a][b] == 1) {
                st.push(b);
            } else {
                st.push(a);
            }
        }
        int celeb = st.pop();
        for (int i = 0; i < n; i++) {
            if (i != celeb && (m[celeb][i] == 1 || m[i][celeb] == 0)) {
                return -1;
            }
        }
        return celeb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        int result = findCeleb(mat, n);
        if (result == -1) {
            System.out.println("No celebrity found");
        } else {
            System.out.println("Celebrity is person " + result);
        }
        sc.close();
    }
}
