package com.huawei.colin.Problems;

/*
 * The following code creates a 3 x 3 tic-tac-toe grid filled with Xs.
 *
 * void tic-tac-toe() {
 *     String [][] grid = new String[3][3];
 *
 *     for(int i = 0; i<grid.length; i++) {
 *	       for (int j = 0; j<grid.length; j++) {
 *	           grid[i][j] = "X";
 *	       }
 *     }
 *     printArray(grid);
 * }
 * Write a method that will print a 2D array of any size.
 * Test it using the 3 x 3 tic-tac-toe grid given above
 *
 */

import java.math.BigDecimal;

public class TictactoeProblem {

    public static void main(String[] args) {
        tictactoe();
    }

    public static void tictactoe() {
        String [][] grid = new String[34][234];

        for(int i = 0; i<grid.length; i++) {
           for (int j = 0; j<grid[0].length; j++) {
               grid[i][j] = "X";
           }
        }
        printntArray(grid);
    }

    /**
     * Print the 2D array
     *
     * @param grid
     *        The 2D array to print
     */

    public static void printntArray(String[][] grid) {

        if (grid == null) {
            throw new IllegalArgumentException("grid is null");
        }

        int height = grid.length;
        int width = grid[0].length;
        System.out.println("The grid width = " + width + " and its height = " + height);

        for (int i = 0; i < height; i ++) {
            for (int j = 0; j < width; j++) {
                System.out.print("|" + grid[i][j]);
            }
            System.out.println("|");
        }
    }
}
