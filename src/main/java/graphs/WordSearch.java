package graphs;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
 * or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board = [ ['A','B','C','E'], ['S','F','C','S'], ['A','D','E','E'] ]
 *
 * Given word = "ABCCED", return true. Given word = "SEE", return true. Given word = "ABCB", return false.
 */
public class WordSearch {
  public static void main(String[] args) {
    char[][] board = {
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
    };
    WordSearch wordSearch = new WordSearch();
    System.out.println(wordSearch.exist(board, "ABCCED"));
  }

  private boolean exist(char[][] board, String word) {
    if (board == null || board.length == 0 || word == null) return false;

    int nr = board.length;
    int nc = board[0].length;

    for (int i = 0; i < nr; i++) {
      for (int j = 0; j < nc; j++) {
        if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) {
          return true;
        }
      }
    }

    return false;
  }

  private boolean dfs(char[][] board, String word, int row, int col, int index) {
    if (index == word.length()) {
      return true;
    }

    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
      return false;
    }

    char temp = board[row][col];
    board[row][col] = ' ';

    boolean result = dfs(board, word, row - 1, col, index + 1) ||
        dfs(board, word, row + 1, col, index + 1) ||
        dfs(board, word, row, col - 1, index + 1) ||
        dfs(board, word, row, col + 1, index + 1);

    board[row][col] = temp;

    return result;
  }

}
