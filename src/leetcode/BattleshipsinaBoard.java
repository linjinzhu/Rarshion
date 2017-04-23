package leetcode;

/**
 * Created by rarshion on 16/11/3.
 */
public class BattleshipsinaBoard {

    public int countBattleships(char[][] board) {

        int m = board.length, n = board[0].length;
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    board[i][j] = '.';
                    cnt++;
                    int a = i, b = j;
                    while (a + 1 < m && board[a + 1][b] == 'X') {
                        ++a;
                        board[a][b] = '.';
                    }

                    while (b + 1 < n && board[a][b + 1] == 'X') {
                        ++b;
                        board[a][b] = '.';
                    }
                }
            }
        }

        return cnt;
    }
}
