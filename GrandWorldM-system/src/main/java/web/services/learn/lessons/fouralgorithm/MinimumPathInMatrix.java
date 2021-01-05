package web.services.learn.lessons.fouralgorithm;

/**
 * 矩阵最短路径问题。
 *
 * @author heting.zhao
 * @since
 */
public class MinimumPathInMatrix {

    static int minPath = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 9}, {2, 1, 3, 4}, {5, 2, 6, 7}, {6, 8, 4, 3}};
        MinimumPathInMatrix m = new MinimumPathInMatrix();
//        m.backTrack(0, 0, matrix[0][0], matrix, matrix.length);
        minPath = m.dynamicProgramTable(matrix, 4);
        System.out.println("minPath: " + minPath);
    }

    /**
     * @param i
     * @param j
     * @param currentPath Summary of the value in matrix at current position.
     * @param matrix
     * @param dimension
     */
    private void backTrack(int i, int j, int currentPath, int[][] matrix, int dimension) {
        if (i == dimension - 1 && j == dimension - 1) {
            if (currentPath < minPath) {
                minPath = currentPath;
            }
            System.out.println(currentPath);
            return;
        }
        //turn right.
        if (j + 1 < dimension) {
            backTrack(i, j + 1, currentPath + matrix[i][j + 1], matrix, dimension);
        }
        //turn down.
        if (i + 1 < dimension) {
            backTrack(i + 1, j, currentPath + matrix[i + 1][j], matrix, dimension);
        }
    }

    /**
     * 动态规划一状态转移表法。
     *
     * @param matrix
     * @param dimension
     * @return
     */
    private int dynamicProgramTable(int[][] matrix, int dimension) {
        //calculate every value in the first row.
        int[][] pathArray = new int[dimension][dimension];
        int currentSum = 0;
        for (int column = 0; column < dimension; ++column) {
            currentSum += matrix[0][column];
            pathArray[0][column] = currentSum;
        }
        //first column.
        currentSum = 0;
        for (int row = 0; row < dimension; ++row) {
            currentSum += matrix[row][0];
            pathArray[row][0] = currentSum;
        }
        //the remainder of the matrix.
        for (int i = 1; i < dimension; ++i) {
            for (int j = 1; j < dimension; ++j) {
                pathArray[i][j] = matrix[i][j] + Math.min(pathArray[i][j - 1], pathArray[i - 1][j]);
            }
        }
        return pathArray[dimension - 1][dimension - 1];
    }
}
