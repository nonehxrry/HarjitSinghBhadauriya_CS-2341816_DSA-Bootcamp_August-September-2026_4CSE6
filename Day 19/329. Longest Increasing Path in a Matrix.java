class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int answer = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, dfs(matrix, i, j, dp));
            }
        }

        return answer;
    }

    private int dfs(int[][] matrix, int r, int c, int[][] dp) {
        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int maxPath = 1;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < m &&
                nc >= 0 && nc < n &&
                matrix[nr][nc] > matrix[r][c]) {

                maxPath = Math.max(
                    maxPath,
                    1 + dfs(matrix, nr, nc, dp)
                );
            }
        }

        dp[r][c] = maxPath;
        return maxPath;
    }
}
