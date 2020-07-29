package LeetCode;

public class LeetCode36 {
    // 9*9的数独
    private final int L = 9;
    public boolean isValidSudoku(char[][] board) {
        //rows[i][j]  用于判断整个大数独中第i列是否已经出现了j这个数
        boolean[][] rows = new boolean[L][L];
        //cols[i][j]  用于判断整个大数独中第i行是否已经出现了j这个数
        boolean[][] cols = new boolean[L][L];
        //boxes[i][j] 用于判断第i个3*3的方块内是否存在了j这个数
        // (数独的特性,一个3*3方块中不能出现两个相同的数)
        boolean[][] boxes = new boolean[L][L];

        for (int r = 0; r < L; ++r) {
            for (int c = 0; c < L; ++c) {
                if (board[r][c] != '.') {
                    //判断该数的值
                    int value = board[r][c] - '1';
                    //判断该数在哪个方块中
                    int boxIndex = r / 3 * 3 + c / 3;
                    //但凡不满足三个条件其一则说明该数独肯定不合规
                    if (rows[r][value] || cols[c][value] || boxes[boxIndex][value]) {
                        return false;
                    }
                    //设置为true继续进行下一个判断
                    rows[r][value] = true;
                    cols[c][value] = true;
                    boxes[boxIndex][value] = true;
                }
            }
        }
        return true;
    }
}
