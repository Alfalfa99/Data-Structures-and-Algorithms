package JZoffer;

public class JZoffer12 {
    public static void main(String[] args) {

    }

    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (bfs(board,w,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean bfs(char[][] board, char[] w, int i, int j, int k) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || w[k] != board[i][j]) {
            return false;
        }
        if (k == w.length - 1) {
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean res = bfs(board, w, i - 1, j, k + 1) || bfs(board, w, i + 1, j, k + 1) ||
                bfs(board, w, i, j + 1, k + 1) || bfs(board, w, i, j - 1, k + 1);
        board[i][j] = tmp;
        return res;
    }
}
