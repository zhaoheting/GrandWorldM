package web.services.learn.lessons;

import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        solveNQueens(4);
    }
    public static List<List<String>> solveNQueens(int n) {
        int[] matrix = new int[n];
        Set<Integer> columnSet = new HashSet<>();
        Set<Integer> leftDiagonalSet = new HashSet<>();
        Set<Integer> rightDiagonalSet = new HashSet<>();
        List<List<String>> resultList = new ArrayList<>();
        backTrack(0, n, matrix, columnSet, leftDiagonalSet, rightDiagonalSet, resultList);
        return resultList;

    }
    private static void backTrack(int row, int n,
                           int[] matrix,
                           Set<Integer> columnSet,
                           Set<Integer> leftDiagonalSet,
                           Set<Integer> rightDiagonalSet,
                           List<List<String>> resultList){
        if(row == n){
            resultList.add(getCurrentSolution(matrix));
            columnSet.clear();
            leftDiagonalSet.clear();
            rightDiagonalSet.clear();
            return;
        }
        for(int column = 0; column < n; ++column){
            if(columnSet.contains(column)){
                continue;
            }
            int x = row - column;
            int y = row + column;
            if(leftDiagonalSet.contains(x)){
                continue;
            }
            if(rightDiagonalSet.contains(y)){
                continue;
            }
            matrix[row] = column;
            columnSet.add(column);
            leftDiagonalSet.add(x);
            rightDiagonalSet.add(y);
            backTrack(row+1, n, matrix, columnSet, leftDiagonalSet, rightDiagonalSet,resultList);
        }
    }

    private static List<String> getCurrentSolution(int[] matrix){
        List<String> result = new ArrayList<>();
        for(int row =0; row< matrix.length; ++row){
            StringBuilder currentLine = new StringBuilder();
            for(int column= 0; column < matrix.length; ++column){
                if(matrix[row] == column){
                    currentLine.append("Q");
                } else{
                    currentLine.append(".");
                }
            }
            result.add(currentLine.toString());
        }
        return result;
    }
}
