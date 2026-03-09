class Solution {

    int MOD = 1000000007;
    long[][][] dp;

    public int numberOfStableArrays(int zero, int one, int limit) {

        dp = new long[zero + 1][one + 1][2];

        for (int i = 0; i <= zero; i++)
            for (int j = 0; j <= one; j++)
                dp[i][j][0] = dp[i][j][1] = -1;

        return (int)((solve(zero, one, 0, limit) + solve(zero, one, 1, limit)) % MOD);
    }

    private long solve(int z, int o, int last, int limit) {

        if (z == 0 && o == 0) return 1;

        if (dp[z][o][last] != -1) return dp[z][o][last];

        long ans = 0;

        if (last == 0) { 
            for (int i = 1; i <= limit && i <= o; i++) {
                ans = (ans + solve(z, o - i, 1, limit)) % MOD;
            }
        } else { 
            for (int i = 1; i <= limit && i <= z; i++) {
                ans = (ans + solve(z - i, o, 0, limit)) % MOD;
            }
        }

        return dp[z][o][last] = ans;
    }
}