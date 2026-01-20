class Solution {
    public long minimumTime(int[] d, int[] r) {
        long d1 = d[0], d2 = d[1];
        long r1 = r[0], r2 = r[1];

        long lcm = lcm(r1, r2);

        long low = 0, high = 2L * (d1 + d2);
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canFinish(mid, d1, d2, r1, r2, lcm)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canFinish(long T, long d1, long d2,
                              long r1, long r2, long lcm) {

        long avail1 = T - T / r1;
        long avail2 = T - T / r2;
        long totalAvail = T - T / lcm;

        if (d1 > avail1) return false;
        if (d2 > avail2) return false;
        if (d1 + d2 > totalAvail) return false;

        return true;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}