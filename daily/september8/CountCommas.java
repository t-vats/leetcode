package daily.september8;

public class CountCommas {
    public static void main(String[] args) {
        int input = 1002;
        int commaCount = countCommas(input);
        System.out.println("Number of commas: " + commaCount);
    }

    public static int countCommas(int n) {
        // 1 - 999 0
        // 1_000 - 999_999 1 : 10^3 -> 10^6 - 1 = 998_999
         
        // 1_000_000 - 999_999_999 : 10^6 -> 10^9 - 1

        if(n > 999)
            return (n - 999);
        return 0;

        // return Math.max(0, n-999) ;
        
    }
}
