class Solution {
 public static void fillDirection(int[][] directions) {
        directions[0][0] = 0;
        directions[0][1] = 1;
        directions[1][0] = 1;
        directions[1][1] = 0;
        directions[2][0] = 0;
        directions[2][1] = -1;
        directions[3][0] = -1;
        directions[3][1] = 0;
    }

    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] directions = new int[4][2];
        fillDirection(directions);

        int[][] ans = new int[rows * cols][2];
        int count = 0;
        int max = Math.max(rows, cols);
        int dir = 0, steps = 0;

        ans[count][0] = rStart;
        ans[count][1] = cStart;
        count++;
        while (count < rows * cols) {
            if (dir == 0 || dir == 2)
                steps++;

            for (int i = 0; i < steps; i++) {
                rStart += directions[dir][0];
                cStart += directions[dir][1];

                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    ans[count][0] = rStart;
                    ans[count][1] = cStart;
                    count++;
                }
            }
            dir = (dir + 1) % 4;
        }

        return ans;
    }
}