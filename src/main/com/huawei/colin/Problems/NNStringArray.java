package com.huawei.colin.Problems;

/*
 * Create an 8 x 8 Array to represent a chess board.
 * Print out the array with alternate ‘X’ and ‘O’ entries
 * as shown in the example:
 * XXXXOOOO
 * OXOXOOXO
 * XXXXOOOO
 * OXOXOOXO
 * XXXXOOOO
 * OXOXOOXO
 * XXXXOOOO
 * OXOXOOXO
 */
public class NNStringArray {

    private static String[] DIGITS = {"zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"};

    NNStringArray()
    {
        chess();
    }

    private void printArray(String [][] grid)
    {
        for(int i = 0; i<grid.length; i++)
        {
            for(int j = 0; j<grid.length; j++)
            {
                System.out.print(" | " + grid[i][j]);
            }
            System.out.println(" | ");
        }
    }

    void chess()
    {
        String [][] grid = new String[8][8];
        boolean fill = true;

        for(int i = 0; i<grid.length; i++)
        {
            for (int j = 0; j<grid.length; j++)
            {
                grid[i][j] = fill ? "X" : "O";
                fill = !fill;
            }
            fill = !fill;
        }
        printArray(grid);
    }

    /**
     * Translate digits into words
     *
     * @param digits
     *        Digits to translate
     */
    public static String digitsToWords(String digits) {
        if (digits == null) {
            throw new NullPointerException("digit can't be null");
        }
        StringBuilder str = new StringBuilder();
        int len = digits.length();
        for (int i = 0; i < len; i++ ) {
            int val;
            try {
                 val = Integer.parseInt(digits.charAt(i) + "");
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
                throw new IllegalArgumentException("only 0-9 is allowed");
            }
            str.append(DIGITS[val] + "|");
        }
        String result = str.toString();
        return result.substring(0, result.lastIndexOf("|"));
    }

    public static void main(String[] args) {
        // TODO code application logic here
//        new NNStringArray();
        System.out.println(digitsToWords("74982137598714938270498712823324"));
    }
}
