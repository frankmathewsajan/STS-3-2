
public class TransposeMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] transposed = transpose(matrix);
        Transpose.printMatrix(transposed);
    }

    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        transposeHelper(matrix, result, 0, 0);
        return result;
    }

    private static void transposeHelper(int[][] matrix, int[][] result, int row, int col) {
        if (row >= matrix.length) {
            return;
        }
        if (col >= matrix[0].length) {
            transposeHelper(matrix, result, row + 1, 0);
            return;
        }
        result[col][row] = matrix[row][col];
        transposeHelper(matrix, result, row, col + 1);
    }
}
