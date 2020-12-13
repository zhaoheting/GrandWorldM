package web.services.learn.lessons.fouralgorithm;

/**
 * Back tracking algorithm to calculate eight queens issue.
 */
public class EightQueenIssue {

    private int[] result = new int[8];
    int count =0;

    public static void main(String[] args) {
        EightQueenIssue eightQueenIssue = new EightQueenIssue();
        eightQueenIssue.calculate8Queen(0);
    }

    /**
     * To calculate the correct column of the current row.
     *
     * @param row
     */
    private void calculate8Queen(int row) {
        if (row == 8) {
            printMatrix(result);
            System.out.println(++count);
            return;
        }
        //To calculate the correct column.
        for (int i = 0; i < 8; ++i) {
            if (isOk(row, i)) {
                result[row] = i;
                calculate8Queen(row + 1);
            }
        }
    }

    /**
     * To judge if the current position is ok to place an element.
     *
     * @param row
     * @param column
     * @return
     */
    private boolean isOk(int row, int column) {
        int leftUp = column - 1, rightUp = column + 1;
        for (int i = row - 1; i >= 0; --i) {
            //To check if the current column is used in the previous rows.
            if (result[i] == column) {
                return false;
            }
            //To check the diagonal line.
            if (leftUp >= 0) {
                if (result[i] == leftUp) {
                    return false;
                }
            }
            if (rightUp < 8) {
                if (result[i] == rightUp) {
                    return false;
                }
            }
            --leftUp;
            ++rightUp;
        }
        return true;
    }

    /**
     * Print a two-dimensional matrix to show the eight queens, and other position will be a asterisk.
     *
     * @param matrix
     */
    private void printMatrix(int[] matrix) {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (matrix[i] == j) {
                    System.out.print(j + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
