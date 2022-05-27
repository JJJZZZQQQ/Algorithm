package 力扣200题;

public class 单词搜索 {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int step) {
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0 || word.charAt(step) != board[i][j]) {
            return false;
        }
        if (step == word.length() - 1) {
            return true;
        }
        board[i][j] = '0';
        boolean res = dfs(board, word, i - 1, j, step + 1) ||
                dfs(board, word, i + 1, j, step + 1) ||
                dfs(board, word, i, j - 1, step + 1) ||
                dfs(board, word, i, j + 1, step + 1);
        board[i][j] = word.charAt(step);
        return res;
    }
}
