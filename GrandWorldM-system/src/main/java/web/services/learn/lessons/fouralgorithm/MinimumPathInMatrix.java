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
        int[][] pathArray = new int[4][4];
        MinimumPathInMatrix m = new MinimumPathInMatrix();
//        m.backTrack(0, 0, matrix[0][0], matrix, matrix.length);
//        minPath = m.dynamicProgramTable(matrix, 4);
        minPath = m.dynamicProgramExpression(3, 3, matrix, pathArray);
        System.out.println("minPath: " + minPath);
    }

    /**
     * Solution in jike is wrong.
     *
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
     * Back track with memo array to reduce time complexity.
     *
     * @param i
     * @param j
     * @param matrix
     * @param currentPath
     * @param memoryArray
     */
    private static void backTrackWithMemo(int i, int j, int[][] matrix, int currentPath, int[][] memoryArray) {
        int length = matrix.length;
        currentPath = currentPath + matrix[i][j];
        memoryArray[i][j] = currentPath;
        if (i == length - 1 && j == length - 1) {
            minPath = Math.min(minPath, currentPath);
            System.out.println(minPath);
            return;
        }
        if (i + 1 < length && (memoryArray[i + 1][j] == 0 || memoryArray[i + 1][j] > currentPath + matrix[i + 1][j])) {
            backTrackWithMemo(i + 1, j, matrix, currentPath, memoryArray);
        }
        if (j + 1 < length && (memoryArray[i][j + 1] == 0 || memoryArray[i][j + 1] > currentPath + matrix[i][j + 1])) {
            backTrackWithMemo(i, j + 1, matrix, currentPath, memoryArray);
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

    /**
     * 动态规划-状态转移方程（递归加备忘录）。
     *
     * @return
     */
    private int dynamicProgramExpression(int row, int column, int[][] matrix, int[][] pathArray) {
        //
        if (row == 0 && column == 0) {
            return matrix[0][0];
        }
        //Don't recalculate the value int the same index.
        if (pathArray[row][column] > 0) {
            return pathArray[row][column];
        }
        //get the minimum of the left index.
        int leftMin = Integer.MAX_VALUE;
        if (column - 1 >= 0) {
            leftMin = dynamicProgramExpression(row, column - 1, matrix, pathArray);
        }
        //get the minimum of the up index.
        int upMin = Integer.MAX_VALUE;
        if (row - 1 >= 0) {
            upMin = dynamicProgramExpression(row - 1, column, matrix, pathArray);
        }
        //get the minimum of the current index.
        int currentMin = matrix[row][column] + Math.min(leftMin, upMin);
        pathArray[row][column] = currentMin;
        return currentMin;
    }
}
