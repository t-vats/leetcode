package daily.september7;

import java.util.Arrays;

public class DistinctSubsequence2 {
    private static final int MOD = 1_000_000_007;
    
    public static void main(String[] args){

        String s = "abc";
        int result = distinctSubseqII(s);
        System.out.println("Number of Distinct Subsequences: " + result);

    }

    

    public static int distinctSubseqII(String s) {
        int n = s.length();
        // memo[i] will store: "How many unique subsequences can we form starting from index i?"
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return countFrom(0, s, memo);
    }

    private static int countFrom(int index, String s, int[] memo) {
        // Base case: if we are past the end of the string, 0 extra strings
        if (index >= s.length()) return 0;

        // If we already calculated this position before, just return the answer!
        if (memo[index] != -1) return memo[index];

        long total = 0;

        // Try picking each letter 'a' through 'z' as our NEXT character
        for (char ch = 'a'; ch <= 'z'; ch++) {
            // Find the VERY FIRST occurrence of 'ch' starting from 'index'
            int firstPos = s.indexOf(ch, index);

            if (firstPos != -1) {
                // 1 (for the letter itself) + all unique strings we can make AFTER firstPos
                total = (total + 1 + countFrom(firstPos + 1, s, memo)) % MOD;
            }
        }

        // Save in memo and return
        return memo[index] = (int) total;
    }
}
