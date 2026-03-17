import java.util.*;

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        
        for (int r = 1; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 1) {
                    matrix[r][c] += matrix[r - 1][c];
                }
            }
        }

        int maxArea = 0;

        for (int r = 0; r < m; r++) {
            int[] row = Arrays.copyOf(matrix[r], n);

            
            Arrays.sort(row);

            
            for (int i = n - 1; i >= 0; i--) {
                int height = row[i];
                int width = n - i;
                maxArea = Math.max(maxArea, height * width);
            }
        }

        return maxArea;
    }
}