package daily.september6;

import java.util.Arrays;
import java.util.List;

public class DistinctSubsequence {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        int result = numDistinct(s, t);
        System.out.println("Number of Distinct Subsequences: " + result);
    }
    public static void subsequence(List<String> ans, int i, String s, String ds) {
        if (i == s.length()) {
            ans.add(ds);
            return;
        }

        subsequence(ans, i + 1, s, ds + s.charAt(i));
        subsequence(ans, i + 1, s, ds);
    }

    public static int countSequence(int i, int j, String s, String t, int[][] mem) {
        if (j == t.length())
            return 1;
        if (i == s.length())
            return 0;

        if(mem[i][j]!=-1)
            return mem[i][j];
        int count = 0;
        if (s.charAt(i) == t.charAt(j)) {
            count = count + countSequence(i+1,j+1,s,t,mem);
        }

        count = count + countSequence(i+1,j,s,t,mem);
        mem[i][j] = count;
        return mem[i][j];

    }

    public static int numDistinct(String s, String t) {

        // Brute Force Approach
        // List<String> list1 = new ArrayList<>();

        // subsequence(list1,0,s,"");

        // int count = 0;
        // for(int i = 0; i<list1.size();i++){
        //     if(t.equals(list1.get(i)))
        //         count++;
        // }

        // return count;

        // Optimised approach using memorization

        int mem[][] = new int[s.length()+1][t.length()+1];

        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }
        


        return countSequence(0, 0, s, t, mem);

    }
}
